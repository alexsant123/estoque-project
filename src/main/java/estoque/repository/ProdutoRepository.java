package estoque.repository;

import estoque.model.Entrada;
import estoque.model.Produto;
import org.hibernate.sql.Update;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {


    @Query(value = "select p from Produto p where  p.codigo = ?1")
    public Produto  findbyCodigo(Integer codigo);

    @Query("SELECT p.quantidade FROM Produto p WHERE p.codigo = :codigo")
    public Integer Findquantidadebycodigo(Integer codigo);


    @Modifying
    @Transactional
    @Query("UPDATE Produto p SET p.quantidade = p.quantidade - :quantidade WHERE p.codigo = :codigo")
    public void updateQuantidade(Integer codigo, Integer quantidade);
}
