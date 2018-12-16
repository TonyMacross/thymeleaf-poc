package net.grupocae.web.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import net.grupocae.web.model.Estudiante;
import net.grupocae.web.model.ListaEstudiantes;
import net.grupocae.web.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService {

	@Override
	public ListaEstudiantes getEstudiantes() {
		ListaEstudiantes listaEstudiantes = new ListaEstudiantes();
		List<Estudiante> estudiantes = new ArrayList<>();
		estudiantes.add(get1());
		estudiantes.add(get2());
		estudiantes.add(get3());
		listaEstudiantes.setEstudiantes(estudiantes);
		return listaEstudiantes;
	}

	private Estudiante get1() {
		Estudiante e1 = new Estudiante();
		e1.setNombre("Antonio");
		e1.setEdad(23);
		e1.setIdEmp(1);
		e1.setEstatus("Inscrito");
		return e1;
	}

	private Estudiante get2() {
		Estudiante e1 = new Estudiante();
		e1.setNombre("Miguel");
		e1.setEdad(24);
		e1.setIdEmp(2);
		e1.setEstatus("Inscrito");
		return e1;
	}

	private Estudiante get3() {
		Estudiante e1 = new Estudiante();
		e1.setNombre("Jose");
		e1.setEdad(21);
		e1.setIdEmp(3);
		e1.setEstatus("Pendiente");
		return e1;
	}

	@Override
	public ListaEstudiantes deleteEstudiante(List<Estudiante> lista, Integer id) {
		ListaEstudiantes listaEstudiantes = new ListaEstudiantes();
		listaEstudiantes.setEstudiantes(lista.stream().filter(e -> e.getIdEmp() != id).collect(Collectors.toList()));
		return listaEstudiantes;
	}

	@Override
	public ListaEstudiantes agregaEstudiante(List<Estudiante> lista, Estudiante nuevoEstudiante) {
		ListaEstudiantes listaEstudiantes = new ListaEstudiantes();
		List<Estudiante> estudiantes = lista;
		lista = lista.stream().sorted(Comparator.comparing(Estudiante::getIdEmp).reversed()).collect(Collectors.toList());
		nuevoEstudiante.setIdEmp(lista.get(0).getIdEmp()+1);
		estudiantes.add(nuevoEstudiante);
		estudiantes = estudiantes.stream().sorted(Comparator.comparing(Estudiante::getIdEmp)).collect(Collectors.toList());
		listaEstudiantes.setEstudiantes(estudiantes);
		return listaEstudiantes;
	}

}
