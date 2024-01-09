package com.Ticket.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Ticket.Entity.Register;
import com.Ticket.Entity.TicketBooking;
import com.Ticket.Service.TicketServiceImpl;
import com.Ticket.Service.TrainImpl;

import jakarta.validation.Valid;

@Controller

public class RegisterController {

	@Autowired
	TicketServiceImpl service;
	@Autowired
	TrainImpl service2;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new Register());
		return "register";
	}

	@GetMapping("/aboutInfo")
	public String aboutInfo() {
		return "About";
	}

	@PostMapping("/process")
	public String processRegistration(@Valid @ModelAttribute("user") Register user, BindingResult result) {
		if (result.hasErrors()) {
			return "register";
		}
		service.save(user);
		return "redirect:/home";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/welcome")
	public String welcomepage() {
		return "Welcome";
	}

	@PostMapping("/processLogin")
	public String processLogin(@RequestParam("username") String userName, @RequestParam("password") String Password,
			Model m) {
		List<Register> list = service.NewUsers();

		for (Register user : list) {
			if (user.getUsername().equalsIgnoreCase(userName) && user.getPassword().equalsIgnoreCase(Password)) {
				return "Welcome";
			}
		}
		m.addAttribute("message",
				"Invalid Credentials , Incase if you are not registered Do registration and Continue");
		return "login";
	}

	@RequestMapping("/viewForm")
	public String viewticketBooking(Model m) {
		m.addAttribute("details", new TicketBooking());
		return "form";
	}

	@RequestMapping("/showAllTicket")
	public String showAllTicket(Model m) {
		List<TicketBooking> list = service.getAllTicket();
		m.addAttribute("ticket", list);
		return "AllTicket";
	}

	@PostMapping("/processform")
	public String processBooking(@Valid @ModelAttribute("details") TicketBooking booking, BindingResult br,
			@RequestParam("Train_Number") String trainNumber, Model m) {
		if (br.hasErrors()) {
			return "form";
		}
		service.details_of_Booking(booking);
		long generatedId = booking.getId();
		m.addAttribute("details", booking);
		m.addAttribute("trainNo", booking.getTrain_Number());
		m.addAttribute("id", generatedId); // Use the generated id
		m.addAttribute("train", booking.getTrain_Name());

		return "AfterBookingTicket";
	}

	@GetMapping("/getTrainName")
	@ResponseBody
	public String getTrainName(@RequestParam("trainNumber") String trainNumber, Model m) {
		// Fetch train name from the database based on the train number
		String trainName = service2.findBytrainNumber(trainNumber);
		if (trainName == null) {
			m.addAttribute("Message", "Train doesn't exist, Check the number you entered");
		}
		return trainName != null ? trainName : "";
	}
	

	@RequestMapping("/logout")
	public String logout(){
		
		return "home";
		
	}
	
}
