package pe.viabcp.www.ProyectoBCP02.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.viabcp.www.ProyectoBCP02.Repository.TipoTransaccionRepository;
import pe.viabcp.www.ProyectoBCP02.model.TipoTransaccion;
import pe.viabcp.www.ProyectoBCP02.services.TipoTransaccionService;

@Service
public class TipoTransaccionServiceImpl  implements TipoTransaccionService{

	@Autowired
	private TipoTransaccionRepository tipoTransaccionRepository; 
	
	@Override
	public TipoTransaccion registrar(TipoTransaccion tipoCuenta) {
		// TODO Auto-generated method stub
		return tipoTransaccionRepository.save(tipoCuenta) ;
	}

	@Override
	public TipoTransaccion actualizar(TipoTransaccion tipoCuenta) {
		// TODO Auto-generated method stub
		return tipoTransaccionRepository.save(tipoCuenta) ;
	}

	@Override
	public Integer eliminar(Long id) {
		tipoTransaccionRepository.deleteById(id);
		Optional<TipoTransaccion> emp = tipoTransaccionRepository.findById(id);
		if (emp.isPresent()) {
			return -1;
		}
		return 1;
	}

	@Override
	public Optional<TipoTransaccion> obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return tipoTransaccionRepository.findById(id);
	}

	@Override
	public List<TipoTransaccion> obtenerTipoTransaccion() {
		// TODO Auto-generated method stub
		return (List<TipoTransaccion>)tipoTransaccionRepository.findAll();
	}

}
