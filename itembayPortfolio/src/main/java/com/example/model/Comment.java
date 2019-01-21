package com.example.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
	private int cn;
	
	private int seq;

	private String uId;
	
//	@NotEmpty(message = "내용을 입력해주세요.")
	@NotNull
	@Size(min=1, max=500)
	private String content;
	
	private String writer;
	
	private Date regDate;

	private Date updateDate;
	
	private String rn;
}
