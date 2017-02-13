package io.titulacion.Repository;

import io.titulacion.Model.estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Mauricio on 07/02/2017.
 */
public interface estadoRepository extends JpaRepository<estado,Integer>, Serializable {
}
