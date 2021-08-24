package biblioteca.uspg.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="prestamo")
public class Prestamo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id_lector;
	
	@Column(name ="id_libro",nullable=false, length=20)
	Integer id_libro;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name ="fecha_prestamo",nullable=false)
	Date fecha_prestamo;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name ="fecha_entrega",nullable=false)
	Date fecha_entrega;
	@Column(name ="devuelto",nullable=false, length=10)
	String devuelto;
	@Column(name ="estado",nullable=false, length=10)
	Boolean estado;
	
	
	public Integer getId_lector() {
		return id_lector;
	}
	public void setId_lector(Integer id_lector) {
		this.id_lector = id_lector;
	}
	public Integer getId_libro() {
		return id_libro;
	}
	public void setId_libro(Integer id_libro) {
		this.id_libro = id_libro;
	}
	
	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}
	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}
	public Date getFecha_entrega() {
		return fecha_entrega;
	}
	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	public String getDevuelto() {
		return devuelto;
	}
	public void setDevuelto(String devuelto) {
		this.devuelto = devuelto;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	
	
}
