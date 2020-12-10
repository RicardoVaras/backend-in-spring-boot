package pe.viabcp.www.ProyectoBCP02.services;

import java.util.List;
import java.util.Optional;

import pe.viabcp.www.ProyectoBCP02.model.TipoTransaccion;


public interface TipoTransaccionService {

	TipoTransaccion registrar (TipoTransaccion tipoCuenta);
	
	TipoTransaccion actualizar (TipoTransaccion tipoCuenta);

	Integer eliminar(Long id);

	Optional<TipoTransaccion> obtenerPorId(Long id);
	
	List<TipoTransaccion> obtenerTipoTransaccion();
}
