package io.titulacion.Service;

import io.titulacion.Model.detalleOrden;
import io.titulacion.Model.orden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.titulacion.Repository.DetalleOrdenRepository;

import java.util.List;

/**
 * Created by Mauricio on 13/02/2017.
 */
@Service("DetalleOrdenService")
@Transactional(readOnly = true)
public class DetalleOrdenService {

    @Autowired
    DetalleOrdenRepository detalleOrdenRepository;

    @Transactional(readOnly = true)
    public detalleOrden saveDetalleOrden(detalleOrden detalleOrden){
        return detalleOrdenRepository.save(detalleOrden);
    }

    public List<detalleOrden> getAll(){
        return detalleOrdenRepository.findAll();
    }

    @Transactional(readOnly = false)
    public void deleteDetalleOrden(int ordNumero){
        detalleOrdenRepository.delete(ordNumero);
    }
}
