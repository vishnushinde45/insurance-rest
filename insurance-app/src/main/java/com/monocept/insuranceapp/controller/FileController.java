package com.monocept.insuranceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.monocept.insuranceapp.documents.FileResponse;
import com.monocept.insuranceapp.documents.IFileSystemStorage;
import com.monocept.insuranceapp.service.CustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FileController {
	@Autowired
	private IFileSystemStorage fileSytemStorage;
	
	@Autowired
	private CustomerService customerService;
	
	 @PostMapping("/uploadfile/{customerId}")
     public ResponseEntity<FileResponse> uploadSingleFile (@RequestParam("file") MultipartFile file,@RequestParam("documentType") String documentType
    		 ,@PathVariable("customerId") int customerId) {
		 
		 
         String upfile = fileSytemStorage.saveFile(file);
         System.out.println("Type :"+documentType);
         System.out.println("ID :"+customerId);
         String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                 .path("/api/download/")
                 .path(upfile)
                 .toUriString();
         
         customerService.addDocument(customerId,documentType,fileDownloadUri);
         
         return ResponseEntity.status(HttpStatus.OK).body(new FileResponse(upfile,fileDownloadUri,"File uploaded with success!"));
	 }
	 
	 @GetMapping("/download/{filename:.+}")
     public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        
         Resource resource = fileSytemStorage.loadFile(filename);

         return ResponseEntity.ok()
                 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                 .body(resource);
     }
}
     

