package com.example.invoice.response;

import com.example.invoice.request.SubscriptionType;

import java.util.List;

public class InvoiceResponse {
    private Double amount;
    private SubscriptionType subscriptionType;
    private List<String> invoiceDates;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public List<String> getInvoiceDates() {
        return invoiceDates;
    }

    public void setInvoiceDates(List<String> invoiceDates) {
        this.invoiceDates = invoiceDates;
    }
}
