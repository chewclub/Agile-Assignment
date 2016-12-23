package domain;

public class Insurance {
    private String InsuranceID;
    private String Description;
    private double Price;
    
    public Insurance(){
    }
    
    public Insurance(String InsuranceID, String Description, double Price) {
        this.InsuranceID = InsuranceID;
        this.Description = Description;
        this.Price = Price;
    }
    
    public String getInsuranceID() {
        return InsuranceID;
    }

    public void setInsuranceID(String InsuranceID) {
        this.InsuranceID = InsuranceID;
    }
    
    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    
}
