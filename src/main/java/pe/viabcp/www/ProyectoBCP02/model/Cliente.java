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
@Table(name = "clientes")
@Getter
@Setter
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre;

	@Column(name = "apellido", length = 100, nullable = false)
	private String apellido;

	@Column(name = "telefono", length = 100, nullable = false)
	private String telefono;
	
	@Column(name = "correo", length = 100, nullable = false)
	private String correo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<CuentasBancarias> cuentasBancarias = new ArrayList<CuentasBancarias>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public List<CuentasBancarias> getCuentasBancarias() {
		return cuentasBancarias;
	}

	public void setCuentasBancarias(List<CuentasBancarias> cuentasBancarias) {
		this.cuentasBancarias = cuentasBancarias;
	}

}
