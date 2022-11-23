package ar.edu.unrn.userservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClientMessage implements Serializable{

    private Long id;
    private String name;
}
