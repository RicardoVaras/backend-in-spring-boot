package pe.viabcp.www.ProyectoBCP02.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipoTransaccion")
@Getter
@Setter
public class TipoTransaccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "descripcion", length = 100, nullable = false)
	private String descripcion;

	@JsonIgnore
	@OneToMany(mappedBy = "tipoTransaccion")
	private List<Transacciones> transacciones = new ArrayList<Transacciones>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Transacciones> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transacciones> transacciones) {
		this.transacciones = transacciones;
	}

}
