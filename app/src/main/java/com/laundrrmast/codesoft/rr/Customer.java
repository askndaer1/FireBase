package com.laundrrmast.codesoft.rr;

/**
 * Created by CodeSoft on 7/4/2017.
 */

public class Customer {

    String customerID;
    String customerName;
    String customerPhone;
    String customerAddress;
    String customerEmail;


    public Customer(){}

    public Customer(String CustomerID, String CustomerName, String CustomerPhone,String CustomerAddress,String CustomerEmail) {
        this.customerID = CustomerID;
        this.customerName = CustomerName;
        this.customerPhone = CustomerPhone;
        this.customerAddress =CustomerAddress;
        this.customerEmail =CustomerEmail;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }



}
