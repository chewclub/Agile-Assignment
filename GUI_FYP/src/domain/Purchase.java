package domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class Purchase implements Serializable {
    private String PurchaseID;
    private Member Member;
    private Staff Staff;
    private Insurance Insurance;
    private Schedule Schedule;
    private double Price;
    private String SeatID;
    private String PDate;

    public Purchase() {
    }
    
    public Purchase(String PurchaseID) {
        this.PurchaseID = PurchaseID;
    }
    
    public Purchase(String PurchaseID,Member Member, Staff Staff, Insurance Insurance, Schedule Schedule, double Price,String SeatID,String PDate){
        this.PurchaseID = PurchaseID;
        this.Member = Member;
        this.Staff = Staff;
        this.Insurance = Insurance;
        this.Schedule = Schedule;
        this.Price = Price;
        this.SeatID = SeatID;
        this.PDate = PDate;
    }

    public String getPurchaseID() {
        return PurchaseID;
    }
    
    public void getPurchaseID(String PurchaseID) {
        this.PurchaseID = PurchaseID;
    }
    
    public Member getMember() {
        return Member;
    }
    
    public void setMember(Member Member) {
        this.Member = Member;
    }
    
    public Staff getStaff() {
        return Staff;
    }
    
    public void setStaff(Staff Staff) {
        this.Staff = Staff;
    }
    
    public Insurance getInsurance() {
        return Insurance;
    }

    public void setInsurance(Insurance Insurance) {
        this.Insurance = Insurance;
    }
    
    public Schedule getSchedule() {
        return Schedule;
    }
    
    public void setSchedule(Schedule Schedule) {
        this.Schedule = Schedule;
    }
    
    public double getPrice() {
        return Price;
    }
    
    public void setPrice(double Price) {
        this.Price = Price;
    }
    
    public String getSeatID() {
        return SeatID;
    }
    
    public void setSeatID(String SeatID) {
        this.SeatID = SeatID;
    }
    
    public String getPDate() {
        return PDate;
    }
    
    public void setPDate(String PDate) {
        this.PDate = PDate;
    }
}
