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

import pe.viabcp.www.ProyectoBCP02.model.Cliente;
import pe.viabcp.www.ProyectoBCP02.services.ClienteService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> listEmpleados(){
		return clienteService.obtenerClientes();
	}
	@GetMapping ("{id}")
	public Cliente obtenerCliente(@PathVariable Long id ) {
		return clienteService.obtenerPorId(id);
	}
	@PostMapping 
	public ResponseEntity<Object> registrarCliente(@RequestBody Cliente cli) {
		Cliente cliente = clienteService.registrar(cli);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@PutMapping("{id}")
	public ResponseEntity<Object> actualizarCliente(@RequestBody Cliente cli,@PathVariable Long id) {
		cli.setId(id);
		clienteService.actualizar(cli);
		return ResponseEntity.noContent().build();
	}
	@DeleteMapping("{id}")
	public void eliminarClientes(@PathVariable Long id) {
		clienteService.Eliminar(id);
	}
	
}
