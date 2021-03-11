package com.example.springboot.form.app.validations;

import com.example.springboot.form.app.models.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidador implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Usuario.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //Usuario usuario = (Usuario) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "requerido.usuario.nombre");
//        if(!usuario.getIdentificador().matches("[\\d]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")){
//            errors.rejectValue("identificador", "pattern.usuario.identificador");
//        }
    }

}
