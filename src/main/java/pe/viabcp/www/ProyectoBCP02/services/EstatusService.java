package pe.viabcp.www.ProyectoBCP02.services;

import java.util.List;
import java.util.Optional;

import pe.viabcp.www.ProyectoBCP02.model.Estatus;

public interface EstatusService {

	Estatus registrar(Estatus estatus);

	Estatus actualizar(Estatus estatus);

	Integer eliminar(Long id);

	Optional<Estatus> obtenerPorId(Long id);
	
	List<Estatus> obtenerEstatus();
}
