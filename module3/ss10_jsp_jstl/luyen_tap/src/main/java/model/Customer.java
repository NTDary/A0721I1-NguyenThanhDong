package model;

public class Customer {
    String customerName;
    String customerBirthDay;
    String customerAddress;
    String customerImg;

    public Customer(){

    }

    public Customer(String customerName, String customerBirthDay, String customerAddress, String customerImg) {
        this.customerName = customerName;
        this.customerBirthDay = customerBirthDay;
        this.customerAddress = customerAddress;
        this.customerImg = customerImg;
    }
    //Getter
    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerBirthDay() {
        return customerBirthDay;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerImg() {
        return customerImg;
    }

    //Setter
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerBirthDay(String customerBirthDay) {
        this.customerBirthDay = customerBirthDay;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerImg(String customerImg) {
        this.customerImg = customerImg;
    }
}
