package io.titulacion.Repository;
import io.titulacion.Model.cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mauricio on 07/01/2017.
 */
public interface clienteRepository extends JpaRepository<cliente,Integer>, Serializable{
    //@Query("select o.ordId, o.fkCliId  from orden o where o.cliId.id=?1")
    cliente findByCliId(Integer id);
    cliente findByCliCedula(String cliCedula);
}