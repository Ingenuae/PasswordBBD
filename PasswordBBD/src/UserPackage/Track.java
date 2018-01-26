package UserPackage;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


//@ManagedBean
@Table(name = "TRACKS", schema = "PUBLIC", catalog = "PUBLIC")
@Entity
public class Track implements Serializable {

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

	@Column (name = "Title")
	private String Title ;
	
	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getArtist() {
		return Artist;
	}

	public void setArtist(String artist) {
		Artist = artist;
	}

	@Column (name = "Artist")
	private String Artist ;
	
	
	
	//@Column (name = "User")
	@OneToOne
	private User user ;
	
		
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Track() {
	}
	
	public String toString() {
		return id + Title + " " + Artist;
	}



	// public UserControl getUserControl() {
	// return userControl;
	// }
	//
	// public void setUserControl(UserControl userControl) {
	// this.userControl = userControl;
	// }

}