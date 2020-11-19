package com.abhisheksharma.fourthwall.cinema.service.dto;

import java.io.Serializable;

/**
 * Generic DTO for Id and Value Pair
 */
public class IdValueDTO<Long,T> implements Serializable {

    private Long id;

    private T value;

    public IdValueDTO(){}

    public IdValueDTO(Long id, T value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void add(Long id, T value){
        this.id = id;
        this.value = value;
    }

    @Override
    public java.lang.String toString() {
        return "Data{" +
                "id=" + getId() +
                ", value=" + getValue() +
                '}';
    }
}
