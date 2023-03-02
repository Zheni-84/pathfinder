package bg.softuni.pathfinder.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class MessageEntity extends BaseEntity{

	@Column(nullable = false, name = "date_time")
	private LocalDateTime dateTime;

	@Column(columnDefinition = "TEXT")
	private String text;

	@ManyToOne
	private UserEntity author;

	@ManyToOne
	private UserEntity recipient;

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public MessageEntity setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
		return this;
	}

	public String getText() {
		return text;
	}

	public MessageEntity setText(String text) {
		this.text = text;
		return this;
	}

	public UserEntity getAuthor() {
		return author;
	}

	public MessageEntity setAuthor(UserEntity author) {
		this.author = author;
		return this;
	}

	public UserEntity getRecipient() {
		return recipient;
	}

	public MessageEntity setRecipient(UserEntity recipient) {
		this.recipient = recipient;
		return this;
	}
}
