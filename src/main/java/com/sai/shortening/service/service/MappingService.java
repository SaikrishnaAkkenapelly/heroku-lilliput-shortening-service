package com.sai.shortening.service.service;

import org.springframework.stereotype.Service;

@Service
public interface MappingService
{
	public String getShortURLHash(String longURL);
	public String formShortURL(String hash);
	public void saveHash(String shortURL,String longURL);
}
