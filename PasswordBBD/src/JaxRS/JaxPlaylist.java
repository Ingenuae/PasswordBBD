package JaxRS;


import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import UserPackage.Playlist;
import UserPackage.PlaylistDao;
import UserPackage.TOPlaylist;

@Path("/JaxPlaylist")
public class JaxPlaylist {
	
	@EJB
	private PlaylistDao playlistDao;
	
	@GET
	@Path("show")
	@Produces("application/json")	
	public TOPlaylist show(@QueryParam("id") long id) {		
		Playlist playlist = new Playlist();
		playlist = playlistDao.get(id);
		TOPlaylist tOPlaylist = new TOPlaylist(playlist);
		return tOPlaylist;
	}
	
	@GET
	@Path("addPlaylist")
	@Produces("text/html")	
	public String addPlaylist(@QueryParam("playlistName") 
	String playlistName) {
		
		Playlist playlist = new Playlist();
		playlist.setPlaylistName(playlistName);
		playlistDao.add(playlist);		
		
		return "PLAYLIST AS CORRECTLY BE INSERT TO BBD";		
	}
	
	@GET
	@Path("delete")
	@Produces("text/html")	
	public String delete(@QueryParam("id") long playlistId) {
		
		playlistDao.delete(playlistId);				
		return "PLAYLIST AS CORRECTLY BE DELETED";
		
	}
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@QueryParam("/addJson")	
	public String post(Playlist playlist) {		
		playlistDao.add(playlist);				
		return "PLAYLIST AS CORRECTLY BE INSERT TO BBD";		
	}
	
}
