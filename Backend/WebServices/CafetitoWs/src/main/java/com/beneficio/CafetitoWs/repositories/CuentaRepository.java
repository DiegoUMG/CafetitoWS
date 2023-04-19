/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.beneficio.CafetitoWs.repositories;

import com.beneficio.CafetitoWs.models.CuentaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author santizo
 */
public interface CuentaRepository extends JpaRepository<CuentaModel, Integer> {

    @Query(value = "select COALESCE (max(c.id_cuenta),0 ) + 1 as noCuenta from  bd_beneficio_cafetito.cuentas c",
            nativeQuery = true)
    public int noMaxCuenta();

}
