package biblioteca.uspg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import biblioteca.uspg.model.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario,Integer> {

}
