package com.abhisheksharma.fourthwall.cinema.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class DateTimeDTO {

    private LocalDate showDate;

    @JsonFormat(pattern = "HH:mm:ss")
    private List<LocalTime> showTime;

    public DateTimeDTO(){}

    public DateTimeDTO(LocalDate showDate, List<LocalTime> showTime) {
        this.showDate = showDate;
        this.showTime = showTime;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public List<LocalTime> getShowTime() {
        return showTime;
    }

    public void setShowTime(List<LocalTime> showTime) {
        this.showTime = showTime;
    }
}
