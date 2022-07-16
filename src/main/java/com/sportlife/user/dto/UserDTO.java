package com.sportlife.user.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private String firstName;
	private String secondName;
	private String lastName;
	private String secondSurname;
	private String idTypeIdentification;
	private String identification;
	private String phoneCell;
	private String phoneHouse;
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
