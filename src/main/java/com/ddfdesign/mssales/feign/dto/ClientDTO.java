package com.ddfdesign.mssales.feign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private Long id;
    private String name;
    private String surnames;
    private String dni;
    private String phone;
    private String address;
    private String email;
    private String status;
    private Date last_buy;
}
