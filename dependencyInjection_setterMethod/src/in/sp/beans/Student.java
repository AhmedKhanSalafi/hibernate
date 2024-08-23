package in.sp.beans;

public class Student {

    private int roll_no;

    private String name;

    private Address address;

    public int getRoll_no() {


        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll_no=" + roll_no +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }public void display(){

        System.out.println(" roll no :"+ roll_no);
        System.out.println(" name :"+ name);
        System.out.println(" Address :"+ getAddress());
    }


}
