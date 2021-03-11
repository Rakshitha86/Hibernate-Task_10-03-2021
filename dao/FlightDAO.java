package com.xworkz.dao;

import com.xworkz.dto.FlightDTO;

public interface FlightDAO {

	void saveFlight(FlightDTO dto);

	boolean readFlight(int Flightid);

	boolean updateFlight(int Flightid);

	boolean deleteFlight(int Flightid);

}
