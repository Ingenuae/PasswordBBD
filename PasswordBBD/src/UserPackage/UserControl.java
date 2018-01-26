package UserPackage;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UserControl implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UserDao userDao;
	@EJB
	private TrackDao trackDao;
	private UserForm userForm;
	private User user;	
	private Track track;

	public UserControl() {
		// INSTANCE USER FORM,
		this.setUserForm(new UserForm());
		this.setUser(new User());
		this.track = new Track();	}

	public UserForm getUserForm() {
		return userForm;
	}

	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}

	public String action() {

		// CREATE AN INSTANCE OF USER FOR BDD CUZ NO BEAN INSTANCE
		this.getUser().setUserName(this.getUserForm().getUserName());
		this.getUser().setUserSurname(this.getUserForm().getUserSurname());
		this.getUser().setPassword(this.getUserForm().getPassword());
		this.getUser().setEmail(this.getUserForm().getEmail());

		// ADD USER TO BBD
		this.userDao.add(this.getUser());

		String action = "hello";
		return action;
	}

	public String trackAction() {

		// CREATE AN INSTANCE OF USER FOR BDD CUZ NO BEAN INSTANCE

		this.setUser(userDao.get(this.getUser().getId()));

		//this.getUser().setTrack(getTrack());
//		this.getTrack().setTitle(this.getUser().getTrack().getTitle());
//		this.getTrack().setArtist(this.getUser().getTrack().getArtist());

		// this.getUser().setTrack(track);
		System.out.println(this.getUser().getId());
		System.out.println(this.getTrack().toString());
		// ADD USER TO BBD
		System.out.println(this.trackDao);
		this.trackDao.addToUser(this.getTrack(), this.getUser().getId());

		String action = "trackList";
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
	
	public List<Track> listTrack() {
		return trackDao.list();
	}

	public List<User> listOneUser() {
		return userDao.list();
	}

	public String delete(long id) {
		userDao.delete(id);
		return "list";
	}

	public String showEdit(long userId) {
		this.user = userDao.get(userId);
		return "edit";
	}
	
	public String showEditTrack(long trackId) {
		this.track = trackDao.get(trackId);
		return "trackEdit";
	}

	public String update() {
		userDao.update(this.user);
		return "list";
	}
	
	public String updateTrack() {
		System.out.println(this.getTrack());
		trackDao.update(this.getTrack());
		return "trackList";
	}

	public void jaxMethod() throws IOException {

		// URL userRequest = new
		// URL("http://localhost:8080/PasswordBBD/BBDApi/addUser?id=54&userName=Loulou&userSurname=Lili&email=a@gmail.com&password=654987");
		// URLConnection urlConnection = userRequest.openConnection();
		// urlConnection.setDoOutput(true);
		// urlConnection.setRequestProperty("Content-Type", "application/json;
		// charset=utf-8");
		// urlConnection.connect();
		// OutputStream outputStream = urlConnection.getOutputStream();
		// outputStream.write(("{\"fNamn\": \"" + stringData +
		// "\"}").getBytes("UTF-8"));

	}

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}

	
}
