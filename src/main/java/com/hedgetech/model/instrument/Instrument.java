package com.hedgetech.model.instrument;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.hedgetech.model.market.MarketID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor


@Entity(name = "instrument")
@Table(name = "instrument")
public class Instrument {

	@Id
	private String id;
	private String symbol;

	
}
