package com.kampus.core.service;

import java.util.List;

/**
 * Zeynel Abiddin Aydar 20/07/2024
 * */
public interface BaseService<CreateReq, IdType, GetByIdRes, GetAllRes, UpdateReq> {

    void add(CreateReq createReq);

    GetByIdRes getById(IdType id);

    List<GetAllRes> getAll();

    void update(UpdateReq updateRequest);

    void delete(IdType id);

}
