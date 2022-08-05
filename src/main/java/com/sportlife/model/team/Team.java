package com.sportlife.model.team;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Entity
@Table(name = "TAM_TEAM")
public class Team {

	@Id
	@EqualsAndHashCode.Include
	private String idTeam;

	@Column(nullable = false, length = 100)
	private String nameTeam;

	@Column(nullable = false, length = 50)
	private String colorTeam;

	@Column(nullable = true, length = 1000)
	private String abstractTeam;

	@Column(nullable = false)
	private LocalDate fundationDate;

	@Column(nullable = true, length = 50)
	private String mailTeam;

	@Column(nullable = true, length = 15)
	private String rucTeam;

	@Column(nullable = true, length = 50)
	private String idLegalPersonality;

	@Column(nullable = false)
	private LocalDate dateEmisionLegalPersonality;

	@Column(nullable = true, length = 100)
	private String direcctionTeam;

	@Column(nullable = true, length = 50)
	private String personContact;

	@Column(nullable = true, length = 10)
	private String phoneContact;

	@Column(nullable = true, length = 3)
	@Enumerated(EnumType.STRING)
	private EnumStatus status;

	@Column(nullable = false)
	private LocalDate createdAt;

	@Column(nullable = true, length = 3)
	@Enumerated(EnumType.STRING)
	private EnumYesNo isSelection;

	@Column(nullable = true)
	private String idLeague;

	@Column(nullable = true, length = 50)
	private String coach;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "team")
	//@ToString.Exclude
	private List<TeamPlayer> teamPlayers= new ArrayList<>();
}
