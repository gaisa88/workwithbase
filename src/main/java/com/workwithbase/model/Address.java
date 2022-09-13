package com.workwithbase.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apartment")
    private int apartment;

    @Column(name = "kato_id")
    private int kato_id;

    @Column(name="region_name")
    private String region_name;

    @Column(name = "street_place")
    private String street_place;

    public Address(Long id, int apartment, int kato_id, String region_name, String street_place) {
        this.id = null;
        this.apartment = apartment;
        this.kato_id = kato_id;
        this.region_name = region_name;
        this.street_place = street_place;
    }

    public Address() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public int getKato_id() {
        return kato_id;
    }

    public void setKato_id(int kato_id) {
        this.kato_id = kato_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getStreet_place() {
        return street_place;
    }

    public void setStreet_place(String street_place) {
        this.street_place = street_place;
    }

    public String toString() {// переопределение метода toString для вывода данных в json
        return String.format(
                "Address[id=%d, katoId=%d, regionName='%s', streetPlace='%s', appertment=%d]",
                id, kato_id, region_name, street_place, apartment);
    }
}
