package io.titulacion.Service;

import io.titulacion.Model.cliente;
import io.titulacion.Model.orden;
import io.titulacion.Repository.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Created by Mauricio on 07/01/2017.
 */
@Service("clienteService")
@Transactional(readOnly = true)
public class clienteService{

    @Autowired
    clienteRepository clienteRepository;

    @Transactional(readOnly = false)
    public boolean addCliente(cliente cl) throws Exception {
        cliente antiguo = clienteRepository.findByCliCedula(cl.getCliCedula());
        if (antiguo!=null){
            throw new Exception("Ya existe ese cliente");
        }else {
            clienteRepository.save(cl);
        }
        return true;
    }

    public List<cliente> getAll(){
        return clienteRepository.findAll();
    }

    public cliente getClientebyId(int id){
        return clienteRepository.findByCliId(id);
    }

    public cliente getClienteByCedula(String cedula){
        return clienteRepository.findByCliCedula(cedula);
    }
}
