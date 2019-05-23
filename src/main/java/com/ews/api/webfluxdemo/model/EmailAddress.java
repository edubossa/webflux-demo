package com.ews.api.webfluxdemo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data(staticConstructor = "of")
public class EmailAddress implements Model {

    @Field("email")
    private String value;

}
