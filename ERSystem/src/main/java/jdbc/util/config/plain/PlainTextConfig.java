package jdbc.util.config.plain;

public class PlainTextConfig {
	private static final String url = "jdbc:postgresql://regaedb.ce8a70kibcmu.us-east-2.rds.amazonaws.com:5432/postgres";
	private static final String username = "admin";
	private static final String password = "password";
	
	public static String getUrl() {
		return url;
	}
	public static String getUsername() {
		return username;
	}
	public static String getPassword() {
		return password;
	}
}
