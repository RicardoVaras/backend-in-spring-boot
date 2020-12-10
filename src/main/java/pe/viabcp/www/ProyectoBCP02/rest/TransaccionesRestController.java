package pe.viabcp.www.ProyectoBCP02.rest;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.viabcp.www.ProyectoBCP02.model.CuentasBancarias;
import pe.viabcp.www.ProyectoBCP02.model.Transacciones;
import pe.viabcp.www.ProyectoBCP02.services.CuentasBancariasService;
import pe.viabcp.www.ProyectoBCP02.services.TransaccionesService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/transacciones")
public class TransaccionesRestController {

	@Autowired
	private TransaccionesService transaccionesService;
	
	@Autowired
	private CuentasBancariasService cuentasBancariasService;
	
	@GetMapping
	public List<Transacciones> listCuentasBancarias() {
		return transaccionesService.obtenerTransacciones();
	}

	@GetMapping("{id}")
	public Transacciones obtenerCuentaBancaria(@PathVariable Long id) {
		return transaccionesService.obtenerPorId(id).get();
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Transacciones transacciones, @PathVariable Long id1, @PathVariable Long id2) {

		Transacciones transaccionGuardado = transaccionesService.registrar(transacciones);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(transaccionGuardado.getId()).toUri();
		
		CuentasBancarias cuenta01 = cuentasBancariasService.obtenerPorId(id1).get();
		CuentasBancarias cuenta02 = cuentasBancariasService.obtenerPorId(id2).get();
		double c1 = cuenta01.getBalanceTotal();
		double c2 = cuenta02.getBalanceTotal();
		double c3 = transacciones.getMontodeTransaccion().doubleValue();
		
		cuenta01.setBalanceTotal(c1-c3);
		cuenta02.setBalanceTotal(c2+c3);
		
		return ResponseEntity.created(location).build();
	}

}
