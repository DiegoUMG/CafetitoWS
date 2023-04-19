/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.CafetitoWs.Controllers;

import com.beneficio.CafetitoWs.dtos.ResponseMethodsDto;
import com.beneficio.CafetitoWs.dtos.ValidacionesTransportistaDto;
import com.beneficio.CafetitoWs.models.TransportistaModel;
import com.beneficio.CafetitoWs.services.TransportistaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/transportista")
@CrossOrigin("*")
public class TransportistaController {

    @Autowired
    private TransportistaService srvTransportista;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/getValidacionTransportistaByUserName", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMethodsDto getValidacionTransportistaByUserName(@RequestBody ValidacionesTransportistaDto paramsTr) {
        return this.srvTransportista.getValidacionTransportistaByUserName(paramsTr.getUsuarioTransportista());
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/codigoTransportista/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMethodsDto<TransportistaModel> obtenerUsuario(@PathVariable("username") String username) {
        return new ResponseMethodsDto<>("Succes", String.valueOf(HttpStatus.OK), "OK", srvTransportista.getValidacionTransportistaByCodigo(username));
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/creacionTransportista", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMethodsDto postTransportista(@RequestBody TransportistaModel request) throws Exception {
        return srvTransportista.postTransportista(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/actualizacionTransportista", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMethodsDto putTransportista(@RequestBody TransportistaModel request) throws Exception {
        return srvTransportista.putTransportista(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/desactivarTransportista", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseMethodsDto deleteTransportista(@RequestBody ValidacionesTransportistaDto paramsTr) throws Exception {
        return srvTransportista.deleteTransportista(paramsTr.getUsuarioTransportista());
    }

//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/pruebaRutaTransporte", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public TransportistaModel pruebaRuta(@RequestBody TransportistaModel request) {
//        return request;
//    }
    //    @RequestMapping(value = "/trasnportistaEjemplo", method = RequestMethod.GET)
//    public List<TransportistaModel> getByIdTransportista() {
//        return this.srvTransportista.getTransportistaall();
//    }
}
