package UserPackage;



public class TOTrack {
	
	private Long id;
	private String Title ;
	private String artist ;
	
	public TOTrack(Track track){		
		this.id = track.getId();
		this.Title = track.getTitle();
		this.artist = track.getArtist();		
	}
}


