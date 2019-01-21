package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Member;
import com.example.persistence.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;

	/** Member 상세정보 조회 */
	public Member selectMemberDetail(String uemail) {
		Member member = memberMapper.selectMemberDetail(uemail);
		return member;
	}
    
}
