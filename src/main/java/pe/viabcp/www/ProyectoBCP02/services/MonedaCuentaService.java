package pe.viabcp.www.ProyectoBCP02.services;

import java.util.List;
import java.util.Optional;

import pe.viabcp.www.ProyectoBCP02.model.MonedaCuenta;

public interface MonedaCuentaService {

	MonedaCuenta registrar(MonedaCuenta estatus);

	MonedaCuenta actualizar(MonedaCuenta estatus);

	Integer eliminar(Long id);

	Optional<MonedaCuenta> obtenerPorId(Long id);
	
	List<MonedaCuenta> obtenermonedaCuenta();

}
