package com.ddfdesign.mssales.rest;

import com.ddfdesign.mssales.rest.dto.SaleDTO;
import com.ddfdesign.mssales.service.IGestionSales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
public class SaleResource {

    @Autowired
    IGestionSales iGestionSales;

    /**
     *
     * @return
     */
    @RequestMapping(value = "sale", method = RequestMethod.GET)
    public ResponseEntity<List<SaleDTO>> getAllSales() {
        List<SaleDTO> listaSales = iGestionSales.getAllSales();
        if (listaSales.isEmpty()) {
           return null;
        }
        return ResponseEntity.ok(listaSales);
    }

    /**
     *
     * @param idSale
     * @return
     */
    @RequestMapping(value = "sale/{idSale}", method = RequestMethod.GET)
    public ResponseEntity<SaleDTO> getSaleByIdClient(@PathVariable Long idSale) {
        SaleDTO listaSale = iGestionSales.getSaleById(idSale);
        if (listaSale==null){
            return null;
        }
        return ResponseEntity.ok(listaSale);
    }

    /**
     *
     * @param saleDTO
     * @return
     */
    @RequestMapping(value = "sale", method = RequestMethod.POST)
    public ResponseEntity<Void> createSale(@RequestBody SaleDTO saleDTO) {
        SaleDTO resultado = iGestionSales.createSaleById(saleDTO);
        if (resultado!=null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "sale/{idSale}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteSale(@PathVariable Long idSale) {
        String resultado = "";
        if (iGestionSales.deleteSaleById(idSale))
            resultado = "El sale con id " + idSale + " ha sido eliminado correctamente";
        else
            resultado = "El sale con id " + idSale + " no se ha podido borrar";
        return ResponseEntity.ok(resultado);
    }

    @RequestMapping(value = "sale", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateSale(@RequestBody SaleDTO saleDTO) {
        boolean resultado = iGestionSales.updateSaleById(saleDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
