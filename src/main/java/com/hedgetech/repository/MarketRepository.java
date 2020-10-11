package com.hedgetech.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.hedgetech.model.market.Market;
import com.hedgetech.model.market.MarketID;
import com.hedgetech.model.portfolio.Portfolio;


@Repository
public interface MarketRepository extends JpaRepository<Market, MarketID> {
	List<Market> findByTimestampBefore(Date date);
	List<Market> findBySymbolAndTimestampBefore(String symbol, Date date) ;
	List<Market> findBySymbolAndTimestamp(String symbol, Date date) ;


}
