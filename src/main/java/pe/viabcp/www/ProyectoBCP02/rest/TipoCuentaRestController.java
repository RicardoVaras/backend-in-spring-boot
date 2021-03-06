package pe.viabcp.www.ProyectoBCP02.rest;

import java.net.URI;
import java.util.List;

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

import pe.viabcp.www.ProyectoBCP02.model.TipoCuenta;
import pe.viabcp.www.ProyectoBCP02.services.TipoCuentaService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/tipocuentas")
public class TipoCuentaRestController {

	@Autowired
	private TipoCuentaService tipoCuentaService;
	
	@GetMapping
	public List<TipoCuenta> listTipoCuentas() {
		return tipoCuentaService.obtenerTipoCuenta();
	}

	@GetMapping("{id}")
	public TipoCuenta obtenerTipoCuenta(@PathVariable Long id) {
		return tipoCuentaService.obtenerPorId(id).get();
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody TipoCuenta tipocuenta) {

		TipoCuenta tipoCuentaGuardado = tipoCuentaService.registrar(tipocuenta);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(tipoCuentaGuardado.getCodigo()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Object> actualizar(@RequestBody TipoCuenta tipocuenta, @PathVariable Long id) {
		tipocuenta.setCodigo(id);
		tipoCuentaService.actualizar(tipocuenta);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("{id}")
	public void eliminar(@PathVariable Long id) {
		tipoCuentaService.eliminar(id);
	}
}
