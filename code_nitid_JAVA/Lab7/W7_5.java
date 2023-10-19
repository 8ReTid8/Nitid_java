public class W7_5 {
    public static void main(String[] args) {
        Employee emp = new Manager();

        Address add = new Address();
        add.setCity("Bangkok");
        add.setStreet("Road");

        emp.setAddress(add);
        emp.setId(12312);
        emp.setName("test");
        emp.setSalary(20000);
        
        System.out.println(emp.getDetails());

    }

}

class Employee {
    protected int id;
    protected String name;
    protected double salary;
    protected Address address;

    public String getDetails() {
        return "id: "+id+" name: "+name+" salary: "+salary;
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}

class Manager extends Employee {
    protected String parkingNo;

    public String getParkingNo() {
        return parkingNo;
    }
    public void setParkingNo(String parkingNo) {
        this.parkingNo = parkingNo;
    }
    public String getDetails() {
        return "id: "+id+" name: "+name+" salary: "+salary+"\n"+"ParkingNo: "+parkingNo;
    }
}

class Address {
    protected String street;
    protected String city;

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getAddressInfo() {
        return "Street: "+street+"\n"+"City: "+city;
    }
}