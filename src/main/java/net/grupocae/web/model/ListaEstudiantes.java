package net.grupocae.web.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ListaEstudiantes implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Estudiante> estudiantes;

}
