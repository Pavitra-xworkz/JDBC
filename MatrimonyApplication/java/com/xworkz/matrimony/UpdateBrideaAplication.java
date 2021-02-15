package com.xworkz.matrimony;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class UpdateBrideaAplication {
	public static void main(String[] args) {
		
		MatrimonyDAO matrimonydao = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService = new MatrimonyServiceImpl(matrimonydao);
		
		int result=matrimonyService.UpdateBride(1, "9876543210");
		System.out.println(result);


		
	}
	
	}
