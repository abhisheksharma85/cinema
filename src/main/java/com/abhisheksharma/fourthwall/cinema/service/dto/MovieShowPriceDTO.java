package com.abhisheksharma.fourthwall.cinema.service.dto;

import com.abhisheksharma.fourthwall.cinema.domain.MoviePrice;
import com.abhisheksharma.fourthwall.cinema.domain.MovieShowTime;
import com.abhisheksharma.fourthwall.cinema.service.util.HelperUtil;

import java.util.ArrayList;
import java.util.List;

public class MovieShowPriceDTO {

    private Long showTimeId;

    private List<Pricing> price;

    public MovieShowPriceDTO() {}

    public MovieShowPriceDTO(Long showTimeId) {
        this.showTimeId = showTimeId;
    }

    public MovieShowPriceDTO(Long showTimeId, List<Pricing> price) {
        this.showTimeId = showTimeId;
        this.price = price;
    }

    public Long getShowTimeId() { return showTimeId; }

    public void setShowTimeId(Long showTimeId) { this.showTimeId = showTimeId; }

    public List<Pricing> getPrice() { return price; }

    public void setPricing(List<MoviePrice> price) {
        List<MovieShowPriceDTO.Pricing> _temp = new ArrayList<>(price.size());
        for(MoviePrice moviePrice: price){
            _temp.add(new MovieShowPriceDTO.Pricing(moviePrice.getId(), moviePrice.getPriceType().getName(),moviePrice.getPrice()));
        }
        this.price = _temp;
    }
    private class Pricing{

        private Long id;

        private String name;

        private Float price;

        public Pricing(Long id, String name, Float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }
    }
}
