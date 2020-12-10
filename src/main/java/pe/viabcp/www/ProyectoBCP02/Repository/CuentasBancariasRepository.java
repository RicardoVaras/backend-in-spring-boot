package pe.viabcp.www.ProyectoBCP02.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.viabcp.www.ProyectoBCP02.model.CuentasBancarias;

@Repository
public interface CuentasBancariasRepository extends CrudRepository<CuentasBancarias, Long> {

}
