package com.ddfdesign.mssales.feign;

import com.ddfdesign.mssales.feign.dto.ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "clients-ms")
public interface Client {
    @RequestMapping(value = "clientOne/{idClient}", method = RequestMethod.GET)
    public ClientDTO getClientByIdClientOne(@PathVariable("idClient") Long idClient);

    @RequestMapping(value = "clientList", method = RequestMethod.GET)
    public List<ClientDTO> getAllClientsList();
}

