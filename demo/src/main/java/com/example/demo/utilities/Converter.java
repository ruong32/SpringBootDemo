package com.example.demo.utilities;

import org.modelmapper.ModelMapper;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {
    public static <F, T> T fromTo(F input, Class<T> destinationClass) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(input, destinationClass);
    }

    public static <F, T> List<T> fromToList(List<F> input, Class<T> destinationClass) {
        return input.stream().map(item -> fromTo(item, destinationClass)).collect(Collectors.toList());
    }
}
