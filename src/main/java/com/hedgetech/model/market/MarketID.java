package com.hedgetech.model.market;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MarketID implements Serializable {
	
	private static final long serialVersionUID = 8453351212040298989L;
	private Date timestamp;
	private String symbol;
}
