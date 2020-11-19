package com.abhisheksharma.fourthwall.cinema.service.dto;

import java.util.List;

public class MoviePriceDTO {

    private Long showTimeId;

    private List<IdValueDTO<Integer,Float>> price;

    public MoviePriceDTO(){}

    public MoviePriceDTO(Long showTimeId, List<IdValueDTO<Integer, Float>> price) {
        this.showTimeId = showTimeId;
        this.price = price;
    }

    public Long getShowTimeId() { return showTimeId; }

    public void setShowTimeId(Long showTimeId) { this.showTimeId = showTimeId; }

    public List<IdValueDTO<Integer, Float>> getPrice() { return price; }

    public void setPrice(List<IdValueDTO<Integer, Float>> price) { this.price = price; }

    @Override
    public String toString() {
        return "PriceDTO{" +
                "showTimeId=" + showTimeId +
                ", price=" + price +
                '}';
    }
}
