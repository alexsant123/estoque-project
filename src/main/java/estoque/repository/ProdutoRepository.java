package estoque.repository;

import estoque.model.Entrada;
import estoque.model.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {


    @Query(value = "select p from Produto p where  p.codigo = ?1")
    public Produto  findbyCodigo(String codigo);

    @Query
    public Produto save(Produto produto);

}
