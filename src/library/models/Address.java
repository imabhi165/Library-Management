package library.models;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zipcode;

    //Constructor
    public Address(String street, String city, String state, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    //getter and Setter
     public String getStreet(){ return street;};
     public String getCity(){ return city;};
     public String getState(){ return state;};
     public String getZipcode(){ return zipcode;};

    //Method to Display Address
    public void displayAddress(){
        System.out.println("Address: "+street+ " , " +city+ " , " +state+ " , "+zipcode);
    }

    public String toString() {
        return street+ "," +city+ " , "+state+ " "+zipcode;
    }


}
