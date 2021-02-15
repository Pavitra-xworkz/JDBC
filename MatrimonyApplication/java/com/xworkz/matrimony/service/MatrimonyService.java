package com.xworkz.matrimony.service;

import java.util.List;

import com.xworkz.matrimony.dto.BrideDTO;

public interface MatrimonyService {
	public BrideDTO  getBride(int id) ;
	public List<BrideDTO>  getAll();
	
	public int ValidateAndCreateBride(BrideDTO bride);
	public int UpdateBride(int id,String phone_number);
	
	public int DeleteBride(int id);
	
	public int[]validateAndInsertBrides(List<BrideDTO>brides);
	

}
