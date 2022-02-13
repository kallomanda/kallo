package com.cigma.usermanagement.services;

import java.util.List;

import com.cigma.usermanagement.Reposetories.UserReposetory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cigma.usermanagement.entities.UserEntity;
import com.cigma.usermanagement.requests.UserRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
    UserReposetory userReposetory;

	
public void createUser(UserRequest userRequest) {
		
		UserEntity userEntity = new UserEntity();
		
		userEntity.setFullName(userRequest.getFullName());
		userEntity.setEmail(userRequest.getEmail());
		
		userReposetory.save(userEntity);
				
	}

public List<UserEntity> getUsers(int page, int limit) {
	
	if(page > 0) page = page - 1;
		
	Pageable pageableRequest = PageRequest.of(page, limit);
	
	Page<UserEntity> userPage;
	
	userPage = userReposetory.findAllUsers(pageableRequest);
	
	List<UserEntity> users = userPage.getContent();
	
	
	
	return users;
}

}
