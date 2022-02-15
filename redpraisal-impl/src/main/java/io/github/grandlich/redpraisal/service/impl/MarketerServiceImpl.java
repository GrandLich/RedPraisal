package io.github.grandlich.redpraisal.service.impl;

import io.github.grandlich.redpraisal.config.PraisalConfiguration;
import io.github.grandlich.redpraisal.domain.entity.MarketLog;
import io.github.grandlich.redpraisal.domain.repository.MarketLogRepository;
import io.github.grandlich.redpraisal.dto.AppraisalResponse;
import io.github.grandlich.redpraisal.dto.AppraisalResponseItem;
import io.github.grandlich.redpraisal.service.AppraisalCommunicationService;
import io.github.grandlich.redpraisal.service.MarketerService;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MarketerServiceImpl implements MarketerService {

  private static final DateTimeFormatter LOG_DATETIME_FORMATTER = DateTimeFormatter.ofLocalizedDateTime(
      FormatStyle.SHORT);

  private final AppraisalCommunicationService communicationService;
  private final MarketLogRepository marketLogRepository;
  private final PraisalConfiguration config;
  private int cycleNum = 0;

  @Override
  @Scheduled(fixedRate = 5, timeUnit = TimeUnit.MINUTES)
  public void queryMarket() {
    long time = System.currentTimeMillis();
    log.info("{} - Its time to fetch data from EVE-Praisal. Cycle #{}",
        LOG_DATETIME_FORMATTER.format(ZonedDateTime.now()),
        ++cycleNum);
    config.getMarkets().forEach(market -> {
      AppraisalResponse response = communicationService.query(market, config.getItemList());
      List<MarketLog> logs = parseAndProvideLogs(response);
      logs.forEach(marketLog -> {
        log.info("{}: Found {} {}`s", marketLog.getMarket(),
            (marketLog.getBuyValue() + marketLog.getSellValue()),
            marketLog.getName());
        marketLogRepository.save(marketLog);
      });
    });
    log.info("Completed fetching data #{} - OK ({} ms)", cycleNum, System.currentTimeMillis() - time);
  }

  private List<MarketLog> parseAndProvideLogs(AppraisalResponse response) {
    List<MarketLog> out = new ArrayList<>();
    for (AppraisalResponseItem item : response.getContent().getItems()) {
      MarketLog log = MarketLog.builder()
          .market(response.getContent().getMarket_name())
          .name(item.getName())
          .dateTime(LOG_DATETIME_FORMATTER.format(ZonedDateTime.now()))
          .maxBuy(item.getPrices().getBuy().getMax())
          .minSell(item.getPrices().getSell().getMin())
          .buyValue(item.getPrices().getBuy().getVolume())
          .sellValue(item.getPrices().getSell().getVolume())
          .created(System.currentTimeMillis() / 1000)
          .build();
      out.add(log);
    }
    return out;
  }
}
