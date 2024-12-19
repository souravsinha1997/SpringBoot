package com.sourav.jobportal.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sourav.jobportal.entity.UsersType;
import com.sourav.jobportal.repository.UsersTypeRepository;

@Service
public class UsersTypeService {

	private final UsersTypeRepository usersTypeRepo;
	
	public UsersTypeService(UsersTypeRepository usersTypeRepo) {
		this.usersTypeRepo = usersTypeRepo;
	}
	
	public List<UsersType> getAll(){
		return usersTypeRepo.findAll();
	}
}
