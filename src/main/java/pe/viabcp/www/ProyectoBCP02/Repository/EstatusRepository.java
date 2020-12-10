package pe.viabcp.www.ProyectoBCP02.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.viabcp.www.ProyectoBCP02.model.Estatus;

@Repository
public interface EstatusRepository extends CrudRepository<Estatus, Long>{

}
