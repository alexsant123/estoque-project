package estoque.repository;

import estoque.model.Produto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {


    @Query(value = "select  p from Produto p where  p.codigo = ?1")
    public Produto findbyCodigo(int codigo);

    @Modifying
    @Query("UPDATE Produto p SET p.quantidade = :quantidade WHERE p.codigo = :codigo")
    void updateQuantidade(@Param("codigo") int codigo, @Param("quantidade") int quantidade);


    @Query(value = "select p from Produto p where  p.produtoNome = ?1")
    public Produto findByName(String produtoNome);


    public boolean existsByCodigo(int codigo);



    public boolean existsByProdutoNome(String produtoNome);
}