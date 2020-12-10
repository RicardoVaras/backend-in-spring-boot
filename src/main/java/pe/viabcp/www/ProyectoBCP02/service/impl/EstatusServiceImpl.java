package pe.viabcp.www.ProyectoBCP02.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.viabcp.www.ProyectoBCP02.Repository.EstatusRepository;
import pe.viabcp.www.ProyectoBCP02.model.Estatus;
import pe.viabcp.www.ProyectoBCP02.services.EstatusService;

@Service
public class EstatusServiceImpl implements EstatusService {

	@Autowired
	private EstatusRepository estatusRepository;
	
	@Override
	public Estatus registrar(Estatus estatus) {
		return estatusRepository.save(estatus);
	}

	@Override
	public Estatus actualizar(Estatus estatus) {
		return estatusRepository.save(estatus);
	}

	@Override
	public Integer eliminar(Long id) {
		estatusRepository.deleteById(id);
		Optional<Estatus> emp = estatusRepository.findById(id);
		if (emp.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public Optional<Estatus> obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return estatusRepository.findById(id);
	}

	@Override
	public List<Estatus> obtenerEstatus() {
		// TODO Auto-generated method stub
		return (List<Estatus>)estatusRepository.findAll();
	}
	
	
}
