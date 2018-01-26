package UserPackage;

public class TOUser {
	
	private Long id;
	private String name ;
	private String surname ;
	private String email ;
	private String password ;
	
	public TOUser(User user){		
		this.id = user.getId();
		this.name = user.getUserName();
		this.surname = user.getUserSurname();		
		this.email = user.getEmail();
		this.password = user.getPassword();		}
}

