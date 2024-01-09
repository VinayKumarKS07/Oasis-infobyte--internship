package com.Ticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ticket.Entity.Register;
import com.Ticket.Entity.TicketBooking;
import com.Ticket.repository.TicketBookingRepository;
import com.Ticket.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketRepository dao;
	
	@Autowired
	TicketBookingRepository dao2;
	public void save(Register register ) {
		 dao.save(register);
	}
	public List<Register> NewUsers(){
	   List<Register> register =(List<Register>)dao.findAll();
	   return register;
	}
	public void details_of_Booking(TicketBooking booking) {
//		System.out.println(dao2.findById(null));
		dao2.save(booking);
	}

	public List<TicketBooking> getAllTicket() {
		return dao2.findAll();
	}
}
