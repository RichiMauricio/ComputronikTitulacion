package io.titulacion.Repository;

import io.titulacion.Model.detalleOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Mauricio on 13/02/2017.
 */
public interface DetalleOrdenRepository extends JpaRepository<detalleOrden,Integer>{

}
