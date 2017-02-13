package io.titulacion.Controller;

import io.titulacion.Model.cliente;
import io.titulacion.Model.orden;
import io.titulacion.Repository.clienteRepository;
import io.titulacion.Service.clienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Mauricio on 30/01/2017.
 */
@Controller
public class ClienteController {
    @Autowired
    private clienteService clienteService;

    @RequestMapping(value="/ordenAdd/{cliId}")
    public String newOrden(Model model, @RequestParam("cliCedula") String cliCedula) throws Exception {
        cliente existe = clienteService.getClienteByCedula(cliCedula);
        if (existe!=null){
            model.addAttribute("clientes", clienteService.getClienteByCedula(cliCedula));
            return "clienteShow";
        }else {
            return "redirect:/ordenAdd/clienteAdd";
        }
    }

    @RequestMapping(value="ordenAdd/clienteAdd", method = RequestMethod.GET)
    public String newCliente(Model model){
        model.addAttribute("cliente", new cliente());
        return "clienteAdd";
    }

    @RequestMapping(value = "/clienteAdd", method = RequestMethod.POST)
    public String saveCliente(@Valid cliente cliente, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "clienteAdd";
        }else {
            clienteService.saveCliente(cliente);
            return "redirect:/ordenAdd/ordenAddCli/"+cliente.getCliId();
        }
    }
}