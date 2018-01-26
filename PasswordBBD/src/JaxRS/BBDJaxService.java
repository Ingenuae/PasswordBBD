package JaxRS;


import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import UserPackage.User;
import UserPackage.UserDao;
import UserPackage.TOUser;

@Path("/BBDApi")
public class BBDJaxService {
	
	@EJB
	private UserDao userDao;
	
	@GET
	@Path("show")
	@Produces("application/json")	
	public TOUser show(@QueryParam("id") long id) {
		
		User user = new User();
		user = userDao.get(id);
		TOUser tOUser = new TOUser(user);
		return tOUser;
		
	}
	
	@GET
	@Path("addUser")
	@Produces("text/html")	
	public String addUser(@QueryParam("userName") 
	String userName, @QueryParam("userSurname") String userSurname, @QueryParam("email") 
	String email, @QueryParam("password") String password) {
		
		User user = new User();
		user.setUserName(userName);
		user.setUserSurname(userSurname);
		user.setEmail(email);
		user.setPassword(password);		
		userDao.add(user);		
		
		return "USER AS CORRECTLY BE INSERT TO BBD";		
	}
	
	@GET
	@Path("delete")
	@Produces("text/html")	
	public String delete(@QueryParam("id") long userId) {
		
		userDao.delete(userId);				
		return "USER AS CORRECTLY BE DELETED";
		
	}
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@QueryParam("/addJson")	
	public String post(User user) {		
		userDao.add(user);				
		return "USER AS CORRECTLY BE INSERT TO BBD";		
	}
	
}
