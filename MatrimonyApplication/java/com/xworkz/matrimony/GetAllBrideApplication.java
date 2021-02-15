package com.xworkz.matrimony;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import com.xworkz.matrimony.dto.BrideDTO;

public class GetAllBrideApplication {
	public static void main(String[] args) {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			System.out.println("connected with the database");
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from matrimony.bride");
			

			resultSet.next();// next is used to print cursor in Resultset
			List<BrideDTO>list=new LinkedList<BrideDTO>();
			while(resultSet.next()) {
			BrideDTO bride = new BrideDTO();
			bride.setId(resultSet.getInt(1));
			bride.setName(resultSet.getString(2));
			bride.setAge(resultSet.getInt(3));
			bride.setHeight(resultSet.getDouble(4));
			bride.setWeight(resultSet.getDouble(5));
			bride.setQualification(resultSet.getString(6));
			bride.setExpectation(resultSet.getString(7));
			bride.setPhone_number(resultSet.getString(8));
			bride.setSalary(resultSet.getDouble(9));
			bride.setOccupation(resultSet.getString(10));
			bride.setAddress(resultSet.getString(11));

			//System.out.println(bride);
			list.add(bride);
			}
			list.forEach(e->System.out.println(e));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("faild to connect with database");
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

