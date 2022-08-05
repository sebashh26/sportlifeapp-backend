package com.sportlife.dto.team;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamPlayerDTO {

	@NotNull
	private PlayerDTO playerDTO;
	
	@NotNull
	private TeamDTO teamDTO;
}
