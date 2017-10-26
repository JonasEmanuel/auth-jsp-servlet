package dao;

import model.User;

public class UserDAO extends DAO{
	
	public User checkCredentials(String email, String password) {
		User user = null;
		try {
			open();
			stmt = con.prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
			close();
		} 
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return user;
	}
}
