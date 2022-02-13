package io.github.grandlich.redpraisal.dto.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NamedItem extends Item {

  private String name;

}
