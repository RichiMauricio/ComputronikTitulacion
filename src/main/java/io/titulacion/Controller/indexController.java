package io.titulacion.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.unbescape.html.HtmlEscape;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by Mauricio on 07/01/2017.
 */
@Controller
public class indexController {

    @RequestMapping("/")
    public String index() {
        //model.addAttribute("name", name);
        return "index";
    }
}
