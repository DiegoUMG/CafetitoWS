/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.CafetitoWs.Controllers;

import com.beneficio.CafetitoWs.dtos.ResponseMethodsDto;
import com.beneficio.CafetitoWs.models.CuentaModel;
import com.beneficio.CafetitoWs.services.CuentaService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author santizo
 */
@RestController
@RequestMapping("/cuenta")
@CrossOrigin("*")
public class CuentaController {

    @Autowired
    private CuentaService srvcuenta;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/creacionCuenta", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMethodsDto creacionCuenta(@RequestBody CuentaModel request) throws Exception {
        return srvcuenta.CreacionCuenta(request);
    }

//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/pruebaRuta", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public CuentaModel pruebaRuta(@RequestBody CuentaModel request, HttpServletRequest pRequest) {
//        return request;
//    }
}
