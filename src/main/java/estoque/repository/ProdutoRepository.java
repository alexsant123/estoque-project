package estoque.repository;

import estoque.model.Produto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {


    @Query(value = "select p from Produto p where  p.codigo = ?1")
    public Produto findbyCodigo(int codigo);

    @Query(value = "select p from Produto p where  p.codigo = ?1")
    public Integer FindbyCodigo(int codigo);

    @Query("SELECT p.quantidade FROM Produto p WHERE p.codigo = :codigo")
    public Integer Findquantidadebycodigo(int codigo);


    @Modifying
    @Transactional
    @Query("UPDATE Produto p SET p.quantidade = p.quantidade - :quantidade WHERE p.codigo = :codigo")
    public void updateQuantidade(int codigo, int quantidade);

    @Query(value = "select p from Produto p where  p.produtoNome = ?1")
    public String findByName(String produtoNome);
}
