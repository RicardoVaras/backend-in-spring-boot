package pe.viabcp.www.ProyectoBCP02.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.viabcp.www.ProyectoBCP02.Repository.CuentasBancariasRepository;
import pe.viabcp.www.ProyectoBCP02.model.CuentasBancarias;
import pe.viabcp.www.ProyectoBCP02.services.*;

@Service
public class CuentasBancariasServiceImpl implements CuentasBancariasService {

	@Autowired
	private CuentasBancariasRepository cuentasBancariasRepository;
	
	@Override
	public List<CuentasBancarias> obtenerCuentasBancarias() {
		return (List<CuentasBancarias>) cuentasBancariasRepository.findAll();
	}

	@Override
	public CuentasBancarias registrar(CuentasBancarias cuentasBancarias) {
		return cuentasBancariasRepository.save(cuentasBancarias);
	}

	@Override
	public CuentasBancarias actualizar(CuentasBancarias cuentasBancarias) {
		return cuentasBancariasRepository.save(cuentasBancarias);
	}

	@Override
	public Integer Eliminar(Long id) {
		cuentasBancariasRepository.deleteById(id);
		Optional<CuentasBancarias> cuba = cuentasBancariasRepository.findById(id);
		if (cuba.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public Optional<CuentasBancarias> obtenerPorId(long id) {
		return cuentasBancariasRepository.findById(id);
	}

}
