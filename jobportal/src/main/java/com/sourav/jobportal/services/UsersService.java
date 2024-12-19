package com.sourav.jobportal.services;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.sourav.jobportal.entity.JobSeekerProfile;
import com.sourav.jobportal.entity.RecruiterProfile;
import com.sourav.jobportal.entity.Users;
import com.sourav.jobportal.repository.JobSeekerProfileRepository;
import com.sourav.jobportal.repository.RecruiterProfileRepository;
import com.sourav.jobportal.repository.UsersRepository;

@Service
public class UsersService {

	private final UsersRepository usersRepository;
	private final JobSeekerProfileRepository jobSeekerProfileRepository;
	private final RecruiterProfileRepository recruiterProfileRepository;
	@Autowired
	public UsersService(UsersRepository usersRepository,JobSeekerProfileRepository jobSeekerProfileRepository,RecruiterProfileRepository recruiterProfileRepository) {
		this.usersRepository=usersRepository;
		this.jobSeekerProfileRepository = jobSeekerProfileRepository;
		this.recruiterProfileRepository = recruiterProfileRepository;
	}
	
	public Users addNew(Users user,Model model) {
		user.setActive(true);
		user.setRegistrationDate(new Date(System.currentTimeMillis()));
		Users saved = usersRepository.save(user);
		int userTypeId = user.getUserTypeId().getUserTypeId();
		if(userTypeId==1) {
			recruiterProfileRepository.save(new RecruiterProfile(user));
		}
		else {
			jobSeekerProfileRepository.save(new JobSeekerProfile(user));
		}
		return saved;
	}
	
	public Optional<Users> getUsersByEmail(Users user){
//		List<Users> users = usersRepository.findAll();
//		for( Users registeredUser : users) {
//			if(registeredUser.getEmail().equals(user.getEmail()))
//				throw new RuntimeException("Email already exist");
//		}
		
		Optional<Users> registered = usersRepository.findByEmail(user.getEmail());
		return registered;
	}
}
