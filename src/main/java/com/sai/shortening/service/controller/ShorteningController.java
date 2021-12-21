package com.sai.shortening.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sai.shortening.service.dto.RequestDTO;
import com.sai.shortening.service.dto.ResponseDTO;
import com.sai.shortening.service.service.MappingService;

@RestController
@RequestMapping(path = "/url")
public class ShorteningController
{
	@Autowired
	private MappingService mappingService;
	
	@GetMapping(path = "/ping")
	public ResponseEntity<ResponseDTO> ping()
	{
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(null,null,"ping successfull"),HttpStatus.OK);
	}
	
	@PostMapping(path = "/shorten")
	public ResponseEntity<ResponseDTO> shortenURL(@RequestBody RequestDTO requestDTO)
	{
		String longURL = requestDTO.getLongURL();
		
		if(longURL == null || longURL.isEmpty())
		{
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(null,null,"no string passed"),HttpStatus.NO_CONTENT);
		}
		else
		{
			String hash = mappingService.getShortURLHash(longURL);
			mappingService.saveHash(hash, longURL);
			String shortURL = mappingService.formShortURL(hash);
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(shortURL,longURL,"processed"),HttpStatus.OK);
		}
	}
}
