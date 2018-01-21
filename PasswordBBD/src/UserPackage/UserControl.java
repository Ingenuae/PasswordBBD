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
	
	//@PersistenceContext
	//private EntityManager em;
	
	public UserControl(){	
		
		//INSTANCE USER FORM, COUCHE NON SECURISE
		this.setUserForm(new UserForm()); 
		this.getUserForm().setUser(new User());
		
		 //CREATE AN INSTANCE OF USER FOR BDD CUZ NO BEAN INSTANCE	
		this.getUserForm().getUser().setUserName(getUserForm().getUserName());
		this.getUserForm().getUser().setUserSurname(getUserForm().getUserSurname());
		this.getUserForm().getUser().setPassword(getUserForm().getPassword());
		this.getUserForm().getUser().setEmail(getUserForm().getEmail());
		
		//em.persist(this.userForm.user); 
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


}
