package control;

import da.*;
import domain.*;

public class ControlPurchase {

    private PurchaseDA PurchaseDA;

    public ControlPurchase() {
        PurchaseDA = new PurchaseDA();
    }

    public void addRecord(Purchase PurchaseID) {
        PurchaseDA.addRecord(PurchaseID);
    }
    
    public String getlast(){
    return PurchaseDA.getlastrecord();
}
    
    public Purchase selectRecord(String PurchaseID){
        return PurchaseDA.getRecord(PurchaseID);
    }
    
    public void updateRecord(Purchase PurchaseID) {
       PurchaseDA.updateRecord(PurchaseID);
    }
    
    public void deleteRecord(Purchase PurchaseID) {
        PurchaseDA.deleteRecord(PurchaseID);
   }
    
    public String[] getPurchaseID(){
        return PurchaseDA.getPurchaseID();
    }
    
}
