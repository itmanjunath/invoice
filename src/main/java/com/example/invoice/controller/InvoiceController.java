package com.example.invoice.controller;

import com.example.invoice.request.InvoiceRequest;
import com.example.invoice.response.InvoiceResponse;
import com.example.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;

	@PostMapping("/invoice")
	public InvoiceResponse invoice(@RequestBody InvoiceRequest invoiceRequest) throws ParseException {

		return invoiceService.getInvoiceDetails(invoiceRequest);
	}

}
