package pe.viabcp.www.ProyectoBCP02.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transacciones")
@Getter
@Setter
public class Transacciones {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "montodeTransaccion", precision = 10, scale = 2)
	private BigDecimal montodeTransaccion;

	@ManyToOne
	private TipoTransaccion tipoTransaccion;
	
	@ManyToOne
	private CuentasBancarias cuentasBancarias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getMontodeTransaccion() {
		return montodeTransaccion;
	}

	public void setMontodeTransaccion(BigDecimal montodeTransaccion) {
		this.montodeTransaccion = montodeTransaccion;
	}

	public TipoTransaccion getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public CuentasBancarias getCuentasBancarias() {
		return cuentasBancarias;
	}

	public void setCuentasBancarias(CuentasBancarias cuentasBancarias) {
		this.cuentasBancarias = cuentasBancarias;
	}
}
