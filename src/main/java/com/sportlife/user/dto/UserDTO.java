package com.sportlife.user.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Integer idUser;
	@NotEmpty
	@Size(min = 50, message = "firstName is required")
	private String firstName;
	private String secondName;
	@NotNull
	@Size(min = 5, message = "firstName is required")
	private String lastName;
	private String secondSurname;
	private String idTypeIdentification;
	@Size(min = 10)
	private String identification;
	private String phoneCell;
	private String phoneHouse;
	@Email
	private String mail;
	private LocalDate dateOfBirth;
	private String idSex;
	private String status;
	private String blackList;
	private String password;
	private byte[] imageUser;
	private String idCountryOrigin;
	private String idCountryCurrent;
	private String idCivilStatus;
}
