package com.sourav.jobportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sourav.jobportal.entity.Users;
import com.sourav.jobportal.entity.UsersType;
import com.sourav.jobportal.services.UsersService;
import com.sourav.jobportal.services.UsersTypeService;

@Controller
public class UsersController {

	private final UsersTypeService usersTypeService;
	private final UsersService usersService;
	
	@Autowired
	public UsersController(UsersTypeService usersTypeService,UsersService usersService) {
		this.usersTypeService=usersTypeService;
		this.usersService = usersService;
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		List<UsersType> usersTypes = usersTypeService.getAll();
		model.addAttribute("getAllTypes",usersTypes);
		model.addAttribute("user", new Users());
		return "register";
	}
	
	@PostMapping("/register/new")
	public String userRegistration(Users user,Model model) {
		
		Optional<Users> registered = usersService.getUsersByEmail(user);
		if(registered.isPresent()) {
			model.addAttribute("error","Email already exist, pleas use another email id!!");
			List<UsersType> usersTypes = usersTypeService.getAll();
			model.addAttribute("getAllTypes",usersTypes);
			model.addAttribute("user", new Users());
			return "register";
		}
		
		usersService.addNew(user,model);
		return "dashboard";
	}
}
