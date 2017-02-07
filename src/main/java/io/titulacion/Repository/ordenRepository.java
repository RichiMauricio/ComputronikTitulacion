package io.titulacion.Repository;

import io.titulacion.Model.cliente;
import io.titulacion.Model.orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

/**
 * Created by Mauricio on 31/01/2017.
 */
public interface ordenRepository extends JpaRepository <orden,Integer>, Serializable {
}
