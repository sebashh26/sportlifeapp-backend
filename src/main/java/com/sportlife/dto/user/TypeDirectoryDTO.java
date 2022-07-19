package com.sportlife.dto.user;

import javax.validation.constraints.NotNull;

import com.sportlife.Enum.EnumState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class TypeDirectoryDTO {
	
	@EqualsAndHashCode.Include
	private String idTypeDirectory;
	private String idTypeDirectoryParent;
	@NotNull
	private String code;
	private String description;
	@NotNull
	private Integer level;
	private EnumState status;	
}
