package io.github.grandlich.redpraisal.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "market_log")
public class MarketLog implements Serializable {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  @Column(name = "max_buy")
  private BigDecimal maxBuy;
  @Column(name = "min_sell")
  private BigDecimal minSell;
  @Column(name = "date_time")
  private String dateTime;
  @Column(name = "sell_value")
  private Long sellValue;
  @Column(name = "buy_value")
  private Long buyValue;
  private String market;


}
