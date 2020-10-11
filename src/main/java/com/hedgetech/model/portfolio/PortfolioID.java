package com.hedgetech.model.portfolio;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PortfolioID implements Serializable {
	
	private static final long serialVersionUID = -6760926983595307326L;
	Date timestamp;
	String account;
	String instrument;

	
}