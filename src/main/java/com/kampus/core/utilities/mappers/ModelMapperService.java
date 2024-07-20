package com.kampus.core.utilities.mappers;

import org.modelmapper.ModelMapper;


/**
 * Zeynel Abiddin Aydar 20/07/2024
 * */
public interface ModelMapperService {
    ModelMapper forResponse();

    ModelMapper forRequest();
}
