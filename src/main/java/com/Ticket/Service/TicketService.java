package com.Ticket.Service;

import java.util.List;

import com.Ticket.Entity.Register;
import com.Ticket.Entity.TicketBooking;
import com.Ticket.Entity.Train;

public interface TicketService {

	public void save(Register register);
	
	public List<Register> NewUsers();
	

	

}
