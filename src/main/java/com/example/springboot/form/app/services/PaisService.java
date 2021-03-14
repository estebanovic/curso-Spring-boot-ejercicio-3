package com.example.springboot.form.app.services;

import com.example.springboot.form.app.models.domain.Pais;
import java.util.List;


public interface PaisService {
    
    public List<Pais> listar();
    public Pais obtenerPorId(Integer id);
    
}
