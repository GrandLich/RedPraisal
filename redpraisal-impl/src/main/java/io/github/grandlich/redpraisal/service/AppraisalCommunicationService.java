package io.github.grandlich.redpraisal.service;

import io.github.grandlich.redpraisal.dto.AppraisalResponse;
import io.github.grandlich.redpraisal.dto.item.Item;
import java.util.List;

public interface AppraisalCommunicationService {

  AppraisalResponse query(String marketName, List<Item> items);

}
