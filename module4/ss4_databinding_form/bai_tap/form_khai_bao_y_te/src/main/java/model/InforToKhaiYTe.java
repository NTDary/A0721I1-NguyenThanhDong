package model;

public class InforToKhaiYTe {
    private String name;
    private int year;
    private String gender;
    private String country;
    private String idCard;
    private String nameVehicle;
    private String idVehicle;
    private int numberSeats;
    private String startDay;
    private String endDay;
    private String description;
    private String city;
    private String district;
    private String ward;
    private String currentAddress;
    private String phone;
    private String email;

    private String[] symptoms;
    private String[] exposureHistory;

    public InforToKhaiYTe() {
    }

    public InforToKhaiYTe(String name, int year, String gender, String country, String idCard, String nameVehicle, String idVehicle, int numberSeats, String startDay, String endDay, String description, String city, String district, String ward, String currentAddress, String phone, String email, String[] symptoms, String[] exposureHistory) {
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.country = country;
        this.idCard = idCard;
        this.nameVehicle = nameVehicle;
        this.idVehicle = idVehicle;
        this.numberSeats = numberSeats;
        this.startDay = startDay;
        this.endDay = endDay;
        this.description = description;
        this.city = city;
        this.district = district;
        this.ward = ward;
        this.currentAddress = currentAddress;
        this.phone = phone;
        this.email = email;
        this.symptoms = symptoms;
        this.exposureHistory = exposureHistory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = nameVehicle;
    }

    public String getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle) {
        this.idVehicle = idVehicle;
    }

    public int getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(int numberSeats) {
        this.numberSeats = numberSeats;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String[] symptoms) {
        this.symptoms = symptoms;
    }

    public String[] getExposureHistory() {
        return exposureHistory;
    }

    public void setExposureHistory(String[] exposureHistory) {
        this.exposureHistory = exposureHistory;
    }
}
