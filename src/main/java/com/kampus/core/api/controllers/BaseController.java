package com.kampus.core.api.controllers;


import java.util.List;

/**
 * Zeynel Abiddin Aydar 20/07/2024
 * */
public interface BaseController<CreateReq, IdType, GetByIdRes, GetAllRes, UpdateReq> {

    //@PostMapping("/create")
    void create(/*@RequestBody*/CreateReq req);

    //@GetMapping("/getbyid")
    GetByIdRes getById(IdType id);

    //@GetMapping("/getall")
    List<GetAllRes> getAll();

    //@PutMapping("/update")
    void update(UpdateReq req);

    //@DeleteMapping("/delete")
    void delete(IdType id);
}

