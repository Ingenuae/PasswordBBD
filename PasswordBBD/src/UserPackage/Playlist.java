package UserPackage;

import java.util.List;

import javax.persistence.OneToOne;

public class Playlist {
	
	List<Track> tracklist;
	@OneToOne
	private User user ;
	
	public Playlist(){
			
	}
	
	
}
