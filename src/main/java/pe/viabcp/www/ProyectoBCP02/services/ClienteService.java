package pe.viabcp.www.ProyectoBCP02.services;

import java.util.List;

import pe.viabcp.www.ProyectoBCP02.model.Cliente;

public interface ClienteService {

	Cliente registrar (Cliente cliente);
	
	Cliente actualizar(Cliente cliente);
	
	Integer Eliminar(Long id);
	
	Cliente obtenerPorId(long id); 
	
	List<Cliente> obtenerClientes();
}
