package com.sai.shortening.service.serviceImpl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.hash.Hashing;
import com.sai.shortening.service.model.URLMapping;
import com.sai.shortening.service.repository.URLMappingRepository;
import com.sai.shortening.service.service.MappingService;

@Component
public class MappingServiceImpl implements MappingService
{
	@Autowired
	URLMappingRepository mappingRepository;
	
	@Override
	public String getShortURLHash(String longURL)
	{
		return Hashing.murmur3_32_fixed().hashString(longURL.concat(LocalDateTime.now().toString()),StandardCharsets.UTF_8).toString();
	}
	
	@Override
	public void saveHash(String shortURL,String longURL)
	{
		URLMapping urlMapping = new URLMapping();
		
		urlMapping.setShortURL(shortURL);
		urlMapping.setLongURL(longURL);
		
		mappingRepository.save(urlMapping);
	}
	
	@Override
	public String formShortURL(String hash)
	{
		String host = null;
		try
		{
			host = InetAddress.getLocalHost().getHostName();
		}
		catch (UnknownHostException e)
		{
			host = "localhost";
			e.printStackTrace();
		}
		
		StringBuilder shortURLBuilder = new StringBuilder();
		shortURLBuilder.append("https://");
		shortURLBuilder.append(host);
//		shortURLBuilder.append(":8071");
		shortURLBuilder.append("/"+hash);
		
		return shortURLBuilder.toString();
	}
}
