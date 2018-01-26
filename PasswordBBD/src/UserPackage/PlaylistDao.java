package UserPackage;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateless
public class PlaylistDao {
	
	@PersistenceContext (unitName = "persistence-unit-h2")
    private EntityManager em;

    public void add(Playlist playlist) {
       em.persist(playlist);
    }	
    
    public void addToUser(Playlist playlist, long userId) {
    	User userTemp = em.find(User.class, userId);
    	userTemp.getPlaylistList().add(playlist);
    	em.persist(playlist);
    	em.persist(userTemp);     
  }	
    
    public List<Playlist> list() {
    	return em.createQuery("SELECT e from Playlist e").getResultList();
    }    
    
    public void delete(long id) {
     Playlist playlistToDelete = em.find(Playlist.class, id);
     em.remove(playlistToDelete);
    }
    
    public Playlist get(Long playlistId) {
        return em.find(Playlist.class, playlistId);
    }

	public void update(Playlist playlist) {
		playlist = em.merge(playlist);
//		return null;
	}
}
