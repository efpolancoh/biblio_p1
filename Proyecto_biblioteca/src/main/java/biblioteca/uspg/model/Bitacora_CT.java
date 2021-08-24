package biblioteca.uspg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="bitacora")
public class Bitacora_CT {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id_registro_bitacora;
	@Size(min=4 , max=30 , message =" nombre minimo cuatro caracteres ")
	@Column(name="campo",nullable=false, length=30)
	String campo;
	@Size(min=4 , max=30 , message =" nombre minimo cuatro caracteres ")
	@Column(name="valor_anterior",nullable=false, length=30)
	String valor_anterior;
	@Size(min=4 , max=30 , message =" nombre minimo cuatro caracteres ")
	@Column(name="valor_nuevo",nullable=false, length=30)
	String valor_nuevo;
	public Integer getId_registro_bitacora() {
		return id_registro_bitacora;
	}
	public void setId_registro_bitacora(Integer id_registro_bitacora) {
		this.id_registro_bitacora = id_registro_bitacora;
	}
	public String getCampo() {
		return campo;
	}
	public void setCampo(String campo) {
		this.campo = campo;
	}
	public String getValor_anterior() {
		return valor_anterior;
	}
	public void setValor_anterior(String valor_anterior) {
		this.valor_anterior = valor_anterior;
	}
	public String getValor_nuevo() {
		return valor_nuevo;
	}
	public void setValor_nuevo(String valor_nuevo) {
		this.valor_nuevo = valor_nuevo;
	}
	
	
}
