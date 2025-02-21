package estoque.repository;

import estoque.model.Produto;
import estoque.model.Saida;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SaidaRepository extends CrudRepository<Saida, Long> {



}
