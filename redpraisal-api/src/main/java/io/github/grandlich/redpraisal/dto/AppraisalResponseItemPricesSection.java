package io.github.grandlich.redpraisal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppraisalResponseItemPricesSection {

  private BigDecimal avg;
  private BigDecimal max;
  private BigDecimal median;
  private BigDecimal min;
  private Long order_count;
  private BigDecimal percentile;
  private Long stddev;
  private Long volume;
}
