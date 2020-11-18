package com.abhisheksharma.fourthwall.cinema.service.dto;


/**
 * A Parent DTO for the Movie entity.
 */
public class MovieDTO {

    private Long id;

    private String name;

    private String description;

    public MovieDTO(){}

    public MovieDTO(Long id, String name,String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
