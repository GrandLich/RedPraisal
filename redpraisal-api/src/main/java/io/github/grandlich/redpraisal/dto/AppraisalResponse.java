package io.github.grandlich.redpraisal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
public class AppraisalResponse {

  @JsonProperty("appraisal")
  private AppraisalResponseBody content;

  @Data
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class AppraisalResponseBody {

    private Long created;
    private String id;
    private List<AppraisalResponseItem> items;
    private String kind;
    private String market_name;
    private String raw;
  }

}
