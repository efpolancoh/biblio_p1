package biblioteca.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id_usuario;
	@Size(min=3 , max=30 , message =" nombre minimo tres caracteres ")
	@Column(name="userlog",nullable=false, length=30)
	String userlog;
	
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getUser() {
		return userlog;
	}
	public void setUser(String userlog) {
		this.userlog = userlog;
	}
	
	
}
