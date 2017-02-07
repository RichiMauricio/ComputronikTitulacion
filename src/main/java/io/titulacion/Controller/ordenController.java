package io.titulacion.Controller;

import io.titulacion.Model.cliente;
import io.titulacion.Model.orden;
import io.titulacion.Service.ordenService;
import io.titulacion.Service.clienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Mauricio on 31/01/2017.
 */
@Controller
public class ordenController {

    @Autowired
    private ordenService ordenService;

    @Autowired
    private clienteService clienteService;

    @RequestMapping(value="/ordenShow", method= RequestMethod.GET)
    @Transactional(readOnly=true)
    public String list(Model model){
        model.addAttribute("ordenes", ordenService.getAll());
        return "ordenShow";
    }

    /*@RequestMapping(value="/orden/{idOrden}/{fkCliId}", method= RequestMethod.GET)
    @Transactional(readOnly=true)
    public String showOrden(@PathVariable Integer idOrden,@PathVariable Integer fkCliId, Model model){
        model.addAttribute("ordenes",ordenService.findByordNumero(idOrden));

        model.addAttribute("clientes",clienteService.getClientebyId(fkCliId));
        return "ordenSola";
    }*/

    @RequestMapping(value="/ordenAdd")
    public String newOrden(Model model){
        model.addAttribute("orden",new orden());
        return "ordenAdd";
    }

    @RequestMapping(value="orden", method = RequestMethod.POST)
    public String saveOrden(orden orden){
        ordenService.saveOrden(orden);
        return "redirect:/orden/"+ orden.getOrdNumero()+"/"+orden.getFkCliId();
    }

    @RequestMapping(value="/orden/{idOrden}", method= RequestMethod.GET)
    @Transactional(readOnly=true)
    public String showOrden(@PathVariable Integer idorden, Model model){
        model.addAttribute("ordenes",ordenService.findByordNumero(idorden));
        model.addAttribute("clientes",clienteService.getClientebyId(ordenService.findByordNumero(idorden)));
        return "ordenSola";
    }
}
