package com.sportlife.model.user;

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

import com.sportlife.Enum.EnumState;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@IdClass(UserDirectoryPK.class)
@Table(name = "LGE_USER_DIRECTORY")
public class UserDirectory {

	@EmbeddedId
	private UserDirectoryPK userDirectoryPK;
	
	
	@ManyToOne
    @MapsId("idUser")
    @JoinColumn(name = "id_user", foreignKey = @ForeignKey(name="FK_USER_ID"))
    private User user;

    @ManyToOne
    @MapsId("idTypeDirectory")
    @JoinColumn(name = "id_type_directory", foreignKey = @ForeignKey(name="FK_TYPE_DIRECTORY"))
    private TypeDirectory typeDirectory;

	@Column(nullable = true, length = 200)
	private String description;

	@Column(nullable = false, length = 3)
	@Enumerated(EnumType.STRING)
	private EnumState status;

	@Override
	public int hashCode() {
		return Objects.hash(userDirectoryPK);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDirectory other = (UserDirectory) obj;
		return Objects.equals(userDirectoryPK, other.userDirectoryPK);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "UserDirectory[pk=" + this.userDirectoryPK + "]";
	};

}
