package com.Ticket.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ticket.Entity.Train;

public interface TrainRepository extends JpaRepository<Train, String>
{

	
	Optional<Train> findBytrainNumber(String trainNumber);

}
