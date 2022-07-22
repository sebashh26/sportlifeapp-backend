package com.sportlife.dto.team;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.sportlife.Enum.EnumStatus;
import com.sportlife.Enum.EnumYesNo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {

	@EqualsAndHashCode.Include
	private String idTeam;
	
	@Size(max = 100, message = "{nameTeam.size}")
	@NotEmpty(message = "{nameTeam.notEmpty}")
	private String nameTeam;
	
	@Size(max = 50, message = "{colorTeam.size}")
	@NotEmpty(message = "{colorTeam.notEmpty}")
	private String colorTeam;
	
	@Size(max = 10000, message = "{abstractTeam.size}")
	private String abstractTeam;
	
	private LocalDate fundationDate;
	
	@Email
	private String mailTeam;
	
	@Size(max = 15, message = "{rucTeam.size}")
	private String rucTeam;
	
	@Size(max = 50, message = "{idLegalPersonality.size}")
	private String idLegalPersonality;
	
	private LocalDate dateEmisionLegalPersonality;
	
	@Size(max = 100, message = "{direcctionTeam.size}")
	private String direcctionTeam;
	
	@Size(max = 50, message = "{personContactTeam.size}")
	private String personContact;
	
	@Size(max = 10, message = "{phoneContactTeam.size}")
	private String phoneContact;
	
	@Enumerated(EnumType.STRING)
	private EnumStatus status;
	
	private LocalDate createdAt;
	
	@Enumerated(EnumType.STRING)
	private EnumYesNo isSelection;
	
	private String idLeague;
	
	@Size(max = 50, message = "{coach.size}")
	private String coach;
}
