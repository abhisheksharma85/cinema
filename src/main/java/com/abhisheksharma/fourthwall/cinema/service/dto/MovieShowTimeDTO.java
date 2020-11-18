package com.abhisheksharma.fourthwall.cinema.service.dto;

import com.abhisheksharma.fourthwall.cinema.domain.MovieShowTime;
import com.abhisheksharma.fourthwall.cinema.service.util.HelperUtil;

import java.util.ArrayList;
import java.util.List;

public class MovieShowTimeDTO {

    private Long showDateId;

    private Long movieId;

    private List<Timing> timings;

    public MovieShowTimeDTO(){}

    public MovieShowTimeDTO(Long movieId,Long showDateId) {
        this.movieId = movieId;
        this.showDateId = showDateId;
    }

    public Long getShowDateId() { return showDateId; }

    public void setShowDateId(Long showDateId) { this.showDateId = showDateId; }

    public Long getMovieId() { return movieId; }

    public void setMovieId(Long movieId) { this.movieId = movieId; }

    public List<Timing> getTimings() { return timings; }

    public void setTimings(List<MovieShowTime> timings) {
        List<Timing> _temp = new ArrayList<>(timings.size());
        for(MovieShowTime showTime: timings){
            _temp.add(new Timing(showTime.getId(), showTime.getShowTime().format(HelperUtil.getTimeFormat())));
        }
        this.timings = _temp;
    }

    private class Timing{
        private Long id;

        private String time;

        public Timing(Long id, String time){
            this.id = id;
            this.time = time;
        }

        public Long getId() { return id; }

        public void setId(Long id) { this.id = id; }

        public String getTime() { return time; }

        public void setTime(String time) { this.time = time; }
    }
}
