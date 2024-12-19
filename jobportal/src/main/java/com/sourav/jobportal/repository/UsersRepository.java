package com.sourav.jobportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.sourav.jobportal.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

//	@Modifying
//	@Query(value="SELECT * FROM users u WHERE u.email=email",
//			nativeQuery=true)
	Optional<Users> findByEmail(@Param("email") String email);
}
