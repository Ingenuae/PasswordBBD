package UserPackage;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateless
public class UserDao {
	
	@PersistenceContext (unitName = "persistence-unit-h2")
    private EntityManager em;

    public void add(User user) {
//        System.out.println("em: " + em);
        System.out.println(user);
       em.persist(user);
    }	
    
    public List<User> list() {
    	return em.createQuery("SELECT e from User e").getResultList();
    }    
    
    public void delete(long id) {
     User userToDelete = em.find(User.class, id);
     em.remove(userToDelete);
    }
    
    public User get(Long userId) {
        return em.find(User.class, userId);
    }

	public void update(User user) {
		user = em.merge(user);
//		return null;
	}
}
