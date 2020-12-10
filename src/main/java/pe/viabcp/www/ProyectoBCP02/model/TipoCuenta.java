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
@Table(name = "tipoCuenta")
@Getter
@Setter

public class TipoCuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "descripcion", length = 100, nullable = false)
	private String descripcion;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoCuenta")
	private List<CuentasBancarias> cuentasBancarias = new ArrayList<CuentasBancarias>();

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<CuentasBancarias> getCuentasBancarias() {
		return cuentasBancarias;
	}

	public void setCuentasBancarias(List<CuentasBancarias> cuentasBancarias) {
		this.cuentasBancarias = cuentasBancarias;
	}
	
}
