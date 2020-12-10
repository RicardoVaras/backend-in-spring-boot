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

import pe.viabcp.www.ProyectoBCP02.model.MonedaCuenta;
import pe.viabcp.www.ProyectoBCP02.services.MonedaCuentaService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/monedacuentas")
public class MonedaCuentaRestController {

	@Autowired
	private MonedaCuentaService monedaCuentaService;
	
	@GetMapping
	public List<MonedaCuenta> listMonedaCuentas() {
		return monedaCuentaService.obtenermonedaCuenta();
	}

	@GetMapping("{id}")
	public MonedaCuenta obtenerMonedaCuenta(@PathVariable Long id) {
		return monedaCuentaService.obtenerPorId(id).get();
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody MonedaCuenta monedaCuenta) {

		MonedaCuenta monedaCuentaGuardado = monedaCuentaService.registrar(monedaCuenta);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(monedaCuentaGuardado.getCodigo()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Object> actualizar(@RequestBody MonedaCuenta monedaCuenta, @PathVariable Long id) {
		monedaCuenta.setCodigo(id);
		monedaCuentaService.actualizar(monedaCuenta);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("{id}")
	public void eliminar(@PathVariable Long id) {
		monedaCuentaService.eliminar(id);
	}
}
