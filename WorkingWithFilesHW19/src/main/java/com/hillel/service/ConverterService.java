package com.hillel.service;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface ConverterService {
    //Конвертация
    String convert (String data) throws JsonProcessingException;
}
