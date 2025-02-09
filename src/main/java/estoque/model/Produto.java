package estoque.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private long id;

    private String codigo;
    private String produtoNome;
    private String valorCompra;
    private String valorVenda;
    private String lucroEstimado;
    private String quantidade;


    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }



    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public void setValorCompra(String valorCompra) {
        this.valorCompra = valorCompra;
    }

    public void setValorVenda(String valorVenda) {
        this.valorVenda = valorVenda;
    }

    public void setLucroEstimado(String lucroEstimado) {
        this.lucroEstimado = lucroEstimado;
    }

    public long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }



    public String getProdutoNome() {
        return produtoNome;
    }

    public String getValorCompra() {
        return valorCompra;
    }

    public String getValorVenda() {
        return valorVenda;
    }

    public String getLucroEstimado() {
        return lucroEstimado;
    }
}
