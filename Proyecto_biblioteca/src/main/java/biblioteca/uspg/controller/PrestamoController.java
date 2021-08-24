package biblioteca.uspg.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;

import biblioteca.uspg.exception.ModeloNotFoundException;
import biblioteca.uspg.model.Prestamo;
import biblioteca.uspg.service.IPrestamoService;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {

	@Autowired
	private IPrestamoService service;
	
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Prestamo>>prestamo(){
		return new ResponseEntity<List<Prestamo>>(service.listar(),HttpStatus.OK);
	}
	
/*	@GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Prestamo> listarPorId(@PathVariable("id") Integer id){
		Optional<Prestamo> prestamo = service.listarPorId(id);
		
		if(!prestamo.isPresent()) {
			
			throw new ModeloNotFoundException("ID NO ENCONTRADO:"+ id);
		}
		
		EntityModel<Prestamo>resource = EntityModel.of(prestamo.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("prestamo-resource"));
		//return service.listarPorId(id);
		return resource;
	}*/
	
	@GetMapping(value="/{date}",produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Prestamo> listarPorFecha (@PathVariable("date") String date){
		Optional<Prestamo> prestamo = service.listarPorFecha(date);
		
		if(!prestamo.isPresent()) {
			
			throw new ModeloNotFoundException("Fecha NO Válida:"+ date);
		}
		
		EntityModel<Prestamo>resource = EntityModel.of(prestamo.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorFecha(date));
		resource.add(linkTo.withRel("prestamo-resource"));
		//return service.listarPorId(id);
		return resource;
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>registrar(@RequestBody @Valid Prestamo p_restam_o){
		
	Prestamo prestamo = service.registrar(p_restam_o);
	
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(prestamo.getFecha_prestamo()).toUri();
	
	return ResponseEntity.created(location).build();
			
	}
	
}
