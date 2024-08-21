package com.kampus.core.api.controllers;

import com.kampus.core.utilities.exceptions.BusinessException;
import com.kampus.service.responses.authentication.AuthenticationResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.kampus.core.handler.BusinessErrorCodes.NO_CODE;

public abstract class BaseController<CreateReq, IdType, GetByIdRes, GetAllRes, UpdateReq> {

    protected <T> ResponseEntity<T> handleUnsupportedOperation() {
        throw new BusinessException(
                NO_CODE.getCode(),
                NO_CODE.getHttpStatus(),
                NO_CODE.getDescription()
        );
    }

    public ResponseEntity<Void> create(CreateReq req) {
        return handleUnsupportedOperation();
    }

    public ResponseEntity<GetByIdRes> getById(IdType id) {
        return handleUnsupportedOperation();
    }

    public ResponseEntity<List<GetAllRes>> getAll() {
        return handleUnsupportedOperation();
    }

    public ResponseEntity<AuthenticationResponse> update(UpdateReq updateRequest) {
        return handleUnsupportedOperation();
    }

    public ResponseEntity<Void> delete(IdType id) {
        return handleUnsupportedOperation();
    }
}
