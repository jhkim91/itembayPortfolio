package com.example.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
	private int seq;

	private String uId;
	
	@NotNull
	@Size(min = 1, max = 100, message = "Must be between 1 and 100")
	private String title;
	
//	@NotEmpty(message = "내용을 입력해주세요.")
	@NotNull
	@Size(min=1, max=500)
	private String content;
	
	private String writer;
	
	private Date regDate;

	private Date updateDate;
}
