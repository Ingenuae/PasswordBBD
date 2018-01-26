package UserPackage;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


//@ManagedBean
@Table(name = "USERS", schema = "PUBLIC", catalog = "PUBLIC")
@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "Id")
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column (name = "Name")
	private String userName ;
	@Column (name = "Surname")
	private String userSurname ;
	@Column (name = "Password")
	private String password ;
	@Column (name = "Email")
	private String email ;

	//@Column (name = "Track")
	@ManyToMany
	private List<Playlist> playlistList;
	
	public List<Playlist> getPlaylistList() {
		return playlistList;
	}

	public void setPlaylistList(List<Playlist> playlistList) {
		this.playlistList = playlistList;
	}

	public User() {
	}

	public String toString() {
		return id + userName + userSurname + password + email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// public UserControl getUserControl() {
	// return userControl;
	// }
	//
	// public void setUserControl(UserControl userControl) {
	// this.userControl = userControl;
	// }

}