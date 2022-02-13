package io.github.grandlich.redpraisal.dto;

import io.github.grandlich.redpraisal.dto.item.Item;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AppraisalRequest {

  private String market_name;
  private List<Item> items;

}
