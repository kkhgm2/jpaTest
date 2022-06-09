package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import com.example.demo.User2;

@Mapper
public interface UserMapper {
	List<User2> findAll(RowBounds rowBounds);

	
}
