package io.github.grandlich.redpraisal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppraisalResponseItemPrices {

  private AppraisalResponseItemPricesSection all;
  private AppraisalResponseItemPricesSection buy;
  private AppraisalResponseItemPricesSection sell;
  private String strategy;
  private String updated;

}
