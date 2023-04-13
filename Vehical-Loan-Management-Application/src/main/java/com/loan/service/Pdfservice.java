package com.loan.service;

import java.io.ByteArrayInputStream;

import com.loan.model.SanctionLetter;

public interface Pdfservice {

	ByteArrayInputStream PdfServiceImpl(int sid);

}
