package biblioteca.uspg.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import biblioteca.uspg.exception.ModeloNotFoundException;
import biblioteca.uspg.model.Usuario;
import biblioteca.uspg.service.IUsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;
	
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Usuario>>usuario(){
		return new ResponseEntity<List<Usuario>>(service.listar(),HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Usuario> listarPorId(@PathVariable("id") Integer id){
		Optional<Usuario> usuario = service.listarPorId(id);
		
		if(!usuario.isPresent()) {
			
			throw new ModeloNotFoundException("ID NO ENCONTRADO:"+ id);
		}
		
		EntityModel<Usuario>resource = EntityModel.of(usuario.get());
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("usuario-resource"));
		//return service.listarPorId(id);
		return resource;
	
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes =MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object>registrar(@RequestBody @Valid Usuario u_suari_o){
		
	Usuario usuario = service.registrar(u_suari_o);
	
	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
			.buildAndExpand(usuario.getId_usuario()).toUri();
	
	return ResponseEntity.created(location).build();
			
	}
	
	@PutMapping(produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@RequestBody Usuario u_suari_o){
		Optional<Usuario> usuario=service.listarPorId(u_suari_o.getId_usuario());
		
		if(!usuario.isPresent()) {
			 throw new ModeloNotFoundException("ID NO ENCONTRADO: " + u_suari_o.getId_usuario());
		 }else {
			 service.modificar(u_suari_o);
		 }
		 return new ResponseEntity<Object>(HttpStatus.OK);
		  
	}
	
	@DeleteMapping(value = "/{id}") 
	 public void eliminar(@PathVariable("id") Integer id) {
		 Optional<Usuario> usuario = service.listarPorId(id);
		 if(!usuario.isPresent()) {
			 throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		 } else {
			 service.eliminar(id); 
		 }
		
	}
	
}
