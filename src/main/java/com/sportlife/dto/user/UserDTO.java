package com.sportlife.dto.user;

import java.time.LocalDate;

import javax.validation.constraints.Email;
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
	@Size(min = 3, message = "{firstName.size}")
	private String firstName;
	private String secondName;
	@NotNull
	@Size(min = 3, message = "{lastName.size}")
	private String lastName;
	private String secondSurname;
	private String idTypeIdentification;
	@Size(min = 10, max = 10, message = "{identification.size}")
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
