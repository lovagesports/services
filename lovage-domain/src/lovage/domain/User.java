package lovage.domain;

public class User {

	public Long id;
	public String email;
	public String password;
	public final UserType type;

	public User(UserType type) {
		this.type = type;
	}

	public User(UserType type, Long id, String email, String password) {
		this(type);
		this.id = id;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", type=" + type + "]";
	}
}
