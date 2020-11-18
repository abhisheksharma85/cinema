package com.abhisheksharma.fourthwall.cinema.service.util;


import com.abhisheksharma.fourthwall.cinema.config.ApplicationProperties;
import com.abhisheksharma.fourthwall.cinema.service.dto.OMDBDataDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class ExternalDataUtil {

    private final RestTemplate restTemplate;

    private final ApplicationProperties applicationProperties;

    public ExternalDataUtil(ApplicationProperties applicationProperties, RestTemplate restTemplate){
        this.applicationProperties = applicationProperties;
        this.restTemplate = restTemplate;
    }

    public OMDBDataDTO getOMDBData(String id){

        StringBuilder url = new StringBuilder(applicationProperties.getOMDBProp().getUrl()).append("/?i=").append(id).append("&apikey=").append(applicationProperties.getOMDBProp().getApiKey());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        ResponseEntity<String> response = restTemplate.getForEntity(url.toString(),String.class);

        OMDBDataDTO omdbDataDTO = null;

        ObjectMapper mapper = new ObjectMapper();

        if(response.getStatusCodeValue() == HttpStatus.OK.value()) {
            try {
                omdbDataDTO = mapper.readValue(response.getBody(), OMDBDataDTO.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return omdbDataDTO;

    }




}
