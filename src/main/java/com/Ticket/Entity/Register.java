package com.Ticket.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@NotNull(message = "This field should not be empty")
	String firstName;
	@NotNull(message = "This field should not be empty")
	String lastName;
	@NotNull(message = "this field should not be empty")
	@Size(min = 5, message = "Username Should be atleast 5 characters")
	String username;
	@NotNull(message = "This field should not be empty")
	String email;

	@NotBlank(message = "Password should not be blank")
	@Size(min = 7, message = "Password should be atleast 7 characters")
	String password;
}
