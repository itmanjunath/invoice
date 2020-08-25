package com.example.invoice.service.impl;

import com.example.invoice.request.InvoiceRequest;
import com.example.invoice.request.SubscriptionType;
import com.example.invoice.response.InvoiceResponse;
import com.example.invoice.service.InvoiceService;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class InvoiceServiceImpl implements InvoiceService {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public InvoiceResponse getInvoiceDetails(InvoiceRequest invoiceRequest) throws ParseException {
        List<   String> invoiceDates = new ArrayList<>();
        InvoiceResponse invoiceResponse = new InvoiceResponse();
        invoiceResponse.setAmount(invoiceRequest.getAmount());
        invoiceResponse.setSubscriptionType(invoiceRequest.getSubscriptionType());
        Date startDate = simpleDateFormat.parse(invoiceRequest.getStartDate());
        Date endDate = simpleDateFormat.parse(invoiceRequest.getEndDate());

        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);

        if (invoiceRequest.getSubscriptionType().getValue().equalsIgnoreCase(SubscriptionType.WEEKLY.getValue()))
        {

            int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
            int i=1;
            while (i<=7)
            {
                if (dayOfTheWeek == getDayOfTheWeek(invoiceRequest.getDayOfTheWeek()))
                {
                   break;
                }
                cal.add(Calendar.DAY_OF_MONTH,1);
                dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
                i++;
            }


            while (cal.getTime().compareTo(endDate) <= 0)
            {
                invoiceDates.add(simpleDateFormat.format(cal.getTime()));
                cal.add(Calendar.DAY_OF_MONTH,7);
            }

        } else if (invoiceRequest.getSubscriptionType().getValue().equalsIgnoreCase(SubscriptionType.MONTHLY.getValue())) {
            cal.set(Calendar.DAY_OF_MONTH,Integer.parseInt(invoiceRequest.getDayOfTheWeek()));
            while (cal.getTime().compareTo(endDate) <= 0)
            {
                invoiceDates.add(simpleDateFormat.format(cal.getTime()));
                cal.add(Calendar.MONTH,1);
            }
        } else {
            while (cal.getTime().compareTo(endDate) <= 0)
            {
                invoiceDates.add(simpleDateFormat.format(cal.getTime()));
                cal.add(Calendar.DAY_OF_MONTH,1);
            }
        }
        invoiceResponse.setInvoiceDates(invoiceDates);

        return invoiceResponse;
    }

    private int getDayOfTheWeek(String dayOfTheWeek)
    {
        int dayOfTheWeekC = 0;
        switch (dayOfTheWeek.toUpperCase()){
            case "SUNDAY":
                dayOfTheWeekC = 1;
                break;
            case "MONDAY":
                dayOfTheWeekC = 2;
                break;
            case "TUESDAY":
                dayOfTheWeekC = 3;
                break;
            case "WEDNESDAY":
                dayOfTheWeekC = 4;
                break;
            case "THURSDAY":
                dayOfTheWeekC = 5;
                break;
            case "FRIDAY":
                dayOfTheWeekC = 6;
                break;
            case "SATURDAY":
                dayOfTheWeekC = 7;
                break;
        }
       return dayOfTheWeekC;
    }
}
