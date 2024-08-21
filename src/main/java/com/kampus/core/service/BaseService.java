package com.kampus.core.service;

import com.kampus.core.utilities.exceptions.BusinessException;
import com.kampus.service.responses.authentication.AuthenticationResponse;

import java.util.List;

import static com.kampus.core.handler.BusinessErrorCodes.NO_CODE;

public abstract class BaseService<CreateReq, IdType, GetByIdRes, GetAllRes, UpdateReq> {

    protected void handleUnsupportedOperation() {
        throw new BusinessException(
                NO_CODE.getCode(),
                NO_CODE.getHttpStatus(),
                NO_CODE.getDescription()
        );
    }

    public void add(CreateReq req) {
        handleUnsupportedOperation();
    }

    public GetByIdRes getById(IdType id) {
        handleUnsupportedOperation();
        return null;
    }

    public List<GetAllRes> getAll() {
        handleUnsupportedOperation();
        return null;
    }

    public AuthenticationResponse update(UpdateReq req) {
        handleUnsupportedOperation();
        return null;
    }

    public void delete(IdType id) {
        handleUnsupportedOperation();
    }
}
