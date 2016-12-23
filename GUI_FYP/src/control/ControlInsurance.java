package control;

import domain.Insurance;
import da.InsuranceDA;

public class ControlInsurance {

    private InsuranceDA insuranceDA;

    public ControlInsurance() {
        insuranceDA = new InsuranceDA();
    }

    public Insurance selectRecord(String InsuranceID){
        return insuranceDA.getRecord(InsuranceID);
    }
    
    public String getlast(){
            return insuranceDA.getlastrecord();
    }
    
    public Insurance getMName(String ins){
        return insuranceDA.getName(ins);
    }

    public void addRecord(Insurance ins) {
        insuranceDA.addRecord(ins);
    }
    
    public void getRecord(Insurance ins) {
        insuranceDA.addRecord(ins);
    }
    
    public void updateRecord(Insurance ins) {
        insuranceDA.updateRecord(ins);
    }
    
    public void deleteRecord(Insurance ins) {
        insuranceDA.deleteRecord(ins);
    } 
    
   public String[] getInsuranceID(){
        return insuranceDA.getInsuranceID();
    }
    
}