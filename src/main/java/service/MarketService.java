package service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hedgetech.model.market.Market;
import com.hedgetech.repository.MarketRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MarketService {
	@Autowired
	MarketRepository marketRepository;
	
	@Autowired
	PortfolioService portfolioService;
	
	@Value("${hist: 90}")
	String hist;

	
	
	public List<Market> calculateHistoricMarketData(String symbol) {
		Calendar c = Calendar.getInstance();
		int intHist = Integer.parseInt(hist); // from the aws config file
		c.setTime(portfolioService.getExecutionDate());
		c.add(Calendar.DAY_OF_YEAR, -1 * intHist);
		return marketRepository.findBySymbolAndTimestampBefore(symbol, c.getTime());
	}
	
}
