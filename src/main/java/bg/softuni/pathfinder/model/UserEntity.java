package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.LevelEnum;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(unique = true)
	private String email;

	private String fullName;

	private int age;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles",
			joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<RoleEntity> roles = new java.util.LinkedHashSet<>();

	@Enumerated(EnumType.STRING)
	private LevelEnum level;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserEntity that = (UserEntity) o;
		return getUsername().equals(that.getUsername()) && getEmail().equals(that.getEmail());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUsername(), getEmail());
	}

	public String getUsername() {
		return username;
	}

	public UserEntity setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public UserEntity setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public UserEntity setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getFullName() {
		return fullName;
	}

	public UserEntity setFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	public int getAge() {
		return age;
	}

	public UserEntity setAge(int age) {
		this.age = age;
		return this;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public UserEntity setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
		return this;
	}

	public LevelEnum getLevel() {
		return level;
	}

	public UserEntity setLevel(LevelEnum level) {
		this.level = level;
		return this;
	}
}