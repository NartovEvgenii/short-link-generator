package org.nartov.dto;

import lombok.Data;

@Data
public class LinkUserRequest {

    private String email;

    private String password;
}
