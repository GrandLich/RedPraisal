package io.github.grandlich.redpraisal.domain.repository;

import io.github.grandlich.redpraisal.domain.entity.MarketLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketLogRepository extends JpaRepository<MarketLog, Long> {

}
