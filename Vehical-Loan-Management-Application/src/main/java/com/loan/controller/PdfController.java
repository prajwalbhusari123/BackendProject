package com.loan.controller;

import java.io.ByteArrayInputStream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.loan.model.SanctionLetter;
import com.loan.service.Pdfservice;
@CrossOrigin("*")
@RestController
@RequestMapping("/pdf")
public class PdfController {

		@Autowired
		private Pdfservice pdfService;
		
		@GetMapping("/getPdf/{sid}")
		public ResponseEntity<InputStreamResource> getPdfFile(@PathVariable int sid)
		{
			
			HttpHeaders headers=new HttpHeaders();
			    headers.set("Content-Desposition","attachment;filnamee=getPdf.pdf");
			    
			
			
		      ByteArrayInputStream inputStream=	pdfService.PdfServiceImpl(sid);
		      
		      return ResponseEntity.ok()
		    		   .headers(headers)
		    		   .contentType(MediaType.APPLICATION_PDF)
		    		   .body(new InputStreamResource(inputStream));
		}

	}


	

