package com.xworkz.matrimony;

import java.util.List;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dao.MatrimonyDAOImpl;
import com.xworkz.matrimony.dto.BrideDTO;
import com.xworkz.matrimony.service.MatrimonyService;
import com.xworkz.matrimony.service.MatrimonyServiceImpl;

public class BrideApplication {
	public static void main(String[] args) {

		MatrimonyDAO matrimonydao = new MatrimonyDAOImpl();
		MatrimonyService matrimonyService = new MatrimonyServiceImpl(matrimonydao);

		BrideDTO bridedto = matrimonyService.getBride(1);
		if (bridedto != null) {
			System.out.println(bridedto);
		}
		
		List<BrideDTO> list=matrimonyService.getAll();
		for (BrideDTO brideDTO2 : list) {
			System.out.println(brideDTO2);
			
		}
		
		
	}
	
	
	
}
