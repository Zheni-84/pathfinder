package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.RouteCategoryEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private RouteCategoryEnum name;

	@Column(columnDefinition = "TEXT")
	private String description;

	public RouteCategoryEnum getName() {
		return name;
	}

	public CategoryEntity setName(RouteCategoryEnum name) {
		this.name = name;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public CategoryEntity setDescription(String description) {
		this.description = description;
		return this;
	}
}