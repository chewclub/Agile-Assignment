package domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class Schedule implements Serializable {
    private String ScheduleNo;
    private String Date1;
    private String Time1;
    private String StartingPoint;
    private String Destination;
    private Bus Bus;
    private double Price;
    private int available;

    public Schedule() {
    }
    
    public Schedule(String ScheduleNo) {
        this.ScheduleNo = ScheduleNo;
    }
    
    public Schedule(String ScheduleNo,String Date1, String Time1, String StartingPoint, String Destination, Bus Bus, double Price,int available){
        this.ScheduleNo = ScheduleNo;
        this.Date1 = Date1;
        this.Time1 = Time1;
        this.StartingPoint = StartingPoint;
        this.Destination = Destination;
        this.Bus = Bus;
        this.Price = Price;
        this.available = available;
    }

    public String getScheduleNo() {
        return ScheduleNo;
    }
    
    public void getScheduleNo(String ScheduleNo) {
        this.ScheduleNo = ScheduleNo;
    }
    
    public String getDate1() {
        return Date1;
    }
    
    public void setDate1(String Date1) {
        this.Date1 = Date1;
    }
    
    public String getTime1() {
        return Time1;
    }
    
    public void setTime1(String Time1) {
        this.Time1 = Time1;
    }
    
    public Bus getBus() {
        return Bus;
    }

    public void setBus(Bus Bus) {
        this.Bus = Bus;
    }
    
    public double getPrice() {
        return Price;
    }
    
    public void setPrice(double Price) {
        this.Price = Price;
    }
    
    public String getStartingPoint() {
        return StartingPoint;
    }
    
    public void setStartingPoint(String StartingPoint) {
        this.StartingPoint = StartingPoint;
    }
    
    public String getDestination() {
        return Destination;
    }
    
    public void setDestination(String Destination) {
        this.Destination = Destination;
    }
    
    public int getavailable() {
        return available;
    }
    
    public void setavailable(int available) {
        this.available = available;
    }
    


    
    
}
