//package UserPackage;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class DB {
//
//	public final static String[] QUERIES = {
//			"create table USERS (id bigint not null, UserName String, UserSurname String, Password String, Email String, primary key (id))",
//	};
//
//	public static void main(String[] args) throws Exception {
//		Class.forName("org.h2.Driver").newInstance();
//		Connection connexion = DriverManager.getConnection("jdbc:h2:&lt;BBD&gt;", "sa",  "");
//		java.sql.Statement stmt = connexion.createStatement();
//
//		for (String query : QUERIES) {
//			System.out.println(query);
//			stmt.executeUpdate(query);
//		}
//
//		stmt.close();
//		connexion.close();
//
//	}
//
//}