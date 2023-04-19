/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.CafetitoWs.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

/**
 *
 * @author santizo
 */
@Setter
@Getter
@Entity
@DynamicUpdate
@Table(name = "bd_transportista", schema = "bd_beneficio_cafetito")
public class TransportistaModel implements Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_transportista")
    private Integer codigoTransportista;
    @Column(name = "estado")
    private Integer estado;
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "usuario_adiciono")
    private String usuarioAdiciono;
    @Column(name = "fecha_adiciono")
    private Date fechaAdiciono;
    @Column(name = "usuario_modifico")
    private String usuarioModifico;
    @Column(name = "fecha_modifico")
    private Date fechaModifico;

    public TransportistaModel() {
    }

    public TransportistaModel(Integer codigoTransportista, Integer estado, String nombreUsuario, String correoElectronico, String direccion, String usuarioAdiciono, Date fechaAdiciono, String usuarioModifico, Date fechaModifico) {
        this.codigoTransportista = codigoTransportista;
        this.estado = estado;
        this.nombreUsuario = nombreUsuario;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
        this.usuarioAdiciono = usuarioAdiciono;
        this.fechaAdiciono = fechaAdiciono;
        this.usuarioModifico = usuarioModifico;
        this.fechaModifico = fechaModifico;
    }

    @Override
    public String toString() {
        return "TransportistaModel{" + "codigoTransportista=" + codigoTransportista + ", estado=" + estado + ", nombreUsuario=" + nombreUsuario + ", correoElectronico=" + correoElectronico + ", direccion=" + direccion + ", usuarioAdiciono=" + usuarioAdiciono + ", fechaAdiciono=" + fechaAdiciono + ", usuarioModifico=" + usuarioModifico + ", fechaModifico=" + fechaModifico + '}';
    }

    
    
}
