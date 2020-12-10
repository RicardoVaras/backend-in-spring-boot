package pe.viabcp.www.ProyectoBCP02.services;

import java.util.List;
import java.util.Optional;

import pe.viabcp.www.ProyectoBCP02.model.CuentasBancarias;

public interface CuentasBancariasService {

	CuentasBancarias registrar (CuentasBancarias cuentasBancarias);
	
	CuentasBancarias actualizar(CuentasBancarias cuentasBancarias);
	
	Integer Eliminar(Long id);
	
	Optional<CuentasBancarias> obtenerPorId(long id); 
	
	List<CuentasBancarias> obtenerCuentasBancarias();
}
