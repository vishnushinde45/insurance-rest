package com.monocept.insuranceapp.image;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class ImageStorageService {
   
	@Autowired
	private ImageDBRepository imageDBRepository;
	
	@Transactional
	public void store(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    SchemeImage schemeImage = new SchemeImage(fileName, file.getContentType(), file.getBytes());
	     imageDBRepository.save(schemeImage);
	     
	    
	  }

	@Transactional
	 public SchemeImage findById(int id) {
		    return imageDBRepository.findById(id).get();
		  }

	
}
