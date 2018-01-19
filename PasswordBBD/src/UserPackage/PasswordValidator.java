package UserPackage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator
public class PasswordValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;
	
	//VALIDATOR PASSWORD
	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
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
