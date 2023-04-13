package com.loan.utility;

import java.awt.Color;
import java.io.ByteArrayOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class PdfUtility {

	public static ByteArrayOutputStream createPdf(String title, String content) 
	{

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		Document document= new Document();
		
		PdfWriter.getInstance(document, outputStream);
		
		document.open();
		
		
		Font titleFont=FontFactory.getFont(FontFactory.HELVETICA_BOLD, 25, Color.DARK_GRAY);
		
		
	Paragraph titlePara=new Paragraph(title, titleFont);
		       titlePara.setAlignment("Center");   
		           
		           document.add(titlePara);
		           
		           
		   Paragraph contentPara=new Paragraph();
		           contentPara.add(content);
		           document.add(contentPara);
		           
		           

		           document.close();
	
		
		 return outputStream;
	}
	}

