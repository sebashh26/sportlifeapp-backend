package com.sportlife.model.team;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamPlayerPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	private Integer idPlayer;
	@Column(nullable = false)
	private String idTeam;

	@Override
	public int hashCode() {
		return Objects.hash(idTeam, idPlayer);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object object) {
		boolean igual = true;
		if (!(object instanceof TeamPlayerPK)) {
			igual = false;
		}
		TeamPlayerPK other = (TeamPlayerPK) object;
		if ((this.idPlayer == null && other.idPlayer != null)
				|| (this.idPlayer != null && !this.idPlayer.equals(other.idPlayer))) {
			igual = false;
		}
		if ((this.idTeam == null && other.idTeam != null)
				|| (this.idTeam != null && !this.idTeam.equals(other.idTeam))) {
			igual = false;
		}
		return igual;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "TeamPlayerPK[" + this.idPlayer + ",idTeam=" + this.idTeam + "]";
	}
}
