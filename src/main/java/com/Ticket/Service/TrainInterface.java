package com.Ticket.Service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Ticket.Entity.Train;

public interface TrainInterface{	
	public String findBytrainNumber(String trainNumber);

//	String findTrainNameByTrainNumber(String trainNumber);
}
