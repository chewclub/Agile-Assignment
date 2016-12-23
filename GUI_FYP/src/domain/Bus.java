package domain;

import java.io.Serializable;
import java.util.Objects;

public class Bus implements Serializable {
    private int BusNo;
    private int NumberofSeat;
    private Staff Staff;
    private String BPlate;

    public Bus() {
    }
    
    public Bus(int BusNo) {
        this.BusNo = BusNo;
    }
    
    public Bus(int BusNo,int NumberofSeat, Staff Staff, String BPlate){
        this.BusNo = BusNo;
        this.NumberofSeat = NumberofSeat;
        this.Staff = Staff;
        this.BPlate = BPlate;
    }

    public int getBusNo() {
        return BusNo;
    }
    
    public void setBusNo(int BusNo) {
        this.BusNo = BusNo;
    }
    
    public String getBPlate() {
        return BPlate;
    }
    
    public void setBPlate(String BPlate) {
        this.BPlate = BPlate;
    }
    
    public int getNumberofSeat() {
        return NumberofSeat;
    }
    
    public void setNumberofSeat(int NumberofSeat) {
        this.NumberofSeat = NumberofSeat;
    }
    
    public Staff getStaff() {
        return Staff;
    }

    public void setStaff(Staff Staff) {
        this.Staff = Staff;
    }


    
    
}
