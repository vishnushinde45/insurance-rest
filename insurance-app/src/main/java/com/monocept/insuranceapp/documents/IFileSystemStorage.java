package com.monocept.insuranceapp.documents;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

public interface IFileSystemStorage {
	void init();
	String saveFile(MultipartFile file);
	Resource loadFile(String fileName);

}
