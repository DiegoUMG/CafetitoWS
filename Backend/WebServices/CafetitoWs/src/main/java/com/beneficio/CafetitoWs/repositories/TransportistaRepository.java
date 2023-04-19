/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.beneficio.CafetitoWs.repositories;

import com.beneficio.CafetitoWs.models.TransportistaModel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author santizo
 */
@Repository
public interface TransportistaRepository extends JpaRepository<TransportistaModel, Integer> {

    @Override
    List<TransportistaModel> findAll();

    @Query(value = "select * from bd_beneficio_cafetito.bd_transportista bt where bt.nombre_usuario  =:pusuario", nativeQuery = true)
    TransportistaModel getTransportistaByUsuario(@Param("pusuario") String codigo);

    @Query(value = "select * from bd_beneficio_cafetito.bd_transportista bt where bt.nombre_usuario  =:userName", nativeQuery = true)
    List<TransportistaModel> getTransportistaByCodigoList(@Param("userName") String puserName);

}
