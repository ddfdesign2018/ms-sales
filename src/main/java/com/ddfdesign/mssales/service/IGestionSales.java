package com.ddfdesign.mssales.service;

import com.ddfdesign.mssales.rest.dto.SaleDTO;

import java.util.List;

public interface IGestionSales {
    List<SaleDTO> getAllSales();
    SaleDTO getSaleById(Long idSale);
    SaleDTO createSaleById(SaleDTO saleDTO);
    boolean deleteSaleById(Long idSale);
    boolean updateSaleById(SaleDTO saleDTO);
}
