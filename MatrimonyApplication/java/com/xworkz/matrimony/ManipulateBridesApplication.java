package com.xworkz.matrimony;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class ManipulateBridesApplication {
	public static void main(String[] args) {
		BrideDTO bride1=new BrideDTO();
		bride1.setId(7);
		bride1.setName("Nagashree");
		bride1.setAge(23);
		bride1.setHeight(5.6);
		bride1.setWeight(50);
		bride1.setQualification("B.E");
		bride1.setPhone_number("8040201918");
		bride1.setExpectation("good");
		bride1.setOccupation("engineer");
		bride1.setAddress("gadag");
		bride1.setSalary(300000);
		
		BrideDTO bride2=new BrideDTO();
		bride2.setId(8);
		bride2.setName("Sema");
		bride2.setAge(22);
		bride2.setHeight(5.6);
		bride2.setWeight(50);
		bride2.setQualification("B.E");
		bride2.setPhone_number("8040201918");
		bride2.setExpectation("good");
		bride2.setOccupation("engineer");
		bride2.setAddress("gadag");
		bride2.setSalary(300000);
		
		MatrimonyDAO matrimonydao = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService = new MatrimonyServiceImpl(matrimonydao);
		
		List<BrideDTO>brides=new ArrayList<BrideDTO>();
		brides.add(bride1);
		brides.add(bride2);
		
		int[] results=matrimonyService.validateAndInsertBrides(brides);
		for (int i=0;i<results.length;i++) {
			if(results[i]==0) {
				System.out.println(brides.get(i).getName()+" bride failed to create");
			}
			else {
				System.out.println(brides.get(i).getName()+" bride  succesed to create");
			}
			
		}
		
	}

}
