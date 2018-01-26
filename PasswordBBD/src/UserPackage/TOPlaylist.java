package UserPackage;

public class TOPlaylist {
	
	private Long id;
	private String playlistName ;
	
	public TOPlaylist(Playlist playlist){		
		this.id = playlist.getId();
		this.playlistName = playlist.getPlaylistName();
	}
}


