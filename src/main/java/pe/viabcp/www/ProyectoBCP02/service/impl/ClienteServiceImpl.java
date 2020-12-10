package pe.viabcp.www.ProyectoBCP02.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.viabcp.www.ProyectoBCP02.Repository.ClienteRepository;
import pe.viabcp.www.ProyectoBCP02.model.Cliente;
import pe.viabcp.www.ProyectoBCP02.services.*;

@Service
public class ClienteServiceImpl  implements ClienteService{

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Cliente registrar(Cliente cliente) {
		return clienteRepository.save(cliente) ;
	}

	@Override
	public Cliente actualizar(Cliente cliente) {
		return clienteRepository.save(cliente) ;
	}

	@Override
	public Integer Eliminar(Long id) {
		clienteRepository.deleteById(id);
		
		Optional<Cliente> cli = clienteRepository.findById(id);
		
		if(cli.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public Cliente obtenerPorId(long id) {
		return clienteRepository.findById(id).get();
	}

	@Override
	public List<Cliente> obtenerClientes() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteRepository.findAll();
	}

}
