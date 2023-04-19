/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.CafetitoWs.services.impl;

import com.beneficio.CafetitoWs.Constantes.Constantes;
import com.beneficio.CafetitoWs.dtos.ResponseMethodsDto;
import com.beneficio.CafetitoWs.models.CuentaModel;
import com.beneficio.CafetitoWs.repositories.CuentaRepository;
import com.beneficio.CafetitoWs.services.CuentaService;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author santizo
 */
@Service
public class CuentaServiceImplement implements CuentaService {

    @Autowired
    CuentaRepository repository;

    /**
     * METODO PARA LA CREACION DE UNA CUENTA
     * @author SANTIZO (DENNIS SANTIZO)
     * @since 18/04/2023
     * @param cuenta
     * @return
     * @throws Exception 
     */
    @Override
    @Transactional
    public ResponseMethodsDto CreacionCuenta(CuentaModel cuenta) throws Exception {
        try {
            //Optional<CuentaModel> username = this.userSvc.findUsuarioByCui(cuenta.getCuiRepresentante());
            ResponseMethodsDto respMethod = new ResponseMethodsDto();
            CuentaModel newData = new CuentaModel();

            int secuencia = this.repository.noMaxCuenta();

            //String noCuenta1 = Integer.toString(new Integer(LocalDate.now().getYear()).shortValue()) + "BC" + secuencia);
            //System.out.println("cuenta 1 " + noCuenta1);
            String noCuenta = "prueba001";
            newData.setNitProductor(cuenta.getNitProductor());
            newData.setRazonSocial(cuenta.getRazonSocial());
            newData.setPesajeTotalKg(cuenta.getPesajeTotalKg());
            newData.setCuiRepresentante(cuenta.getCuiRepresentante());
            newData.setTipoCafe(cuenta.getTipoCafe());
            newData.setFechaAdicion(new Timestamp(new Date().getTime()));
            newData.setNoCuenta(noCuenta);
            //newData.setSecuencia(secuencia);
//        newData.setAdiciono(username.get().getUsername());
            newData.setUsuarioAdiciono("DISANTIZ");

            repository.save(newData);
            
            respMethod.setStatus(Constantes.RESPUESTA_OK);
            respMethod.setCode(String.valueOf(HttpStatus.OK));
            respMethod.setMessage("CUENTA CREADA CON EXITO");

            return respMethod;
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NO ES POSIBLE REALIZAR LA SOLICITUD CUENTA SERVICE");
        }

    }

}
