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
    
    public void addToUser(Track track, long userId) {
    	User userTemp = em.find(User.class, userId);
    	userTemp.setTrack(track);
    	em.persist(track);
    	em.persist(userTemp);     
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
