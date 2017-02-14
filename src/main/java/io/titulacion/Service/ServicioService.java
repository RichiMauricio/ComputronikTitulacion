package io.titulacion.Service;

import io.titulacion.Model.servicio;
import io.titulacion.Repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mauricio on 13/02/2017.
 */
@Service("ServicioService")
@Transactional(readOnly = true)
public class ServicioService {

    @Autowired
    private ServicioRepository servicioRepository;

    public List<servicio> gelAll(){
        return servicioRepository.findAll();
    }
}
