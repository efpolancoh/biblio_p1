package biblioteca.uspg.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonFormat;


public interface ICRUD <T>{
	// Agregamos los metodos
	
	T registrar(T t);
	T modificar (T t);
	void eliminar(int id);
	Optional<T> listarPorId(int id);
	List<T> listar();
	@JsonFormat(pattern="yyyy-MM-dd")
	Optional<T> listarPorFecha(String date);

}
