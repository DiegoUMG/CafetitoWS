/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.beneficio.CafetitoWs.services;

import com.beneficio.CafetitoWs.dtos.ResponseMethodsDto;
import com.beneficio.CafetitoWs.models.CuentaModel;

/**
 *
 * @author santizo
 */
public interface CuentaService {

    public ResponseMethodsDto CreacionCuenta(CuentaModel cuenta) throws Exception;

}
