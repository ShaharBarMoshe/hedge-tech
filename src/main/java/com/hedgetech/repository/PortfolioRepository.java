package com.hedgetech.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hedgetech.model.portfolio.Portfolio;
import com.hedgetech.model.portfolio.PortfolioID;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, PortfolioID> {
	@Query(value = "SELECT * FROM portfolio order by random() limit 1", nativeQuery = true)
	Portfolio findRandom();

	List<Portfolio> findByTimestampLessThanEqualOrderByTimestampDesc(Date date) ;
}
