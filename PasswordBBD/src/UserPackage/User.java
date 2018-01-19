package UserPackage;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USERS", schema = "PUBLIC", catalog = "PUBLIC")
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName = null;
	private String userSurname = null;
	private String password = null;
	private String email = null;
	
	private UserControl userControl;
	
	public User() {	
		
		this.setUserControl(new UserControl());
		this.setUserName(this.userControl.getUserForm().getUserName());
		this.setUserSurname(this.userControl.getUserForm().getUserSurname());
		this.setPassword(this.userControl.getUserForm().getPassword());
		this.setEmail(this.userControl.getUserForm().getEmail());
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurname() {
		return userSurname;
	}

	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserControl getUserControl() {
		return userControl;
	}

	public void setUserControl(UserControl userControl) {
		this.userControl = userControl;
	}

	
}