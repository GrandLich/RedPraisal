package io.github.grandlich.redpraisal.service.impl;

import io.github.grandlich.redpraisal.config.PraisalConfiguration;
import io.github.grandlich.redpraisal.service.PruneDataService;
import java.util.concurrent.TimeUnit;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PruneDataServiceImpl implements PruneDataService {

  private final DataSource dataSource;
  private final PraisalConfiguration configuration;

  @Override
  @Scheduled(fixedRate = 30, timeUnit = TimeUnit.MINUTES)
  public void prune() {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    long current = System.currentTimeMillis() / 1000;
    int pruned = jdbcTemplate.update(
        "DELETE FROM market_log WHERE `created` < ? OR `created` IS NULL",
        (current - configuration.getLogLifetime()));
    log.info("Cleaner pruned {} rows", pruned);
  }
}
