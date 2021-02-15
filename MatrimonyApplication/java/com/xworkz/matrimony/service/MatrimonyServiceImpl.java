package com.xworkz.matrimony.service;

import java.util.List;

import com.xworkz.matrimony.dao.MatrimonyDAO;
import com.xworkz.matrimony.dto.BrideDTO;

public class MatrimonyServiceImpl implements MatrimonyService {
	MatrimonyDAO matrimonyDAO;

	public MatrimonyServiceImpl(MatrimonyDAO matrimonyDAO) {
		this.matrimonyDAO = matrimonyDAO;

	}

	@Override
	public BrideDTO getBride(int id) {
		if (0 == id) {
			System.out.println("invalid id");
			return null;
		}
		return matrimonyDAO.getById(id);
	}

	@Override
	public List<BrideDTO> getAll() {

		return matrimonyDAO.getAllBride();
	}

	@Override
	public int ValidateAndCreateBride(BrideDTO bride) {
		if (null == bride) {
			System.out.println("bride cannot be null");
			return 0;
		} else if (bride.getId() == 0) {
			System.out.println("invalid");
			return 0;
		} else {
			return matrimonyDAO.Create(bride);
		}

	}

	@Override
	public int UpdateBride(int id,String phone_number) {
		if( id == 0 || phone_number.length()!=10) {
			System.out.println("id and phone no are not valid");
			return 0;
			
		}else {
			return matrimonyDAO.Update(id, phone_number);
		}
		
		
	}

	@Override
	public int DeleteBride(int id) {
		if(id==0) {
			System.out.println("id is failed");
			
		}else {
		
		return matrimonyDAO.Delete(id);
		
	}
		return id;
}

	@Override
	public int[] validateAndInsertBrides(List<BrideDTO> brides) {
		if(brides==null) {
			System.out.println("Bride list can not be null");
			int[]result=new int[brides.size()];
			for(int i=0;i<result.length;i++) {
				result[i]=0;
			}
			return result;
		
		}
		else {
			return matrimonyDAO.insertBrides(brides);
			
		}
	
	}
}
