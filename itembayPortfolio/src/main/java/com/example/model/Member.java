package com.example.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
	private Long id;
	@Email
	private String uemail;
	@NotNull
	@Size(min = 1, max = 100)
	private String upw;
	@NotNull
	@Size(min = 1, max = 20)
	private String uname;
	private Date regdate;
	private Date updatedate;
	private List<MemberRole> roles;
	
}