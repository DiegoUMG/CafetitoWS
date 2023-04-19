/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.CafetitoWs.services.impl;

import com.beneficio.CafetitoWs.repositories.GeneralRepository;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author santizo
 */
@Service
public class MetodosGeneralServices {

    @Autowired 
    private GeneralRepository repGeneral;
    
    Pattern expresionRegular = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    /**
     * METODO QUE SE UTILIZA PARA VALIDAR SINTAXIS DE UN CORREO ELECTRONICO
     *
     * @author SANTIZO (DENNIS SANTIZO)
     * @since 18/04/2023
     * @param email
     */
    public void validacionCorreoElectronico(String email) {
        // Patrón para validar el email 
        if (email == null || email.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EL EMAIL ES REQUERIDO");
        } else {
            Matcher mather = expresionRegular.matcher(email);
            if (mather.find() == false) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EMAIL INGRESADO ES INVALIDO");
            }
        }
    }

    /**
     * METODO PARA EVALUAR SI UNA IP ES VALIDA
     *
     * @author SANTIZO (DENNIS SANTIZO)
     * @since 18/04/2023
     * @param ip
     * @return
     */
    public Boolean isValidIPAddress(String ip) {

        String zeroTo255
                = "(\\d{1,2}|(0|1)\\"
                + "d{2}|2[0-4]\\d|25[0-5])";

        String regex
                = zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255 + "\\."
                + zeroTo255;

        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        if (ip == null) {
            return false;
        }
        Matcher m = p.matcher(ip);
        if (m.matches() == false) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "IP INGRESADA INVALIDA");
        }
        return m.matches();
    }

    /**
     * METODO PARA OBTENER EL ULTIMO CORRELATIVO DE UNA TABLA
     * @author SANTIZO (DENNIS SANTIZO)
     * @since 18/04/2023
     * @param pTable
     * @param pColumn
     * @return 
     */
    public int getTablaId(String pTable, String pColumn) {
        try {
            return Integer.parseInt(repGeneral.getId(pTable, pColumn));
        } catch (NumberFormatException e) {
            System.out.println("OCURRIO UN ERROR AL OBTENER EL ULTIMO ID " + e.toString());
            return 0;
        }
    }
}
