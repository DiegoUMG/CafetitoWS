/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.CafetitoWs.services.impl;

import com.beneficio.CafetitoWs.Constantes.Constantes;
import com.beneficio.CafetitoWs.dtos.ResponseMethodsDto;
import com.beneficio.CafetitoWs.models.TransportistaModel;
import com.beneficio.CafetitoWs.repositories.GeneralRepository;
import com.beneficio.CafetitoWs.services.TransportistaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.beneficio.CafetitoWs.repositories.TransportistaRepository;

/**
 *
 * @author santizo
 */
@Service
public class TransportistaServiceImpl implements TransportistaService {

    @Autowired
    private TransportistaRepository repoTransportista;

    @Autowired
    private GeneralRepository generalRepository;

    ResponseMethodsDto respMethod = new ResponseMethodsDto();

    @Override
    public String hola() {
        return "funciona ";
    }

    @Override
    public List<TransportistaModel> getTransportistaall() {
        return this.repoTransportista.findAll();
    }

    @Override
    public TransportistaModel getValidacionTransportistaByCodigo(String codigo) {
        return this.repoTransportista.getTransportistaByUsuario(codigo);
    }

    /**
     * METODO PARA VALIDAR AL TRANSPORTISTA BASADO EN EL USERNAME
     *
     * @author SANTIZO (DENNIS SANTIZO)
     * @since 18/04/2023
     * @param userName
     * @param tipoValidacion
     * @return
     */
    @Override
    public ResponseMethodsDto getValidacionTransportistaByUserName(String userName) {
        try {
            List<TransportistaModel> resp = repoTransportista.getTransportistaByCodigoList(userName);
            System.out.println("resp " + resp.toString());
            if (resp.size() > 0) {
                if (resp.get(0).getEstado() == Constantes.ESTADO_TR_ACTIVO) {
                    respMethod.setStatus(Constantes.RESPUESTA_OK);
                    respMethod.setCode(String.valueOf(HttpStatus.OK));
                    respMethod.setMessage("EL TRANSPORTISTA SE ENCUENTRA ACTIVO");
                } else {
                    respMethod.setStatus(Constantes.RESPUESTA_OK);
                    respMethod.setCode(String.valueOf(HttpStatus.OK));
                    respMethod.setMessage("EL TRANSPORTISTA SE ENCUENTRA INACTIVO");
                }
            } else {
                respMethod.setStatus("Success");
                respMethod.setCode(String.valueOf(HttpStatus.OK));
                respMethod.setMessage("EL TRANSPORTISTA NO SE ENCUENTRA REGISTRADO");
            }
        } catch (ResponseStatusException e) {
            System.out.println("error " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NO ES POSIBLE REALIZAR LA SOLICITUD");
        }
        return respMethod;
    }

    /**
     * METODO PARA LA CREACION DE UN TRANSPORTISTA 
     * @author SANTIZO (DENNIS SANTIZO)
     * @since 18/04/2023
     * @param transporte
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMethodsDto postTransportista(TransportistaModel transporte) throws Exception {
        List<TransportistaModel> resp = repoTransportista.getTransportistaByCodigoList(transporte.getNombreUsuario());
        if (resp.size() > 0) {
            respMethod.setStatus(Constantes.RESPUESTA_OK);
            respMethod.setCode(String.valueOf(HttpStatus.OK));
            respMethod.setMessage("EL TRANSPORTISTA YA SE ENCUENTRA REGISTRADO");
        } else {
            repoTransportista.save(transporte);
            respMethod.setStatus("Success");
            respMethod.setCode(String.valueOf(HttpStatus.OK));
            respMethod.setMessage("TRANSPORTISTA REGISTRADO");
            //throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EL TRANSPORTISTA NO SE ENCUENTRA REGISTRADO");
        }
        return respMethod;
    }

    /**
     * METODO PARA LA ACTUALIZACION DE UN TRANSPORTISTA
     * @author SANTIZO (DENNIS SANTIZO)
     * @since 18/04/2023
     * @param transporte
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMethodsDto putTransportista(TransportistaModel transporte) throws Exception {
        try {
            repoTransportista.save(transporte);
            respMethod.setStatus("Success");
            respMethod.setCode(String.valueOf(HttpStatus.OK));
            respMethod.setMessage("TRANSPORTISTA ACTUALIZADO");
            return respMethod;
        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NO ES POSIBLE REALIZAR LA SOLICITUD");
        }
    }

    /**
     * METODO PARA INHABILITAR A UN TRANSPORTISTA
     * @author SANTIZO (DENNIS SANTIZO)
     * @since 18/04/2023
     * @param codigoTransportista
     * @return
     * @throws Exception
     */
    @Override
    public ResponseMethodsDto deleteTransportista(String codigoTransportista) throws Exception {
        try {
            TransportistaModel resp = repoTransportista.getTransportistaByUsuario(codigoTransportista);
            resp.setEstado(Constantes.ESTADO_INACTIVO);
            repoTransportista.save(resp);

            respMethod.setStatus("Success");
            respMethod.setCode(String.valueOf(HttpStatus.OK));
            respMethod.setMessage("TRANSPORTISTA INACTIVADO");

            return respMethod;

        } catch (Exception e) {
            System.out.println("error " + e.getMessage());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NO ES POSIBLE REALIZAR LA SOLICITUD");
        }

    }
}
