package com.ews.api.webfluxdemo.converter;

import com.ews.api.webfluxdemo.json.AddressJson;
import com.ews.api.webfluxdemo.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConverter implements Converter<Address, AddressJson> {

    @Override
    public Address toModel(AddressJson json) {
        return Address
                .builder()
                    .country(json.getCountry())
                    .city(json.getCity())
                    .street(json.getStreet())
                    .number(json.getNumber())
                .build();
    }

    @Override
    public AddressJson toJson(Address model) {
        return AddressJson
                .builder()
                    .country(model.getCountry())
                    .city(model.getCity())
                    .street(model.getStreet())
                    .number(model.getNumber())
                .build();
    }

}
