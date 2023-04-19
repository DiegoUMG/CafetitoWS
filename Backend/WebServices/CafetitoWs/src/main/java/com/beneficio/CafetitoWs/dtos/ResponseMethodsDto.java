/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.CafetitoWs.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author santizo
 */
@Setter
@Getter
public class ResponseMethodsDto<T> {

    private String status;
    private String code;
    private String message;
    private T data;

    public ResponseMethodsDto() {
    }

    public ResponseMethodsDto(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public ResponseMethodsDto(String status, String code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
