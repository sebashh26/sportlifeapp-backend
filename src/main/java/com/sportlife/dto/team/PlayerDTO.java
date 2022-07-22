package com.sportlife.dto.team;

import java.math.BigDecimal;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sportlife.Enum.EnumStatus;
import com.sportlife.Enum.EnumYesNo;
import com.sportlife.dto.user.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

	@EqualsAndHashCode.Include
	private Integer idUser;						
	
	@JsonIgnore
	private UserDTO userDTO;
	
	private byte[] imageIdentificaction;
	
	@Enumerated(EnumType.STRING)
	private EnumYesNo delegate;
	
	@Size(max = 200, message = "{fullNameDelegate.size}")
	private String fullNameDelegate;
	
	@Size(min = 10, max = 10, message = "{identification.size}")
	private String identificationDelegate;
	
	@Size(max = 10)
	private String phoneDelegate;
	
	@Size(max = 200)
	private String direction;
	
	private Integer idPosition;
	
	private Integer idExtremity;
	
	private Integer idLaterality;
	
	@Size(max = 50)
	private String instagram;
	
	@Size(max = 200)
	private String description;
	
	@DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=22, fraction=2, message = "{size.size}")
    private BigDecimal size; 
	
	@DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer=22, fraction=2, message = "{size.size}")
	private BigDecimal weight; 
	
	@Enumerated(EnumType.STRING)
	private EnumStatus status;
}
