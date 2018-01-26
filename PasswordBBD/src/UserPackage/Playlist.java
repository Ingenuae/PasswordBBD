package UserPackage;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "PLAYLISTS", schema = "PUBLIC", catalog = "PUBLIC")
@Entity
public class Playlist {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "Id")
	private long id;
	
	@Column (name = "PlaylistName")
	private String playlistName;
	
	@ManyToMany
	private List<Track> tracklist;
	
	public List<Track> getTracklist() {
		return tracklist;
	}

	public void setTracklist(List<Track> tracklist) {
		this.tracklist = tracklist;
	}

	@ManyToMany
	private List<User> user ;
		
	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public Playlist(){
			
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
