package com.ews.api.webfluxdemo.converter;

import com.ews.api.webfluxdemo.json.Json;
import com.ews.api.webfluxdemo.model.Model;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<M extends Model, J extends Json> {

    M toModel(J json);

    J toJson(M model);

    default List<M> toListModel(final List<J> jsons) {
        return jsons
                .stream()
                .map(j -> this.toModel(j))
                .collect(Collectors.toList());
    }

    default List<J> toListJson(final List<M> models) {
        return models
                .stream()
                .map(m -> this.toJson(m))
                .collect(Collectors.toList());
    }

}
