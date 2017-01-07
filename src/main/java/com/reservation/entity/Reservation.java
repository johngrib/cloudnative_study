package com.reservation.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Reservation(String name) {
        System.out.println(name);
        this.name = name;
    }

    public Reservation() {
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

