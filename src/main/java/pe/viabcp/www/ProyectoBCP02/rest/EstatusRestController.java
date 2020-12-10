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

import pe.viabcp.www.ProyectoBCP02.model.Estatus;
import pe.viabcp.www.ProyectoBCP02.services.EstatusService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/estatus")
public class EstatusRestController {
	@Autowired
	private EstatusService estatusService;
	
	@GetMapping
	public List<Estatus> listEstatus() {
		return estatusService.obtenerEstatus();
	}

	@GetMapping("{id}")
	public Estatus obtenerEstatus(@PathVariable Long id) {
		return estatusService.obtenerPorId(id).get();
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody Estatus estatus) {

		Estatus estatusGuardado = estatusService.registrar(estatus);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(estatusGuardado.getCodigo()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Object> actualizar(@RequestBody Estatus estatus, @PathVariable Long codigo) {
		estatus.setCodigo(codigo);
		estatusService.actualizar(estatus);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("{id}")
	public void eliminar(@PathVariable Long id) {
		estatusService.eliminar(id);
	}
}
