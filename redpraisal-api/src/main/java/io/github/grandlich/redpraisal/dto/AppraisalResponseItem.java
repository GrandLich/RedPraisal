package io.github.grandlich.redpraisal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppraisalResponseItem {

  private String name;
  private AppraisalResponseItemPrices prices;
  private Long quantity;
  private Long typeID;
  private String typeName;
  private Long typeVolume;

}
