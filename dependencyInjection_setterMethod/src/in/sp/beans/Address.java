package in.sp.beans;

public class Address {

    private int house_no;

    private String city;

    private int pincode;

    public int getHouse_no() {
        return house_no;
    }

    public void setHouse_no(int house_no) {
        this.house_no = house_no;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "house_no=" + house_no +
                ", city='" + city + '\'' +
                ", pincode=" + pincode +
                '}';
    }
}
