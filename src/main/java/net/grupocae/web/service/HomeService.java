package net.grupocae.web.service;

import java.util.List;

import net.grupocae.web.model.Estudiante;
import net.grupocae.web.model.ListaEstudiantes;

public interface HomeService {
	
	public ListaEstudiantes getEstudiantes();
	public ListaEstudiantes deleteEstudiante(List<Estudiante> lista, Integer id);
	public ListaEstudiantes agregaEstudiante(List<Estudiante> lista, Estudiante nuevoEstudiante); 

}
