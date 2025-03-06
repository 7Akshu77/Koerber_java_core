package com.demo.orderapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;
    private String street;
    private String city;
    private String state;
    private int pincode;

    public Address(String street, String city, String state, int pincode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }
    public String toString(){
       StringBuilder sb = new StringBuilder();
       sb.append("Address{" + "street='" + street + '\'' + ", city='" + city + '\'' + ", state='" + state + '\'' + ", pincode=" + pincode + '}');
       return sb.toString();
    }
}

