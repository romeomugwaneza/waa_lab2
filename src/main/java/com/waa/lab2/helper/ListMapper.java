package com.waa.lab2.helper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListMapper<T, U> {

    @Autowired
    ModelMapper modelMapper;

    public List<?> mapList(List<T> list, U convertTo){

        return list.stream()
                .map(e -> modelMapper.map(e, convertTo.getClass()))
                .collect(Collectors.toList());
    }

}
