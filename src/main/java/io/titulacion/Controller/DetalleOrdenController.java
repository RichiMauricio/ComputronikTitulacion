package io.titulacion.Controller;

import io.titulacion.Model.cliente;
import io.titulacion.Model.detalleOrden;
import io.titulacion.Model.orden;
import io.titulacion.Model.servicio;
import io.titulacion.Service.ServicioService;
import io.titulacion.Service.clienteService;
import io.titulacion.Service.ordenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import io.titulacion.Service.DetalleOrdenService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Mauricio on 13/02/2017.
 */
@Controller
public class DetalleOrdenController {

    @Autowired
    private DetalleOrdenService detalleOrdenService;

    @Autowired
    private ServicioService servicioService;

    @Autowired
    private clienteService clienteService;

    @Autowired
    private ordenService ordenService;

    //Mostrar formulario de añadir detalle de orden
    @Transactional(readOnly = false)
    @RequestMapping(value="/detalleOrden/agregar/{ordNumero}", method = RequestMethod.GET)
    public String newCliente(Model model){
        model.addAttribute("detalleOrden", new detalleOrden());
        return "detalleOrdenAdd";
    }

    //Añadir nueva orden con el número de orden
    @Transactional(readOnly = false)
    @RequestMapping(value = "/detalleOrdenAdd", method = RequestMethod.POST)
    public String saveOrden(@Valid detalleOrden detalleOrden, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "detalleOrdenAdd";
        }else {
            detalleOrdenService.saveDetalleOrden(detalleOrden);
            return "redirect:/ordenShow";
        }
    }

    @RequestMapping(value = "/detalleOrdenShow", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public String detalleOrdenShow(Model model){
        model.addAttribute("detalleOrden", detalleOrdenService.getAll());
        return "detalleOrdenShow";
    }

    @ModelAttribute("allServicios")
    public List<servicio> populateTypes() {
        return servicioService.gelAll();
    }

    /*@ModelAttribute("cliNombre")
    public cliente nombreCliente(@RequestParam Integer ordnNumero) {
        orden ordenEncontrada = ordenService.findByordNumero(ordnNumero);
        cliente clienteEncontrado = clienteService.getClientebyId(ordenEncontrada);
        return clienteEncontrado;
    }*/

    //Borrar un detalle
    @Transactional(readOnly = false)
    @RequestMapping(value = "/detalleOrden/delete/{ordNumero}")
    public String editOrden(@PathVariable Integer ordNumero) {
        detalleOrdenService.deleteDetalleOrden(ordNumero);
        return "redirect:/detalleOrdenShow";
    }

}
