package org.example.commands;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.* ;

public class SpringClient {

    public static  String FlaskChack( String  number , String algo) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8000/" + algo + "?number=" + number;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> jsonResponse = mapper.readValue(response.getBody(), Map.class);
            return (String) jsonResponse.get("message");
        } catch (Exception e) {
            e.printStackTrace();
            return "Error parsing response";
        }
    }
}
