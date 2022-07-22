package com.sportlife.dto.user;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sportlife.Enum.EnumStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	@EqualsAndHashCode.Include
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
	@Enumerated(EnumType.STRING)
	private EnumStatus status;
	private String blackList;
	private String password;
	private byte[] imageUser;
	private String idCountryOrigin;
	private String idCountryCurrent;
	private String idCivilStatus;
}
