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

    public cliente getClientebyId(orden orden){
        int fkCli=orden.getFkCliId();
        return clienteRepository.findByCliId(fkCli);
    }

    //Verificar existencia de un cliente
    public boolean verificarCliente(String cliCedula){
        cliente existe = clienteRepository.findByCliCedula(cliCedula);
        if (existe!=null){
            return true;
        }else return false;
    }

    public cliente getClienteByCedula(String cedula) throws Exception {
        return clienteRepository.findByCliCedula(cedula);
    }

    @Transactional(readOnly = false)
    public cliente saveCliente(cliente cliente){
        return clienteRepository.save(cliente);
    }
}
