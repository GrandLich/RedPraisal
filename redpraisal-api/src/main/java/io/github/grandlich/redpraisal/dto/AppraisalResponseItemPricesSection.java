package io.github.grandlich.redpraisal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.math.BigInteger;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppraisalResponseItemPricesSection {

  private BigDecimal avg;
  private BigInteger max;
  private BigInteger median;
  private BigInteger min;
  private Long order_count;
  private BigDecimal percentile;
  private Long stddev;
  private Long volume;
}
