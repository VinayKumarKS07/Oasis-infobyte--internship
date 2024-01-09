package com.Ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ticket.Entity.Register;

public interface TicketRepository extends JpaRepository<Register, Integer> {

	
}
