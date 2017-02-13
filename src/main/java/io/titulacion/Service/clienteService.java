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

    /*public boolean addCliente(cliente cl) throws Exception {
        cliente antiguo = clienteRepository.findByCliCedula(cl.getCliCedula());
        if (antiguo!=null){
            throw new Exception("Ya existe ese cliente");
        }else {
            clienteRepository.save(cl);
        }
        return true;
    }*/

    public List<cliente> getAll(){
        return clienteRepository.findAll();
    }

    public cliente getClientebyId(orden orden){
        int fkCli=orden.getFkCliId();
        return clienteRepository.findByCliId(fkCli);
    }

    public cliente getClienteByCedula(String cedula) throws Exception {
        return clienteRepository.findByCliCedula(cedula);
    }

    public cliente getClienteById(Integer cliId){
        return clienteRepository.findByCliId(cliId);
    }

    @Transactional(readOnly = false)
    public cliente saveCliente(cliente cliente){
        return clienteRepository.save(cliente);
    }
}
