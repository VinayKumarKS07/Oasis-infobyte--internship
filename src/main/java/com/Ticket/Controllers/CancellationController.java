package com.Ticket.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Ticket.Entity.TicketBooking;
import com.Ticket.Service.Ticketbooking;
import com.Ticket.Service.Ticketbookingimpl;

@Controller
public class CancellationController {

     @Autowired	
	 Ticketbookingimpl service;
	
	@RequestMapping("/cancelReservation")
	public String Cancel() {
		return "cancelform";
	}
	

	@PostMapping("/processDelete")
	public String deletepassenger(@RequestParam("id") Integer id , Model m) {

		service.deletepassengersbyId(id);
		
		m.addAttribute("message", "Ticket cancellation Successful");

		return "welcome";
	}

}
