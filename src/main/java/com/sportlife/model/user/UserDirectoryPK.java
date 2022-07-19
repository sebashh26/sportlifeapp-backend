package com.sportlife.model.user;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDirectoryPK implements Serializable {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 3843734923007715923L;
	//@EqualsAndHashCode.Include
	private Integer idUser;
	//@EqualsAndHashCode.Include
	private String idTypeDirectory;
//	private String idLeague;
//	private String idTeam;

	@Override
	public int hashCode() {
		return Objects.hash( idTypeDirectory, idUser);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object object) {
		boolean igual = true;
		if (!(object instanceof UserDirectoryPK)) {
			igual = false;
		}
		UserDirectoryPK other = (UserDirectoryPK) object;
		if ((this.idUser == null && other.idUser != null)
				|| (this.idUser != null && !this.idUser.equals(other.idUser))) {
			igual = false;
		}
		if ((this.idTypeDirectory == null && other.idTypeDirectory != null)
				|| (this.idTypeDirectory != null && !this.idTypeDirectory.equals(other.idTypeDirectory))) {
			igual = false;
		}
//		if ((this.idLeague == null && other.idLeague != null)
//				|| (this.idLeague != null && !this.idLeague.equals(other.idLeague))) {
//			igual = false;
//		}
//		if ((this.idTeam == null && other.idTeam != null)
//				|| (this.idTeam != null && !this.idTeam.equals(other.idTeam))) {
//			igual = false;
//		}
		return igual;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "UserDirectoryPK[" + " secuenciaVisitaInmueble=" + this.idUser + ",idTypeDirectory="
				+ this.idTypeDirectory + "]";
	}

}
