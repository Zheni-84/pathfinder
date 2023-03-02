package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.UserRolesEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity {

	@Enumerated(EnumType.STRING)
	@Column(unique = true)
	private UserRolesEnum role;

	public UserRolesEnum getRole() {
		return role;
	}

	public RoleEntity setRole(UserRolesEnum role) {
		this.role = role;
		return this;
	}
}