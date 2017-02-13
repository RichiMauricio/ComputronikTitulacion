package io.titulacion.Service;

import io.titulacion.Model.cliente;
import io.titulacion.Model.estado;
import io.titulacion.Model.orden;
import io.titulacion.Repository.estadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mauricio on 07/02/2017.
 */
@Service("estadoService")
@Transactional(readOnly = true)
public class EstadoService {
    @Autowired
    estadoRepository estadoRepository;

    public estado getEstadobyId(orden orden){
        int fkEstado=orden.getFkEstCodigo();
        return estadoRepository.getOne(fkEstado);
    }

    public List<estado> gelAll(){
        return estadoRepository.findAll();
    }
}
