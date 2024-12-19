package com.sourav.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.sourav.jobportal.entity.UsersType;

public interface UsersTypeRepository extends JpaRepository<UsersType,Integer>{

}
