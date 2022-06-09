package com.example.demo.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.User;
import com.example.demo.User2;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserRepository;

@Service
public class UserService {
	@Autowired 
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;
	
	public Page<User>  findAllByRepository(Pageable pageable) {
		return userRepository.findAll(pageable);
	}
	
	public Page<User2>  findAllByMapper(Pageable pageable) {
		int offset = (int) pageable.getOffset();
		int limit = pageable.getPageSize();
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<User2> result = userMapper.findAll(rowBounds);
		
		return new PageImpl<>(result, pageable, result.size());
	}
}
