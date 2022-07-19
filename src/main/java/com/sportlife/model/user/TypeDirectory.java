package com.sportlife.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sportlife.Enum.EnumState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="USR_TYPE_DIRECTORY")
@Entity
public class TypeDirectory {
	@EqualsAndHashCode.Include
	@Id
	private String idTypeDirectory;
	@Column(nullable = true, length = 5)
	private String idTypeDirectoryParent;
	@Column(nullable = true, length = 5)
	private String code;
	@Column(nullable = true, length = 200)
	private String description;
	@Column(nullable = false)
	private Integer level;
	@Column(nullable = false, length = 3)
	@Enumerated(EnumType.STRING)
	private EnumState status;

}
