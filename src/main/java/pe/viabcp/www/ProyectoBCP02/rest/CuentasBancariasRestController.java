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

import pe.viabcp.www.ProyectoBCP02.model.CuentasBancarias;
import pe.viabcp.www.ProyectoBCP02.services.CuentasBancariasService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/cuentasbancarias")
public class CuentasBancariasRestController {
	
	@Autowired
	private CuentasBancariasService cuentasBancariasService;
	
	@GetMapping
	public List<CuentasBancarias> listCuentasBancarias() {
		return cuentasBancariasService.obtenerCuentasBancarias();
	}

	@GetMapping("{id}")
	public CuentasBancarias obtenerCuentaBancaria(@PathVariable Long id) {
		return cuentasBancariasService.obtenerPorId(id).get();
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody CuentasBancarias cuentasBancarias) {

		CuentasBancarias cuentaBancariaGuardado = cuentasBancariasService.registrar(cuentasBancarias);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(cuentaBancariaGuardado.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Object> actualizar(@RequestBody CuentasBancarias cuentasBancarias, @PathVariable Long id) {
		cuentasBancarias.setId(id);
		cuentasBancariasService.actualizar(cuentasBancarias);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("{id}")
	public void eliminar(@PathVariable Long id) {
		cuentasBancariasService.Eliminar(id);
	}
	
}
