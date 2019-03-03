package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;

public class UserDao {
	private Connection userConn = null;

	public ArrayList queryAllUSer() throws Exception {
		ArrayList users = new ArrayList();
		userConn = AccessSqlite.getConn();
		String sql = "select* from user";
		try {
			Statement st = userConn.createStatement();
			ResultSet rs = st.executeQuery(sql);	
			while(rs.next()){
				User user=new User();
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	//查询用户是否已注册
	public boolean isUser(String username) throws Exception{
		boolean flag=false;
		ArrayList users=queryAllUSer();
		for(int i=0;i<users.size();i++){
			User user=(User)users.get(i);
			if(user.getUsername().equals(username)){
				flag=true;break;
			}
		}
		return flag;
	}
	
	//检验登陆账号密码密码
	public boolean isLegalUser(String username,String password) throws Exception{
		boolean flag=false;
		ArrayList users=queryAllUSer();
		for(int i=0;i<users.size();i++){
			User user=(User)users.get(i);
			if(user.getPassword().equals(password)&&user.getUsername().equals(username)){
				flag=true;break;
			}
		}
		return flag;
	}
	
}
