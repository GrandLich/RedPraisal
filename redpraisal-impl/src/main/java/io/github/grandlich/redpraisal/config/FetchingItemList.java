package io.github.grandlich.redpraisal.config;

import io.github.grandlich.redpraisal.dto.item.Item;
import io.github.grandlich.redpraisal.dto.item.NamedItem;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "praisal")
@Data
public class FetchingItemList {

  private List<String> items;

  public List<Item> get() {
    return items.stream().map(NamedItem::new).collect(Collectors.toList());
  }
}
