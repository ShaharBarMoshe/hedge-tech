package com.hedgetech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hedgetech.model.instrument.Instrument;


@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, String> {
//	List<Instrument> findBySymbol();

}
