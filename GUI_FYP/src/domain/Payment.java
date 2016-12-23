package domain;

import java.io.Serializable;
import java.util.Objects;

public class Payment implements Serializable {
    private String PaymentID;
    private Purchase PurchaseID;
    private String PaymentMethod;
    private double Amount;
    private Staff Staff;
    private String PDate;

    public Payment() {
    }
    
    public Payment(String PaymentID) {
        this.PaymentID = PaymentID;
    }
    
    public Payment(String PaymentID,Purchase PurchaseID, String PaymentMethod, double Amount,Staff Staff,String PDate){
        this.PaymentID = PaymentID;
        this.PurchaseID = PurchaseID;
        this.PaymentMethod = PaymentMethod;
        this.Amount = Amount;
        this.Staff = Staff;
        this.PDate = PDate;
    }

    public String getPaymentID() {
        return PaymentID;
    }
    
    public void setPaymentID(String PaymentID) {
        this.PaymentID = PaymentID;
    }
    
    public Purchase getPurchaseID() {
        return PurchaseID;
    }
    
    public void setPurchaseID(Purchase PurchaseID) {
        this.PurchaseID = PurchaseID;
    }
    
    public String getPaymentMethod() {
        return PaymentMethod;
    }
    
    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }
    
    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }
    
    public Staff getStaff() {
        return Staff;
    }

    public void setStaff(Staff Staff) {
        this.Staff = Staff;
    }
    
    public String getPDate() {
        return PDate;
    }

    public void setPDate(String PDate) {
        this.PDate = PDate;
    }


    
    
}
