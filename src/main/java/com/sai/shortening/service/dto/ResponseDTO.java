package com.sai.shortening.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO
{
	public String shortURL;
	public String longURL;
	public String message;
}
