package UserPackage;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean
@RequestScoped
public class UserForm implements Validator, Serializable {
	
	
	//INSTANCE USER BDD, COUCHE BDD SECURE
	
	private Pattern pattern;
	private Matcher matcher;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName = "Enter a UserName";
	private String userSurname = "Enter a UserSurname";
	private String password = "Enter a Password";
	private String email = "Enter an Email";
	
	private User user;
	
	
	public UserForm() {
		
		
		// TODO Auto-generated constructor stub
		
		
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {		
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}		
	public String getUserSurname() {
		return userSurname;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	
	//VALIDATOR EMAIL
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		
		String expression = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		pattern = Pattern.compile(expression); //[_A-Za-z0-9-]+(\\."+"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +"(\\.[A-Za-z]{2,})$
		matcher = pattern.matcher(email);
		
		matcher = pattern.matcher(value.toString());
		if (!matcher.matches()) {

			FacesMessage msg = new FacesMessage("E-mail validation failed.", "Invalid E-mail format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
	
	public void validatePassword(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		String expression = "^[0-9]+"; //DEFINE THE CORRECTION
		pattern = Pattern.compile(expression);  //DEFINE A PATTERN OF THE CORRECTION
		matcher = pattern.matcher(value.toString()); //Verify the matching of the cast of value with pattern
		if (!matcher.matches()) {
			FacesMessage msg = new FacesMessage("Password validation failed.", "Invalid Password format.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}	
	}
}
