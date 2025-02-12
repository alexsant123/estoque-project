package estoque.repository;

import estoque.model.Entrada;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepository  extends CrudRepository<Entrada, Long> {


}
