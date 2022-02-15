package io.github.grandlich.redpraisal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.grandlich.redpraisal.dto.item.Item;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppraisalRequest {

  @JsonProperty("market_name")
  private String marketName;
  private List<Item> items;

}
