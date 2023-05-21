package org.nartov.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class LinkUserDTORequest extends LinkUserRequest{

    private String name;

    private String surname;

}
