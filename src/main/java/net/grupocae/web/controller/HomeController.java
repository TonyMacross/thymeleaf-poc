package net.grupocae.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import net.grupocae.web.model.Estudiante;
import net.grupocae.web.model.ListaEstudiantes;
import net.grupocae.web.service.HomeService;

@Controller
@SessionAttributes(value = {"listaEstudiantes"})
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/")
	public ModelAndView defaultPath(ModelAndView mv) {
		ListaEstudiantes lista = homeService.getEstudiantes();
		mv.setViewName("home");
		mv.addObject("listaEstudiantes", lista.getEstudiantes());
		return mv;
	}
	
	@GetMapping("/home")
	public ModelAndView home(ModelAndView mv) {
		ListaEstudiantes lista = homeService.getEstudiantes();
		mv.setViewName("home");
		mv.addObject("listaEstudiantes", lista.getEstudiantes());
		return mv;
	}
	
	@GetMapping("/delete")
	@ModelAttribute("listaEstudiantes")
	public ModelAndView delete(ModelAndView mv, 
			@SessionAttribute List<Estudiante> listaEstudiantes,
			@RequestParam Integer id) {
		System.out.println("Borrado de Estudiante" + id);
		List<Estudiante> estudiantes = listaEstudiantes;
		ListaEstudiantes lista = homeService.deleteEstudiante(estudiantes, id);
		mv.setViewName("home");
		mv.addObject("listaEstudiantes", lista.getEstudiantes());
		return mv;
	}
	
	@GetMapping("/new")
	@ModelAttribute("listaEstudiantes")
	public ModelAndView newEstudante(ModelAndView mv, 
			@SessionAttribute List<Estudiante> listaEstudiantes) {
		System.out.println("Pantalla de Creacion de Estudiante");
		Estudiante estudiante = new Estudiante();
		estudiante.setIdEmp(listaEstudiantes.size()+1);
		System.out.println(estudiante);
		mv.setViewName("new");
		mv.addObject("listaEstudiantes", listaEstudiantes);
		mv.addObject("estudiante", estudiante);
		return mv;
	}
	
	@PostMapping("/create")
	@ModelAttribute("listaEstudiantes")
	public ModelAndView create(ModelAndView mv, 
			@SessionAttribute List<Estudiante> listaEstudiantes,
			@ModelAttribute Estudiante estudiante
			) {
		System.out.println("Estudiante guardado");
		ListaEstudiantes lista = homeService.agregaEstudiante(listaEstudiantes, estudiante);
		mv.setViewName("home");
		mv.addObject("listaEstudiantes", lista.getEstudiantes());
		return mv;
	}


}
