package UserPackage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean
@RequestScoped
public class UserControl{
	
	private UserForm userForm;
	private User user;
	
	@PersistenceContext
	private EntityManager em;
	
	public UserControl(){	
		setUserForm(new UserForm());
		this.user = new User(); //CREATE AN INSTANCE OF USER FOR BDD CUZ NO BEAN INSTANCE
		//em.persist(this.user); 
		//em.flush();
	}

	public UserForm getUserForm() {
		return userForm;
	}

	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}
	
	public Object action(){
		Object action = "hello";
		return action;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
