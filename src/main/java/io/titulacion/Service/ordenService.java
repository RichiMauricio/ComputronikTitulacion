package io.titulacion.Service;


import io.titulacion.Model.cliente;
import io.titulacion.Model.orden;
import io.titulacion.Repository.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import io.titulacion.Repository.ordenRepository;

import java.util.List;

/**
 * Created by Mauricio on 04/02/2017.
 */
@Service("ordenService")
@Transactional(readOnly = true)
public class ordenService {
    @Autowired
    ordenRepository ordenRepository;

    public List<orden> getAll(){
        return ordenRepository.findAll();
    }

    public orden findByordNumero(Integer id){
        return ordenRepository.getOne(id);
    }

    @Transactional(readOnly = false)
    public orden saveOrden(orden orden){
        return ordenRepository.save(orden);
    }

    @Transactional(readOnly = false)
    public void deleteOrden(int ordNumero){
        ordenRepository.delete(ordNumero);
    }
}
