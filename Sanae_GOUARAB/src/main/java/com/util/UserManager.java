package com.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
	public int addUser(String log, String pass, String role)
	{
		
				//DBinteraction db = new DBinteraction();//on a declaré les methodes comme des variables statiques 
				DBinteraction.connect();
				String sql = "insert into user(log,pass,role) values ('"+log+"','"+pass+"','"+role+"')";
				int nb = DBinteraction.Maj(sql);
				DBinteraction.disconnect();
				return nb;
				
		        /*
				//1 chargement du pilote
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//2 definir l url
				String url="jdbc:mysql://localhost/smis6";
				
				//3 etablir la connection
				Connection con = DriverManager.getConnection(url, "root", "");
				
				//4 creer un insctruction 
				Statement st = con.createStatement();
				String sql = "insert into user(log,pass,role) values ('"+log+"','"+pass+"','"+role+"')";
				//5 execution de la requette sql
				int nb=st.executeUpdate(sql); 
				
				return nb;*/
	}
	
	public int addUser(User u)
	{
		
				//DBinteraction db = new DBinteraction();//on a declaré les methodes comme des variables statiques 
				DBinteraction.connect();
				String sql = "insert into user(log,pass,role) values ('"+u.getLog()+"','"+u.getPass()+"','"+u.getRole()+"')";
				int nb = DBinteraction.Maj(sql);
				DBinteraction.disconnect();
				return nb;
				
	}
	
	public int deleteUser(int id)
	{
		/*
		//1 chargement du pilote
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//2 definir l url
		String url="jdbc:mysql://localhost/smis6";
		
		//3 etablir la connection
		Connection con = DriverManager.getConnection(url, "root", "");
		
		//4 creer un insctruction 
		Statement st = con.createStatement();
		//5 execution de la requette sql*/
		DBinteraction.connect();
		int nb=DBinteraction.Maj("delete from user where id = "+id);
		DBinteraction.disconnect();
		
		return nb; 
	}

	public User findUserById(int id)
	{
		User u=null;
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from user where id="+id);
		try {
			if(rs.next())
			{
				u=new User();
				u.setId(rs.getInt(1));
				u.setLog(rs.getString(2));
				u.setPass(rs.getString(3));
				u.setRole(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
	}

	public int updatUser(int id,User ut)
	{
		DBinteraction.connect();
		String sql="update user set log='"+ut.getLog()+"', pass='"+ut.getPass()+"', role='"+ut.getRole()+"' where id="+id;
		int nb=DBinteraction.Maj(sql);
		DBinteraction.disconnect();
		return nb;
	}
	
	//recuperer users "List<User>" ça peut etre un tab
	public List<User> allUsers()
	{
		List<User> us=new ArrayList<User>();//tableau dynnamique
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from user");
		try {
			while(rs.next())
			{
				User u=new User();
				u.setId(rs.getInt(1));
				u.setLog(rs.getString(2));
				u.setPass(rs.getString(3));
				u.setRole(rs.getString(4));
				//ajouter u dans la liste 
				us.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return us;
	}

	public User authentification(String log, String pass)
	{
		User u=null;
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from user where log='"+log+"' and pass='"+pass+"'");
		try {
			if(rs.next())
			{
				u=new User();
				u.setId(rs.getInt(1));
				u.setLog(rs.getString(2));
				u.setPass(rs.getString(3));
				u.setRole(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
	}
}



