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

import pe.viabcp.www.ProyectoBCP02.model.TipoTransaccion;
import pe.viabcp.www.ProyectoBCP02.services.TipoTransaccionService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/tipotransacciones")
public class TipoTransaccionRestController {

	@Autowired
	private TipoTransaccionService tipoTransaccionService;
	
	@GetMapping
	public List<TipoTransaccion> listTipoTransaccions() {
		return tipoTransaccionService.obtenerTipoTransaccion();
	}

	@GetMapping("{id}")
	public TipoTransaccion obtenerTipoTransaccion(@PathVariable Long id) {
		return tipoTransaccionService.obtenerPorId(id).get();
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@RequestBody TipoTransaccion tipotransacciones) {

		TipoTransaccion tipoTransaccionGuardado = tipoTransaccionService.registrar(tipotransacciones);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(tipoTransaccionGuardado.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping("{id}")
	public ResponseEntity<Object> actualizar(@RequestBody TipoTransaccion tipotransacciones, @PathVariable Long id) {
		tipotransacciones.setId(id);
		tipoTransaccionService.actualizar(tipotransacciones);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("{id}")
	public void eliminar(@PathVariable Long id) {
		tipoTransaccionService.eliminar(id);
	}
}
