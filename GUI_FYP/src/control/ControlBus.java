package control;

import da.*;
import domain.*;

public class ControlBus {

    private BusDA BusDA;
    private StaffDA StaffDA;

    public ControlBus() {
        BusDA = new BusDA();
    }

    public void addRecord(Bus bus) {
        BusDA.addRecord(bus);
    }
    
    public int getlast(){
    return BusDA.getlastrecord1();
}
    
    public Bus selectRecord(int busno){
        return BusDA.getRecord(busno);
    }
    
    public void updateRecord(Bus bus) {
        BusDA.updateRecord(bus);
    }
    
    public void deleteRecord(Bus bus) {
        BusDA.deleteRecord(bus);
    }
    
    public String[] getNoBus(){
        return BusDA.getNOBus();
    }

    
}
