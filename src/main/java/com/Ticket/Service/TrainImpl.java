package com.Ticket.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ticket.Entity.*;
import com.Ticket.repository.TrainRepository;

@Service
public class TrainImpl implements TrainInterface {

	@Autowired
	TrainRepository dao;
	
	@Override
	public String findBytrainNumber(String trainNumber) {
		// TODO Auto-generated method stub
		Optional<Train> info= dao.findBytrainNumber(trainNumber);
		
		return info.map(Train::getTrainName).orElse("Train not found");
	}
}
