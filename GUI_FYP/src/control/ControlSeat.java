package control;

import domain.*;
import da.*;

public class ControlSeat {

    private SeatDA seatDA;

    public ControlSeat() {
        seatDA = new SeatDA();
    }

    public Seat selectRecord(String SID){
        return seatDA.getRecord(SID);
    }
    
    public Seat getSName(String seat){
        return seatDA.getName(seat);
    }

    public void addRecord(Seat seat) {
        seatDA.addRecord(seat);
    }
    
    public void getRecord(Seat seat) {
        seatDA.addRecord(seat);
    }
    
    public void updateRecord(Seat seat) {
        seatDA.updateRecord(seat);
    }
    
    
    public String[] getSeatNo(){
        return seatDA.getSeatNo();
    }
    
    public void deleteRecord(Seat seat) {
        seatDA.deleteRecord(seat);
    }
    
}