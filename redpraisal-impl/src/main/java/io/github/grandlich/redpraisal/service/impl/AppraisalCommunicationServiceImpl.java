package io.github.grandlich.redpraisal.service.impl;

import io.github.grandlich.redpraisal.dto.AppraisalRequest;
import io.github.grandlich.redpraisal.dto.AppraisalResponse;
import io.github.grandlich.redpraisal.dto.item.Item;
import io.github.grandlich.redpraisal.service.AppraisalCommunicationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppraisalCommunicationServiceImpl implements AppraisalCommunicationService {

  private final RestTemplate restTemplate = new RestTemplate();
  @Value("${praisal.url}")
  private String url;

  @Override
  public AppraisalResponse query(String marketName, List<Item> items) {
    AppraisalRequest request = AppraisalRequest.builder()
        .marketName(marketName)
        .items(items)
        .build();

    return restTemplate.postForObject(url, request, AppraisalResponse.class);
  }
}
