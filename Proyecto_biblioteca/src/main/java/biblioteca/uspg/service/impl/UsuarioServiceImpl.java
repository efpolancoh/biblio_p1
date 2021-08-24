package biblioteca.uspg.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biblioteca.uspg.dao.IUsuarioDAO;
import biblioteca.uspg.model.Usuario;
import biblioteca.uspg.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuarioDAO dao;
	
	@Override
	public Usuario registrar(Usuario t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Usuario modificar(Usuario t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Optional<Usuario> listarPorId(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Usuario> listarPorFecha(String date) {
		// TODO Auto-generated method stub
		return null;
	}

}
