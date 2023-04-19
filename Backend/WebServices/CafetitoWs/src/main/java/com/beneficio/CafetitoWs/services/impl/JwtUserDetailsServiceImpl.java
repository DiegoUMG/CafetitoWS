/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.CafetitoWs.services.impl;

import com.beneficio.CafetitoWs.models.UsuariosModel;
import com.beneficio.CafetitoWs.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author santizo
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
     private UsuarioRepository usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuariosModel usuario = this.usuarioRepo.findByUsername(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("usuario no existe");
        }
        return usuario;
    }
    
}
