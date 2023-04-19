/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.beneficio.CafetitoWs.repositories;

import com.beneficio.CafetitoWs.models.UsuariosModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author santizo
 */
@Repository
public interface UsuarioRepository extends CrudRepository<UsuariosModel, Integer> {

    public UsuariosModel findByUsername(String username);
}
