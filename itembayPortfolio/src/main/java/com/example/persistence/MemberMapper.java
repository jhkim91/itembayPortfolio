package com.example.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.model.Member;

//@Repository
@Mapper
public interface MemberMapper {
	
	/** Member view select */
	public Member selectMemberDetail(@Param("uemail") String uemail);
}
