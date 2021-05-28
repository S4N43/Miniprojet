package com.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bibmanager {
	public int addUser(String log, String pass, String role)
	{
		
				//DBinteraction db = new DBinteraction();//on a declaré les methodes comme des variables statiques 
				DBinteraction.connect();
				String sql = "insert into user(log,pass,role) values ('"+log+"','"+pass+"','"+role+"')";
				int nb = DBinteraction.Maj(sql);
				DBinteraction.disconnect();
				return nb;
	}
	
	public int addUser(User u)
	{
		
				DBinteraction.connect();
				String sql = "insert into user(log,pass,role) values ('"+u.getLog()+"','"+u.getPass()+"','"+u.getRole()+"')";
				int nb = DBinteraction.Maj(sql);
				DBinteraction.disconnect();
				return nb;
				
	}
	
	public int addliv(String nom_liv, String nom_aut, int clecat)
	{
		
				//DBinteraction db = new DBinteraction();//on a declaré les methodes comme des variables statiques 
				DBinteraction.connect();
				String sql = "insert into livre(nom_liv, nom_aut, clecat) values ('"+nom_liv+"','"+nom_aut+"','"+clecat+"')";
				int nb = DBinteraction.Maj(sql);
				DBinteraction.disconnect();
				return nb;
	}
	public int addliv(livre l)
	{
		DBinteraction.connect();
		String sql = "insert into livre(nom_liv,nom_aut,clecat) values ('"+l.getNom_liv()+"','"+l.getNom_aut()+"', '"+l.getClecat()+"')";
		int nbl = DBinteraction.Maj(sql);
		DBinteraction.disconnect();
		return nbl;
	}
	public int addcat(String namcat)
	{
		DBinteraction.connect();
		String sql = "insert into categorie(nom_cat) values ('"+namcat+"')";
		int nbc = DBinteraction.Maj(sql);
		DBinteraction.disconnect();
		return nbc;
	}
	public int addcat(cate namcat)
	{
		DBinteraction.connect();
		String sql = "insert into categorie(nom_cat) values ('"+namcat.getNom_cat()+"')";
		int nbc = DBinteraction.Maj(sql);
		DBinteraction.disconnect();
		return nbc;
	}
	public int deleteLiv(int id_liv)
	{
		
		DBinteraction.connect();
		int nb=DBinteraction.Maj("delete from etudiant where id_liv = "+id_liv);
		DBinteraction.disconnect();
		
		return nb; 
	}
	public int deleteUser(int id)
	{
		
		DBinteraction.connect();
		int nb=DBinteraction.Maj("delete from user where id = "+id);
		DBinteraction.disconnect();
		
		return nb; 
	}
	public int deleteCat(int clecat)
	{
		
		DBinteraction.connect();
		int nb=DBinteraction.Maj("delete from categorie where id_etu = "+clecat);
		DBinteraction.disconnect();
		
		return nb; 
	}

	public int updatUser(int id,User ut)
	{
		DBinteraction.connect();
		String sql="update user set log='"+ut.getLog()+"', pass='"+ut.getPass()+"', role='"+ut.getRole()+"' where id="+id;
		int nb=DBinteraction.Maj(sql);
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
	public livre findLivById(int id_liv)
	{
		livre l=null;
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from livre where id_liv="+id_liv);
		try {
			if(rs.next())
			{
				l=new livre();
				l.setId_liv(rs.getInt(1));
				l.setNom_liv(rs.getString(2));
				l.setNom_aut(rs.getString(3));
				l.setClecat(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}
	public cate findCatByString(String nom_cat)
	{
		cate c=null;
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from categorie where nom_catt="+nom_cat);
		try {
			if(rs.next())
			{
				c=new cate();
				c.setClecat(rs.getInt(1));
				c.setNom_cat(rs.getString(2));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return c;
	}
	
	public List<User> allUsers()
	{
		List<User> us=new ArrayList<User>();
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

				us.add(u);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return us;
	}

	public List<livre> alllivres()
	{
		List<livre> ls=new ArrayList<livre>();
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from livre  ");
		try {
			while(rs.next())
			{
				livre l=new livre();

				l.setNom_liv(rs.getString(2));
				l.setNom_aut(rs.getString(3));
				l.setClecat(rs.getInt(4));
				ls.add(l);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ls;
	}
	
	public List<cate> allcat()
	{
		List<cate> cs=new ArrayList<cate>();
		DBinteraction.connect();
		ResultSet rs = DBinteraction.select("select * from categorie");
		try {
			while(rs.next())
			{
				cate c=new cate();
				c.setClecat(rs.getInt(1));
				c.setNom_cat(rs.getString(2));
				
				cs.add(c);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cs;
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



