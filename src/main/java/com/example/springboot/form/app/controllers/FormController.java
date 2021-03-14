package com.example.springboot.form.app.controllers;

import com.example.springboot.form.app.editors.NombreMayusculaEditors;
import com.example.springboot.form.app.editors.PaisPropertyEditor;
import com.example.springboot.form.app.models.domain.Pais;
import com.example.springboot.form.app.models.domain.Usuario;
import com.example.springboot.form.app.services.PaisService;
import com.example.springboot.form.app.validations.UsuarioValidador;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioValidador validador;
    
    @Autowired
    private PaisService paisService;
    
    @Autowired
    private PaisPropertyEditor paisPropertyEditor; 

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(validador);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditors());
        binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditors());
        
        binder.registerCustomEditor(Pais.class, "pais", paisPropertyEditor);
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises() {
        return paisService.listar();
    }

//    @ModelAttribute("paises")
//    public List<String> paises() {
//        return Arrays.asList("España", "México", "Chile", "Argentina", "Perú", "Colombia", "Venezuela");
//    }
//
//    @ModelAttribute("paisesMap")
//    public Map<String, String> paisesMap() {
//        Map<String, String> paises = new HashMap<String, String>();
//        paises.put("ES", "España");
//        paises.put("MX", "Méximo");
//        paises.put("CL", "Chile");
//        paises.put("AR", "Argentina");
//        paises.put("PE", "Perú");
//        paises.put("CO", "Colombia");
//        paises.put("VE", "Venzuela");
//        return paises;
//    }

    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("John");
        usuario.setApellido("difool");
        usuario.setIdentificador("123.456.789-K");
        usuario.setUsername("jdef");
        usuario.setEmail("jdef@mail.com");
        model.addAttribute("titulo", "Crear usuario");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {

        //validador.validate(usuario, result);
        model.addAttribute("titulo", "Resultado form");

        if (result.hasErrors()) {
            return "form";
        }
        model.addAttribute("usuario", usuario);
        status.setComplete();
        return "resultado";
    }
}
