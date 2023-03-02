package bg.softuni.pathfinder.model;

import bg.softuni.pathfinder.model.enums.LevelEnum;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "routes", uniqueConstraints = { @UniqueConstraint(name = "uc_routeentity_name_author_id",
		columnNames = { "name", "author_id" })
})
public class RouteEntity extends BaseEntity {

	@Column(columnDefinition = "TEXT")
	private String description;

	@Column(columnDefinition = "LONGTEXT")
	private String gpxCoordinates;

	@Enumerated(EnumType.STRING)
	private LevelEnum level;

	private String name;

	@ManyToOne
	private UserEntity author;

	private String videoUrl;

	@OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
	private Set<CommentEntity> comments;

	@OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
	private Set<PictureEntity> pictures;

	@ManyToMany
	@JoinTable(name = "routes_categories",
			joinColumns = @JoinColumn(name = "route_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
	private Set<CategoryEntity> categories = new LinkedHashSet<>();

	@Override
	public String toString() {
		return "RouteEntity{" +
				"gpxCoordinates='" + gpxCoordinates + '\'' +
				", level=" + level +
				", name='" + name + '\'' +
				", author=" + author +
				", videoUrl='" + videoUrl + '\'' +
				'}';
	}

	public String getDescription() {
		return description;
	}

	public RouteEntity setDescription(String description) {
		this.description = description;
		return this;
	}

	public String getGpxCoordinates() {
		return gpxCoordinates;
	}

	public RouteEntity setGpxCoordinates(String gpxCoordinates) {
		this.gpxCoordinates = gpxCoordinates;
		return this;
	}

	public LevelEnum getLevel() {
		return level;
	}

	public RouteEntity setLevel(LevelEnum level) {
		this.level = level;
		return this;
	}

	public String getName() {
		return name;
	}

	public RouteEntity setName(String name) {
		this.name = name;
		return this;
	}

	public UserEntity getAuthor() {
		return author;
	}

	public RouteEntity setAuthor(UserEntity author) {
		this.author = author;
		return this;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public RouteEntity setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
		return this;
	}

	public Set<CommentEntity> getComments() {
		return comments;
	}

	public RouteEntity setComments(Set<CommentEntity> comments) {
		this.comments = comments;
		return this;
	}

	public Set<PictureEntity> getPictures() {
		return pictures;
	}

	public RouteEntity setPictures(Set<PictureEntity> pictures) {
		this.pictures = pictures;
		return this;
	}

	public Set<CategoryEntity> getCategories() {
		return categories;
	}

	public RouteEntity setCategories(Set<CategoryEntity> categories) {
		this.categories = categories;
		return this;
	}
}