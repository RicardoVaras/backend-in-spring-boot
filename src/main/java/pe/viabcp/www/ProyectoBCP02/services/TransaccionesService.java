package pe.viabcp.www.ProyectoBCP02.services;

import java.util.List;
import java.util.Optional;

import pe.viabcp.www.ProyectoBCP02.model.Transacciones;

public interface TransaccionesService {

	
	Transacciones registrar (Transacciones transacciones);
	
	Transacciones actualizar (Transacciones transacciones);

	Integer eliminar(Long id);

	Optional<Transacciones> obtenerPorId(Long id);
	
	List<Transacciones> obtenerTransacciones();
}
