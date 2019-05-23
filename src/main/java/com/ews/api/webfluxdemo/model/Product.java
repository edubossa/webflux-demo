package com.ews.api.webfluxdemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product implements Model {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

    private Map<String, String> attributes = new HashMap<>();

    public void addAttribute(String name, String value) {
        if (value == null) {
            this.attributes.remove(value);
        } else {
            this.attributes.put(name, value);
        }
    }


}
