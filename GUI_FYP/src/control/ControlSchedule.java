package control;

import da.*;
import domain.*;

public class ControlSchedule {

    private ScheduleDA ScheduleDA;

    public ControlSchedule() {
        ScheduleDA = new ScheduleDA();
    }

    public void addRecord(Schedule ScheduleNo) {
        ScheduleDA.addRecord(ScheduleNo);
    }
    
    public String getlast(){
    return ScheduleDA.getlastrecord();
}
    
    public Schedule selectRecord(String ScheduleNo){
        return ScheduleDA.getRecord(ScheduleNo);
    }
    
    public void updateRecord(Schedule schedule) {
       ScheduleDA.updateRecord(schedule);
    }
    
    public void deleteRecord(Schedule schedule) {
        ScheduleDA.deleteRecord(schedule);
   }
    
    public String[] getScheduleNO(){
        return ScheduleDA.getScheduleNO();
    }
    
}
