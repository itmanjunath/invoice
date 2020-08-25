package com.example.invoice.service;

import com.example.invoice.request.InvoiceRequest;
import com.example.invoice.response.InvoiceResponse;

import java.text.ParseException;

public interface InvoiceService {
    InvoiceResponse getInvoiceDetails(InvoiceRequest invoiceRequest) throws ParseException;
}
