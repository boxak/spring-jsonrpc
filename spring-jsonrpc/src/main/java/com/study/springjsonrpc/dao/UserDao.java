package com.study.springjsonrpc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.study.springjsonrpc.domain.User;

public class UserDao {
	private ConnectionMaker connectionMaker;
	
	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	
	public void add(User user) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.getConnection();
		
		PreparedStatement ps = c.prepareStatement(
				"insert into users(id, name, password) " +
				"values(?,?,?)"
		);
		
		ps.setString(1,  user.getId());
		ps.setString(2,  user.getName());
		ps.setString(3,  user.getPassword());
		
		ps.executeUpdate();
		
		ps.close();
		c.close();
	}
	
	public User getUserById(String id) throws ClassNotFoundException, SQLException {
		Connection c = connectionMaker.getConnection();
		
		PreparedStatement ps = c.prepareStatement(
				"select * from users where id=?"
		);
		
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		rs.next();
		
		User user = new User();
		
		user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        
        rs.close();
        ps.close();
        c.close();
		
        return user;
	}
	
}
