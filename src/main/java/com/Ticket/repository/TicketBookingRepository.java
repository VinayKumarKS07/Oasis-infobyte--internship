package com.Ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ticket.Entity.TicketBooking;
import com.Ticket.Entity.Train;

public interface TicketBookingRepository extends JpaRepository<TicketBooking, Integer> {
//	public Train findtrainNameBytrainNumber(String trainNumber);
}
