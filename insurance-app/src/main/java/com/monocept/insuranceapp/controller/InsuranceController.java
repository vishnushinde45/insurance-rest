package com.monocept.insuranceapp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.monocept.insuranceapp.entity.InsuranceScheme;
import com.monocept.insuranceapp.entity.InsuranceType;
import com.monocept.insuranceapp.image.ImageRepository;
import com.monocept.insuranceapp.image.ImageService;
import com.monocept.insuranceapp.image.SchemeImage;
import com.monocept.insuranceapp.service.InsuranceSchemeService;
import com.monocept.insuranceapp.service.InsuranceTypeService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class InsuranceController {

	@Autowired
	private ImageRepository imageRepository;

	@Autowired
	private ImageService imageService;
	
	@Autowired
	private InsuranceTypeService insuranceTypeService;
	
	@Autowired
	private InsuranceSchemeService insuranceSchemeService;


	@PostMapping("/upload")
	public ResponseEntity<String> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {

		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		SchemeImage img = new SchemeImage(file.getOriginalFilename(), file.getContentType(),
				imageService.compressBytes(file.getBytes()));
		imageRepository.save(img);
		return new ResponseEntity<String>("Uploaded", HttpStatus.OK);
	}

	@GetMapping(path = { "/get/{imageName}" })
	public SchemeImage getImage(@PathVariable("imageName") String imageName) throws IOException {

		final Optional<SchemeImage> retrievedImage = imageRepository.findByName(imageName);
		SchemeImage img = new SchemeImage(retrievedImage.get().getName(), retrievedImage.get().getType(),
				imageService.decompressBytes(retrievedImage.get().getPicByte()));
		return img;
	}
	
	@GetMapping("/insurance-type")
	public List<InsuranceType> getInsuranceTypes(){
		List<InsuranceType> insuranceTypes=insuranceTypeService.getInsuranceTypes();
		
		return insuranceTypes;
		
	}
	
	@PostMapping("/insurance-type")
	public ResponseEntity<?> addInsuranceType(@RequestBody InsuranceType insuranceType){
		InsuranceType result=insuranceTypeService.addInsuranceType(insuranceType);
		return new ResponseEntity<InsuranceType>(result,HttpStatus.OK);
		
	}
	
	@PostMapping("/insurance-scheme/{insuranceTypeId}")
	public ResponseEntity<String> addInsuranceScheme(@RequestBody InsuranceScheme insuranceScheme,@PathVariable("insuranceTypeId") int id){
		System.out.println(id);
		InsuranceScheme insuScheme=insuranceSchemeService.addInsuranceScheme(insuranceScheme);
		if(insuScheme==null)
			return new ResponseEntity<String>("unable to add scheme",HttpStatus.BAD_REQUEST);
		return new ResponseEntity<String>("Scheme Added successfully",HttpStatus.OK);
	}

	

}
