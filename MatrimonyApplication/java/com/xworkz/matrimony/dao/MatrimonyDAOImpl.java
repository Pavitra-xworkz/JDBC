package com.xworkz.matrimony.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import static com.xworkz.matrimony.constants.Constant.*;

import com.xworkz.matrimony.dto.BrideDTO;

public class MatrimonyDAOImpl implements MatrimonyDAO {

	@Override
	public BrideDTO getById(int id) {
		BrideDTO bride = new BrideDTO();

		try (Connection connection = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)) {
			// System.out.println("connected with the database");
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from matrimony.bride where id=1");

			resultSet.next();// next is used to print cursor in Resultset
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

			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("faild to connect with database");

		}
		return bride;
	}

	@Override
	public List<BrideDTO> getAllBride() {
		List<BrideDTO> list=new LinkedList<BrideDTO>();
		
		try (Connection connection = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)) {
			// System.out.println("connected with the database");
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from matrimony.bride");
			
			while(resultSet.next()){
				BrideDTO bride=new BrideDTO();
			
			//resultSet.next();// next is used to print cursor in Resultset
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
			list.add(bride);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("faild to connect with database");

		}
		
		return list;
	}

	@Override
	public int Create(BrideDTO bride) {
		int result=0;
		try(Connection con=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)){
			
			PreparedStatement stmt=con.prepareStatement("insert into matrimony.bride values(?,?,?,?,?,?,?,?,?,?,?)");
					stmt.setInt(1,bride.getId());
					stmt.setString(2,bride.getName());
					stmt.setInt(3,bride.getAge());
					stmt.setDouble(4,bride.getHeight());
					stmt.setDouble(5,bride.getWeight());
					stmt.setString(6, bride.getQualification());
					stmt.setString(7, bride.getExpectation());
					stmt.setString(8,bride.getPhone_number());
					stmt.setDouble(9,bride.getSalary());
					stmt.setString(10, bride.getOccupation());
					stmt.setString(11,bride.getAddress());
					
					
					result=stmt.executeUpdate();
					
		}catch(SQLException e) {
			System.out.println("failed to connect");
			e.printStackTrace();
		}
		return result; 
	}

	@Override
	public int Update(int id,String phone_number) {
		int result =0;
		try(Connection con=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)){
			PreparedStatement stmt=con.prepareStatement("update matrimony.bride set phone_number=? where id=?");
			stmt.setString(1,phone_number);
			stmt.setInt(2, id);
			result =stmt.executeUpdate();
			System.out.println("update successfull");
	} catch (SQLException e) {	
		System.out.println(" failed to update");
		e.printStackTrace();
	}
		return result;
}

	@Override
	public int Delete(int id) {
		int result=0;
		try(Connection con=DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)) {
			PreparedStatement stmt=con.prepareStatement("delete from  matrimony.bride where id=?");
			stmt.setInt(1,id );
			result=stmt.executeUpdate();
			System.out.println("Delete the id successfull");
			
			
			
		} catch (SQLException e) {
			System.out.println("failed to delete the record");
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int[] insertBrides(List<BrideDTO> brides) {
		int[]results=new int[brides.size()];
		try (Connection con = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD)) {
			Statement stmt = con.createStatement();
			//ResultSet resultSet = stmt.executeQuery("select * from matrimony.brides");
			for (BrideDTO dto : brides) {
				
				String query=String.format(INSERT_QUERY,
						dto.getId(),
						dto.getName(),
						dto.getAge(),
						dto.getHeight(),
						dto.getWeight(),
						dto.getQualification(),
						dto.getExpectation(),
						dto.getPhone_number(),
						dto.getSalary(),
						dto.getOccupation(),
						dto.getAddress());
				stmt.addBatch(query);
		
				
			}
			results =stmt.executeBatch();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return results;
}
	
}
