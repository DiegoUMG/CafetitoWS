/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.beneficio.CafetitoWs.repositories;

import com.beneficio.CafetitoWs.models.TransportistaModel;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author santizo
 */
@Repository
public class GeneralRepository {

    private static final Logger logger = Logger.getLogger(GeneralRepository.class.getName());

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * QUERY PARA OBTENER TODA LA INFORMACION DE UNA CITA MEDIANTE EL NUMERO DE
     * CITA
     *
     * @author DISANTIZ (DENNIS SANTIZO)
     * @param codigo
     * @since 30/03/2023
     * @return
     */
    public List<TransportistaModel> getTransportistaByCodigo(String codigo) {
        String query = "select * from bd_beneficio_cafetito.bd_transportista bt where bt.codigo_transportista =:pcodigo";
        Query q = entityManager.createNativeQuery(query, TransportistaModel.class);
        q.setParameter("pcodigo", codigo);
        return q.getResultList();
    }

    /**
     * QUERY PARA OBTENER EL ULTIMO CORRELATIVO DE LA TABLA INGRESADA
     *
     * @author DISANTIZ (DENNIS SANTIZO)
     * @since 18/04/2023
     * @param pTable
     * @param pColumn
     * @return
     */
    public String getId(String pTable, String pColumn) {
        String query = "select coalesce (max(" + pTable + "." + pColumn
                + "), 0) + 1 from sat_cita_validada." + pTable;
        Query q = entityManager.createNativeQuery(query);
        return q.getResultList().get(0).toString();
    }
}
