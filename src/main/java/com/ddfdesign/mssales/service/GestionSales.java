package com.ddfdesign.mssales.service;

import com.ddfdesign.mssales.entity.Sale;
import com.ddfdesign.mssales.feign.Client;
import com.ddfdesign.mssales.repository.ISalesRepository;
import com.ddfdesign.mssales.rest.dto.SaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GestionSales implements IGestionSales {

    @Autowired
    ISalesRepository iSalesRepository;

    @Autowired
    Client client;

    @Override
    public List<SaleDTO> getAllSales(){
        List<SaleDTO> lista = iSalesRepository.findAll()
                .stream()
                .map(
                        saleEntity -> new SaleDTO(
                                saleEntity.getId(),
                                saleEntity.getAmount(),
                                saleEntity.getDate(),
                                saleEntity.getClient()
                        )
                ).collect(Collectors.toList());
        return lista;
    }

    @Override
    public SaleDTO getSaleById(Long idSale){
        Optional<Sale> saleOptional = iSalesRepository.findById(idSale);

        if (saleOptional.isPresent())
        {
            Sale sale = saleOptional.get();
            SaleDTO saleDTO = new SaleDTO(
                    sale.getId(),
                    sale.getAmount(),
                    sale.getDate(),
                    sale.getClient());
            return saleDTO;
        }
        else
            return null;
    }

    @Override
    public SaleDTO createSaleById(SaleDTO saleDTO){
        Sale sale = new Sale(
                null,
                saleDTO.getAmount(),
                saleDTO.getDate(),
                saleDTO.getClient()
        );
        /*System.out.println("ID Cliente desde Sale :" + client.getClientByIdClientOne(saleDTO.getClient()).getId());
        if (client.getClientByIdClientOne(saleDTO.getClient())== null)
            return null;
            */
        Sale resultado = iSalesRepository.save(sale);
        return new SaleDTO(resultado.getId(),
                resultado.getAmount(),
                resultado.getDate(),
                resultado.getClient()
        );
    }

    @Override
    public boolean deleteSaleById(Long idSale){
        boolean resultado = false;
        iSalesRepository.deleteById(idSale);
        Optional<Sale> saleOptional = iSalesRepository.findById(idSale);
        if (!saleOptional.isPresent())
            resultado = true;
        return resultado;
    }

    @Override
    public boolean updateSaleById(SaleDTO saleDTO){
        Sale sale = new Sale(
                saleDTO.getId(),
                saleDTO.getAmount(),
                saleDTO.getDate(),
                saleDTO.getClient()
                 );
        iSalesRepository.save(sale);
        return true;
    }
}
