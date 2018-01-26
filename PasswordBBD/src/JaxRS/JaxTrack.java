package JaxRS;


import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import UserPackage.Track;
import UserPackage.TOTrack;
import UserPackage.TrackDao;

@Path("/JaxTrack")
public class JaxTrack {
	
	@EJB
	private TrackDao trackDao;
	
	@GET
	@Path("show")
	@Produces("application/json")	
	public TOTrack show(@QueryParam("id") long id) {		
		Track track = new Track();
		track = trackDao.get(id);
		TOTrack tOTrack = new TOTrack(track);
		return tOTrack;
	}
	
	@GET
	@Path("addTrack")
	@Produces("text/html")	
	public String addTrack(@QueryParam("title") 
	String title, @QueryParam("artist") String artist) {
		
		Track track = new Track();
		track.setTitle(title);
		track.setArtist(artist);
		trackDao.add(track);		
		
		return "USER AS CORRECTLY BE INSERT TO BBD";		
	}
	
	@GET
	@Path("delete")
	@Produces("text/html")	
	public String delete(@QueryParam("id") long trackId) {
		
		trackDao.delete(trackId);				
		return "TRACK AS CORRECTLY BE DELETED";
		
	}
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@QueryParam("/addJson")	
	public String post(Track track) {		
		trackDao.add(track);				
		return "TRACK AS CORRECTLY BE INSERT TO BBD";		
	}
	
}
