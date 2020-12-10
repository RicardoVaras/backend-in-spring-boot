package pe.viabcp.www.ProyectoBCP02.services;

import java.util.List;
import java.util.Optional;

import pe.viabcp.www.ProyectoBCP02.model.TipoCuenta;

public interface TipoCuentaService {
	
	
	TipoCuenta registrar (TipoCuenta tipoCuenta);
	
	TipoCuenta actualizar (TipoCuenta tipoCuenta);

	Integer eliminar(Long id);

	Optional<TipoCuenta> obtenerPorId(Long id);
	
	List<TipoCuenta> obtenerTipoCuenta();


	
	
}
