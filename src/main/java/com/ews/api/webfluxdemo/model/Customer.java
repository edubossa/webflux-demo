package com.ews.api.webfluxdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Document
public class Customer implements Model {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String phone;
    private String cellPhone;

    @Field("email")
    @Indexed(unique = true)
    private EmailAddress emailAddress;

    private Set<Address> addresses = new HashSet<>();

    public void add(Address address) {
        this.addresses.add(address);
    }

}
