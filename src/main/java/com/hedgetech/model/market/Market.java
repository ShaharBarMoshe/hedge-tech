package com.hedgetech.model.market;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

@IdClass(MarketID.class)

@Entity(name = "market")
@Table(name = "market")

public class Market {

	@Id
	private Date timestamp;
	@Id
	private String symbol;
	private Integer price;
	
	
	
}
