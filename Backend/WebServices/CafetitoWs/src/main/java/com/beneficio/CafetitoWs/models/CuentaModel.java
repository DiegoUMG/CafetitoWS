/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.CafetitoWs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author santizo
 */
@Setter
@Getter
@Entity
@Table(name = "cuentas", schema = "bd_beneficio_cafetito")
public class CuentaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CUENTA")
    private Long id;

    @Column(name = "NO_CUENTA")
    private String noCuenta;

    @Column(name = "NIT_PRODUCTOR")
    private String nitProductor;

    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;

    @Column(name = "PESAJE_TOTAL_KG")
    private int pesajeTotalKg;

//    @Column(name = "SECUENCIA")
//    @JsonIgnore
//    private int secuencia;
    @Column(name = "CUI_REPRESENTANTE")
    private String cuiRepresentante;

    @Column(name = "TIPO_CAFE")
    private String tipoCafe;

    @Column(name = "usuario_adiciono")
    private String usuarioAdiciono;

    @Column(name = "FECHA_ADICION")
    private Timestamp fechaAdicion;

    @Column(name = "usuario_modifico")
    private String usuarioModifico;

    @Column(name = "fecha_modifico")
    private Timestamp fechaModifico;


//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cuenta")
//    //@JsonIgnore
//    private Set<TbEstadoCuenta> estado = new HashSet<>();

    @Override
    public String toString() {
        return "CuentaModel{" + "id=" + id + ", noCuenta=" + noCuenta + ", nitProductor=" + nitProductor + ", razonSocial=" + razonSocial + ", pesajeTotalKg=" + pesajeTotalKg + ", cuiRepresentante=" + cuiRepresentante + ", tipoCafe=" + tipoCafe + ", usuarioAdiciono=" + usuarioAdiciono + ", fechaAdicion=" + fechaAdicion + ", usuarioModifico=" + usuarioModifico + ", fechaModifico=" + fechaModifico + '}';
    }
}
