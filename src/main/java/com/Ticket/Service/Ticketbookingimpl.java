package com.Ticket.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ticket.Entity.TicketBooking;
import com.Ticket.Service.Ticketbooking;
import com.Ticket.repository.TicketBookingRepository;

@Service
public class Ticketbookingimpl implements Ticketbooking  {

	@Autowired
	TicketBookingRepository dao;
	
	public void details_of_Booking(TicketBooking booking) {
		dao.save(booking);
	}
	
	public void deletepassengersbyId(Integer id) {
		
		dao.deleteById(id);

	}

	
	
	
}
