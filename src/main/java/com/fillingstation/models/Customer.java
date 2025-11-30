package com.fillingstation.models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int customerId;
    private String name;
    private String email;
    private double balance;
    private List<Invoice> invoices = new ArrayList<>();

    public Customer(int customerId, String name, String email, double balance) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.balance = balance;
    }

    public void register() {

    }

    public boolean login() {
        return true;
    }

    public void viewInvoices() {
        invoices.forEach(System.out::println);
    }

    public void receiveNotification() {
    }

    public void updateInformation(String name, String email) {
        this.name = name;
        this.email = email;
    }


    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public String getName() { return name; }
    public void addInvoice(Invoice invoice) { this.invoices.add(invoice); }
}