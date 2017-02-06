package io.titulacion.Controller;

import io.titulacion.Model.cliente;
import io.titulacion.Repository.clienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Mauricio on 30/01/2017.
 */
@Controller
public class ClienteController {
    @Autowired
    private clienteRepository clienteRepository;

    @RequestMapping(value="/clienteShow", method= RequestMethod.GET)
    @Transactional(readOnly=true)
    public String list(Model model){
        model.addAttribute("clientes", clienteRepository.findAll());
        return "clienteShow";
    }
}
