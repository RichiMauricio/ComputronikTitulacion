package io.titulacion.Controller;

import io.titulacion.Model.orden;
import io.titulacion.Model.estado;
import io.titulacion.Service.ordenService;
import io.titulacion.Service.clienteService;
import io.titulacion.Service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Mauricio on 31/01/2017.
 */
@Controller
public class ordenController {

    @Autowired
    private ordenService ordenService;

    @Autowired
    private clienteService clienteService;

    @Autowired
    private EstadoService estadoService;

    @RequestMapping(value = "/ordenShow", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public String list(Model model) {
        model.addAttribute("ordenes", ordenService.getAll());
        return "ordenShow";
    }

    @RequestMapping(value = "/orden/{ordNumero}", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public String showOrden(@PathVariable Integer ordNumero, Model model) {
        model.addAttribute("ordenes", ordenService.findByordNumero(ordNumero));
        model.addAttribute("clientes", clienteService.getClientebyId(ordenService.findByordNumero(ordNumero)));
        model.addAttribute("estado", estadoService.getEstadobyId(ordenService.findByordNumero(ordNumero)));
        return "ordenSola";
    }

    @RequestMapping(value = "/ordenAdd")
    public String newOrden(Model model) {
        return "clienteBuscar";
    }

    //Editar una orden
    @Transactional(readOnly = false)
    @RequestMapping(value = "/orden/edit/{ordNumero}")
    public String editOrden(@PathVariable Integer ordNumero, Model model) {
        model.addAttribute("orden", ordenService.findByordNumero(ordNumero));
        return "ordenAdd";
    }

    //Formulario de añadir orden
    @RequestMapping(value = "ordenAdd/ordenAddCli/{cliId}", method = RequestMethod.GET)
    public String newOrden(Model model, @PathVariable int cliId) {
        model.addAttribute("orden", new orden());
        return "ordenAdd";
    }

    //Añadir nueva orden con el id del cliente
    @Transactional(readOnly = false)
    @RequestMapping(value = "/ordenAdd", method = RequestMethod.POST)
    public String saveOrden(@Valid orden orden, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "ordenAdd";
        }else {
            ordenService.saveOrden(orden);
            return "redirect:/ordenShow";
        }
    }

    //Borrar una orden
    @Transactional(readOnly = false)
    @RequestMapping(value = "/orden/delete/{ordNumero}")
    public String editOrden(@PathVariable Integer ordNumero) {
        ordenService.deleteOrden(ordNumero);
        return "redirect:/ordenShow";
    }

    //Lista de estados para la orden
    @ModelAttribute("allEstados")
    public List<estado> populateTypes() {
        return estadoService.gelAll();
    }

}
