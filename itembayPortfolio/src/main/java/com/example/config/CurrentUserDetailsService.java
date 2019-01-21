package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.CustomUser;
import com.example.model.Member;
import com.example.model.MemberRole;
import com.example.service.MemberService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurrentUserDetailsService implements UserDetailsService {

	private static final String ROLE_PREFIX = "ROLE_";
	
	@Autowired
    private MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member = memberService.selectMemberDetail(email);
		CustomUser customUser = new CustomUser(member.getUemail(), member.getUpw(), true, true, true, true, makeGrantedAuthority(member.getRoles()),member.getUname());
		return customUser;
    }
	
	public static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles){
		List<GrantedAuthority> list = new ArrayList<>();
		roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));
		return list;
	}
}