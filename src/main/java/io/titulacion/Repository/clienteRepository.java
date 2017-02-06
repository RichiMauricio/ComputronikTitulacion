package io.titulacion.Repository;
import io.titulacion.Model.cliente;
import io.titulacion.Model.orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mauricio on 07/01/2017.
 */
public interface clienteRepository extends JpaRepository<cliente,Integer>, Serializable{
    //@Query("select o.ordId, o.fkCliId  from orden o where o.cliId.id=?1")
    cliente findByCliId(int id);
    cliente findByCliCedula(String cedula);
}