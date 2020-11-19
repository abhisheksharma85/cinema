package com.abhisheksharma.fourthwall.cinema.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A Price Type.
 */
@Entity
@Table(name = "fw_cinema_price_type")
public class PriceType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    public PriceType(){}

    public PriceType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "PriceType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
