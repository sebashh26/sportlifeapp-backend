package com.sportlife.model.team;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sportlife.Enum.EnumStatus;
import com.sportlife.Enum.EnumYesNo;
import com.sportlife.model.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TAM_PLAYER")
public class Player {

	@EqualsAndHashCode.Include
	@Id
	private Integer idUser;

	@Column(nullable = true)
	private byte[] imageIdentificaction;

	@Column(nullable = true, length = 3)
	@Enumerated(EnumType.STRING)
	private EnumYesNo delegate;

	@Column(nullable = true, length = 200)
	private String fullNameDelegate;

	@Column(nullable = true, length = 10)
	private String identificationDelegate;

	@Column(nullable = true, length = 10)
	private String phoneDelegate;

	@Column(nullable = true, length = 200)
	private String direction;

	@Column(nullable = true)
	private Integer idPosition;

	@Column(nullable = true)
	private Integer idExtremity;

	@Column(nullable = true)
	private Integer idLaterality;

	@Column(nullable = true, length = 50)
	private String instagram;

	@Column(nullable = true, length = 200)
	private String description;

	@Column(nullable = false, precision = 22, scale = 2)
	private BigDecimal size;

	@Column(nullable = false, precision = 22, scale = 2)
	private BigDecimal weight;

	@Column(nullable = true, length = 3)
	@Enumerated(EnumType.STRING)
	private EnumStatus status;

	//use merge to fushion owner with the l but make a select of owner
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_user")
	@MapsId// without value because use tehe same identifier of pk 
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
	@ToString.Exclude
	private List<TeamPlayer> playerTeams= new ArrayList<TeamPlayer>();
	
	
}
