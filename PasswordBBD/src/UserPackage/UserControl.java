package UserPackage;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean
@RequestScoped
public class UserControl {

	@EJB
	private UserDao userDao;
	private UserForm userForm;
	private User user;

	public UserControl() {
		// INSTANCE USER FORM,
		this.setUserForm(new UserForm());
	}

	public UserForm getUserForm() {
		return userForm;
	}

	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}

	public String action() {

		// create user
		// CREATE AN INSTANCE OF USER FOR BDD CUZ NO BEAN INSTANCE
		this.setUser(new User());
		this.getUser().setUserName(this.getUserForm().getUserName());
		this.getUser().setUserSurname(this.getUserForm().getUserSurname());
		this.getUser().setPassword(this.getUserForm().getPassword());
		this.getUser().setEmail(this.getUserForm().getEmail());

		// ADD USER TO BBD
		this.userDao.add(this.getUser());

		String action = "hello";
		return action;
	}

	public String actionManage() {
		String action = "list";
		System.out.println("hi");
		return action;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	 public List<User> list() {
	    	return userDao.list();
	    }
	 
	 public String delete(long id) {
	    	userDao.delete(id); //supprime
	    	return "list";
	    }
}
