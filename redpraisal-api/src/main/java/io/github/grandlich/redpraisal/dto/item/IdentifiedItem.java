package io.github.grandlich.redpraisal.dto.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IdentifiedItem extends Item {

  private Long id;

}
