package com.kampus.service.responses.userResponses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetUserByIdResponse {
    private int userId;
    private String username;
}
