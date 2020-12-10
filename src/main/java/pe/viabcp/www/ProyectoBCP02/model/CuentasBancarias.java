package pe.viabcp.www.ProyectoBCP02.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cuentasBancarias")
@Getter
@Setter

public class CuentasBancarias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numeroCuenta", length = 100, nullable = false)
	private String numeroCuenta;
	
	@ManyToOne
	private TipoCuenta tipoCuenta;
	
	@ManyToOne
	private Estatus estatus;
	
	@ManyToOne
	private MonedaCuenta monedaCuenta;
	
	@Column(name = "balanceTotal", precision = 10, scale = 1)
	private double balanceTotal;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaApertura")
	private LocalDate fechaApertura;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "ultimaFechaUsada")
	private LocalDate ultimaFechaUsada;
	
	@ManyToOne
	private Cliente cliente;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cuentasBancarias")
	private List<Transacciones> transacciones = new ArrayList<Transacciones>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public Estatus getEstatus() {
		return estatus;
	}

	public void setEstatus(Estatus estatus) {
		this.estatus = estatus;
	}

	public MonedaCuenta getMonedaCuenta() {
		return monedaCuenta;
	}

	public void setMonedaCuenta(MonedaCuenta monedaCuenta) {
		this.monedaCuenta = monedaCuenta;
	}

	public double getBalanceTotal() {
		return balanceTotal;
	}

	public void setBalanceTotal(double balanceTotal) {
		this.balanceTotal = balanceTotal;
	}

	public LocalDate getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(LocalDate fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public LocalDate getUltimaFechaUsada() {
		return ultimaFechaUsada;
	}

	public void setUltimaFechaUsada(LocalDate ultimaFechaUsada) {
		this.ultimaFechaUsada = ultimaFechaUsada;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Transacciones> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transacciones> transacciones) {
		this.transacciones = transacciones;
	}

}
