package com.sportlife.dto.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sportlife.Enum.EnumStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserDirectoryDTO {

	@EqualsAndHashCode.Include
	private Integer idUser;
	private String idTypeDirectory;
	@Size(max=200, message = "{description.size}")
	private String description;
	@NotNull
	@Size(max=3, message = "{description.size}")
	private EnumStatus status;
	@NotNull
	private TypeDirectoryDTO typeDirectoryDTO;
}
