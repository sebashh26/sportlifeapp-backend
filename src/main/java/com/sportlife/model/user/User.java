package com.sportlife.model.user;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sportlife.Enum.EnumState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USR_USER")
public class User {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	@Column(nullable = false, length = 50)
	private String firstName;
	@Column(nullable = true, length = 50)
	private String secondName;
	@Column(nullable = false, length = 50)
	private String lastName;
	@Column(nullable = true, length = 50)
	private String secondSurname;
	@Column(nullable = false, length = 3)
	private String idTypeIdentification;
	@Column(nullable = false, length = 15, unique = true)
	private String identification;
	@Column(nullable = true, length = 15)
	private String phoneCell;
	@Column(nullable = true, length = 15)
	private String phoneHouse;
	@Column(nullable = false, length = 50)
	private String mail;
	@Column(nullable = false)
	private LocalDate dateOfBirth;
	@Column(nullable = false, length = 3)
	private String idSex;
	@Column(nullable = false, length = 3)
	@Enumerated(EnumType.STRING)
	private EnumState status;
	@Column(nullable = true, length = 15)
	private String blackList;
	@Column(nullable = false, length = 50)
	private String password;
	@Column(nullable = false)
	private LocalDate createdAt;
	@Column(nullable = false)
	private LocalDate lastLogin;
	@Column(nullable = true)
	private byte[] imageUser;
	@Column(nullable = true, length = 5)
	private String idCountryOrigin;
	@Column(nullable = true, length = 5)
	private String idCountryCurrent;
	@Column(nullable = false, length = 3)
	private String idCivilStatus;
	@Column(nullable = true)
	private Integer failegLoginAttempts;	
	
}
