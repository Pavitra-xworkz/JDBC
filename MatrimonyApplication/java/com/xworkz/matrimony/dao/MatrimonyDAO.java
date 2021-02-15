package com.xworkz.matrimony.dao;

import java.util.List;

import com.xworkz.matrimony.dto.BrideDTO;

public interface MatrimonyDAO {
	public BrideDTO getById(int id);//only one id record will get
	public List<BrideDTO> getAllBride();
	
	public int Create(BrideDTO bride);
	
	public int Update(int id,String phone_number);
	public int Delete(int id);
	public int[]insertBrides(List<BrideDTO>brides);
	

}
