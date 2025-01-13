package q3;

import java.io.Serializable;

public class Address implements Serializable {
private String buildingName;
private int streetNo;
private String area;
private String city;
private int pincode;

    public Address(String buildingName , int streetNo, String area, String city, int pincode) {
        this.area = area;
        this.buildingName = buildingName;
        this.city = city;
        this.pincode = pincode;
        this.streetNo  =streetNo;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(buildingName).append(" ").append(streetNo).append(" ").append(area)
                .append(" ").append(city).append(" ").append(pincode);
        return sb.toString();
    }

}
