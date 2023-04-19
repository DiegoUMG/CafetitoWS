/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.beneficio.CafetitoWs.services;

import com.beneficio.CafetitoWs.dtos.ResponseMethodsDto;
import com.beneficio.CafetitoWs.models.TransportistaModel;
import java.util.List;
import java.util.Set;

/**
 *
 * @author santizo
 */
public interface TransportistaService {

    String hola();

    List<TransportistaModel> getTransportistaall();

    TransportistaModel getValidacionTransportistaByCodigo(String codigo);

    ResponseMethodsDto getValidacionTransportistaByUserName(String userName);

    ResponseMethodsDto postTransportista(TransportistaModel transporte) throws Exception;

    ResponseMethodsDto putTransportista(TransportistaModel transporte) throws Exception;

    ResponseMethodsDto deleteTransportista(String codigoTransportista) throws Exception;

}
