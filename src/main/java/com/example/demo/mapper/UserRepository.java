package com.example.demo.mapper;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	public Page<User> findAll(Pageable page);

}
