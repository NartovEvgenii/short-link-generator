package org.nartov.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class LinkUserDTO {

    private Long idUser;

    private String email;

    private String name;

    private String surname;

    private String token;

}
