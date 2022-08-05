package com.sportlife.model.team;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.sportlife.Enum.EnumStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TAM_TEAM_PLAYER")
public class TeamPlayer {

	@EmbeddedId
	private TeamPlayerPK teamPlayerPK=new TeamPlayerPK();
	
	@ManyToOne
    @MapsId("idPlayer")
    @JoinColumn(name = "id_player", foreignKey = @ForeignKey(name="FK_PLAYER_ID"))
    private Player player;

    @ManyToOne
    @MapsId("idTeam")	
    @JoinColumn(name = "id_team", foreignKey = @ForeignKey(name="FK_TEAM"))
    private Team team;
	
	@Column(nullable = false, length = 3)
	@Enumerated(EnumType.STRING)
	private EnumStatus status;
	
	public TeamPlayer(TeamPlayerPK teamPlayerPK) {
		super();
		this.teamPlayerPK = teamPlayerPK;
	};
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(teamPlayerPK);
	}

	@Override
	public boolean equals( Object object) {
		boolean equal = true;
        if (!(object instanceof TeamPlayer)) {
            equal = false;
        }
        TeamPlayer other = (TeamPlayer) object;
        if ((this.teamPlayerPK == null && other.teamPlayerPK != null) || (this.teamPlayerPK != null && !this.teamPlayerPK.equals(other.teamPlayerPK))) {
            equal = false;
        }
        return equal;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "TeamPlayer[pk=" + this.teamPlayerPK + "]";
	}

}
