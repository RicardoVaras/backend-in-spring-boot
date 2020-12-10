package pe.viabcp.www.ProyectoBCP02.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.viabcp.www.ProyectoBCP02.Repository.TipoCuentaRepository;
import pe.viabcp.www.ProyectoBCP02.model.TipoCuenta;
import pe.viabcp.www.ProyectoBCP02.services.TipoCuentaService;

@Service
public class TipoCuentaServiceImpl implements TipoCuentaService {

	@Autowired
	private TipoCuentaRepository tipoCuentaRepository;
	
	@Override
	public TipoCuenta registrar(TipoCuenta tipoCuenta) {
		// TODO Auto-generated method stub
		return tipoCuentaRepository.save(tipoCuenta);
	}

	@Override
	public TipoCuenta actualizar(TipoCuenta tipoCuenta) {
		// TODO Auto-generated method stub
		return tipoCuentaRepository.save(tipoCuenta);
	}

	@Override
	public Integer eliminar(Long id) {
		tipoCuentaRepository.deleteById(id);
		Optional<TipoCuenta> emp = tipoCuentaRepository.findById(id);
		if (emp.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public Optional<TipoCuenta> obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return tipoCuentaRepository.findById(id);
	}

	@Override
	public List<TipoCuenta> obtenerTipoCuenta() {
		// TODO Auto-generated method stub
		return (List<TipoCuenta>)tipoCuentaRepository.findAll();
	}

}
