package com.hedgetech.model.portfolio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@IdClass(PortfolioID.class)
@Entity(name = "portfolio")
@Table(name = "portfolio")
public class Portfolio {
	@Id
	Date timestamp;
	@Id
	String account;
	@Id
	String instrument;
	Double amount;

}
