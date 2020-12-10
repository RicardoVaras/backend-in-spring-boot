package pe.viabcp.www.ProyectoBCP02.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.viabcp.www.ProyectoBCP02.Repository.MonedaCuentaRepository;
import pe.viabcp.www.ProyectoBCP02.model.MonedaCuenta;
import pe.viabcp.www.ProyectoBCP02.services.MonedaCuentaService;

@Service
public class MonedaCuentaServiceImpl implements MonedaCuentaService{

	@Autowired
	private MonedaCuentaRepository monedaCuentaRepository;
	
	@Override
	public MonedaCuenta registrar(MonedaCuenta estatus) {
		// TODO Auto-generated method stub
		return monedaCuentaRepository.save(estatus);
	}

	@Override
	public MonedaCuenta actualizar(MonedaCuenta estatus) {
		return monedaCuentaRepository.save(estatus);
	}

	@Override
	public Integer eliminar(Long id) {
		monedaCuentaRepository.deleteById(id);
		Optional<MonedaCuenta> emp = monedaCuentaRepository.findById(id);
		if (emp.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public Optional<MonedaCuenta> obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return monedaCuentaRepository.findById(id);
	}

	@Override
	public List<MonedaCuenta> obtenermonedaCuenta() {
		// TODO Auto-generated method stub
		return (List<MonedaCuenta>)monedaCuentaRepository.findAll();
	}

	
}
