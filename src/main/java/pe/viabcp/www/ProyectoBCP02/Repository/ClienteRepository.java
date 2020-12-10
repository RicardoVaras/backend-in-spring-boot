package pe.viabcp.www.ProyectoBCP02.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.viabcp.www.ProyectoBCP02.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	List<Cliente>findAll();
    //para listar una persona
    Cliente findByid(int id);// nota!!!!! el metodo findOne genera error grave es por eso que no se usa en su lugar usamos findByid
    //para guardar cambios nuevos o actualizar
    Cliente save(Cliente c);
    //para eliminar
    void delete(Cliente c);
    
}
