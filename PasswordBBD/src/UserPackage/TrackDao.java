package UserPackage;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateless
public class TrackDao {
	
	@PersistenceContext (unitName = "persistence-unit-h2")
    private EntityManager em;

    public void add(Track track) {
       em.persist(track);
    }	
    
    public void addToPlaylist(Track track, long playlistId) {
    	//FIND USER
    	Playlist playlistTemp = em.find(Playlist.class, playlistId);
    	//ADD THIS TRACK TO PLAYLIST    	
    	playlistTemp.getTracklist().add(track);
    	//userTemp.setTrack(track);
    	em.persist(track);
    	em.persist(playlistTemp);     
  }	
    
    public List<Track> list() {
    	return em.createQuery("SELECT e from Track e").getResultList();
    }    
    
    public void delete(long id) {
     Track trackToDelete = em.find(Track.class, id);
     em.remove(trackToDelete);
    }
    
    public Track get(Long trackId) {
        return em.find(Track.class, trackId);
    }

	public void update(Track track) {
		track = em.merge(track);
//		return null;
	}
}
