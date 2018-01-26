package UserPackage;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

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
	@EJB
	private PlaylistDao playlistDao;
	private UserForm userForm;
	private User user;	
	private Playlist playlist;
	private Track track;

	public UserControl() {
		// INSTANCE USER FORM,
		this.setUserForm(new UserForm());
		this.setUser(new User());
		this.playlist = new Playlist();
		}

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

		this.setPlaylist(playlistDao.get(this.getPlaylist().getId()));

		//this.getUser().setTrack(getTrack());
//		this.getTrack().setTitle(this.getUser().getTrack().getTitle());
//		this.getTrack().setArtist(this.getUser().getTrack().getArtist());

		// ADD USER TO BBD
		this.trackDao.addToPlaylist(this.getTrack(), this.getPlaylist().getId());

		String action = "trackList";
		return action;
	}
	

	public String playlistAction() {

		// CREATE AN INSTANCE OF USER FOR BDD CUZ NO BEAN INSTANCE

		this.setUser(userDao.get(this.getUser().getId()));

		//this.getUser().setTrack(getTrack());
//		this.getTrack().setTitle(this.getUser().getTrack().getTitle());
//		this.getTrack().setArtist(this.getUser().getTrack().getArtist());

		// this.getUser().setTrack(track);
		// ADD USER TO BBD
		this.playlistDao.addToUser(this.getPlaylist(), this.getUser().getId());

		String action = "playlistList";
		return action;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
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
	
	public List<Playlist> listPlaylist() {
		return playlistDao.list();
	}

	public String delete(long id) {
		userDao.delete(id);
		return "list";
	}
	
	public String playlistDelete(long id) {
		playlistDao.delete(id);
		return "playlistList";
	}

	public String showEdit(long userId) {
		this.user = userDao.get(userId);
		return "edit";
	}
	
	public String showEditTrack(long trackId) {
		this.track = trackDao.get(trackId);
		return "trackEdit";
	}
	
	public String showEditPlaylist(long playlistId) {
		this.playlist = playlistDao.get(playlistId);
		return "playlistEdit";
	}

	public String update() {
		userDao.update(this.user);
		return "list";
	}
	
	public String updateTrack() {
		trackDao.update(this.getTrack());
		return "trackList";
	}
	
	public String updatePlaylist() {
		playlistDao.update(this.getPlaylist());
		return "playlistList";
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
