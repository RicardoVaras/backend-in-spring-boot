package pe.viabcp.www.ProyectoBCP02.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.viabcp.www.ProyectoBCP02.Repository.TransaccionesRepository;
import pe.viabcp.www.ProyectoBCP02.model.Transacciones;
import pe.viabcp.www.ProyectoBCP02.services.TransaccionesService;

@Service
public class TransaccionesServiceImpl implements TransaccionesService {

	@Autowired
	private TransaccionesRepository transaccionesRepository; 
	
	@Override
	public Transacciones registrar(Transacciones transacciones) {
		// TODO Auto-generated method stub
		return transaccionesRepository.save(transacciones);
	}

	@Override
	public Transacciones actualizar(Transacciones transacciones) {
		// TODO Auto-generated method stub
		return transaccionesRepository.save(transacciones);
	}

	@Override
	public Integer eliminar(Long id) {
		transaccionesRepository.deleteById(id);
		Optional<Transacciones> emp = transaccionesRepository.findById(id);
		if (emp.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public Optional<Transacciones> obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return transaccionesRepository.findById(id);
	}

	@Override
	public List<Transacciones> obtenerTransacciones() {
		// TODO Auto-generated method stub
		return  (List<Transacciones>)transaccionesRepository.findAll();
	}
 
}
