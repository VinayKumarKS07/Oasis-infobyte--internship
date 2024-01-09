package com.Ticket.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Booked_Tickets")
public class TicketBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Ticket_id;
	@NotBlank(message="This should be filled")
//	@Transient
	String Train_Number;
	@NotBlank(message="This should be filled")
	
	String Train_Name;
	
	String startLocation;
	@NotBlank(message ="This should be filled")
	String endLocation;
	
	LocalDateTime dateTime;
	
	String classType;
	
	String trainType;

	public long getId() {
		// TODO Auto-generated method stub
		return Ticket_id;
	}
	
//	@ManyToOne
//	@JoinColumn(name ="trainNumber")
//	Train train;
	
}
