package control;

import da.*;
import domain.*;

public class ControlPayment {

    private PaymentDA PaymentDA;

    public ControlPayment() {
        PaymentDA = new PaymentDA();
    }
    public void addRecord(Payment Paymentid) {
        PaymentDA.addRecord(Paymentid);
    }    
    public String getlast(){
    return PaymentDA.getlastrecord();
    }
    public Payment selectRecord(String Paymentid){
        return PaymentDA.getRecord(Paymentid);
    }
    public String[] getPPurchaseID(){
        return PaymentDA.getPPurchaseID();
    }
}
