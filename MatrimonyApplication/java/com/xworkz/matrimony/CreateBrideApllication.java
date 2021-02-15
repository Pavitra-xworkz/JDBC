package com.xworkz.matrimony;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class CreateBrideApllication {
	
	public static void main(String[] args) {
		
		MatrimonyDAO matrimonydao = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService = new MatrimonyServiceImpl(matrimonydao);

		BrideDTO bride=new BrideDTO();
		bride.setId(6);
		bride.setName("Sema");
		bride.setAge(22);
		bride.setHeight(5.6);
		bride.setWeight(50);
		bride.setQualification("B.E");
		bride.setPhone_number("8040201918");
		bride.setExpectation("good");
		bride.setOccupation("engineer");
		bride.setAddress("gadag");
		bride.setSalary(300000);
		
		
		int result=matrimonyService.ValidateAndCreateBride(bride);
		if(result==1) {
			System.out.println("Bride created");
				
		}
		else {
			System.out.println("Bride failed to create");
	
		}
	}

}
