package estoque.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private long id;
    private int codigo;
    private String produtoNome;
    private Double valorCompra;
    private Double valorCompraTotal;
    private Double valorVenda;
    private Double lucroEstimado;
    private int quantidade;

    public  Produto(int codigo, String produtoNome, double valorCompra, double valorVenda, double lucroEstimado, long  id) {
        this.id = id;
        this.codigo = codigo;
        this.produtoNome = produtoNome;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.lucroEstimado = lucroEstimado;
    }
    public Produto() {}
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public double getValorCompra() {
        return valorCompra != null ? valorCompra : 0.0;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getLucroEstimado() {
        return lucroEstimado;
    }

    public void setLucroEstimado(Double lucroEstimado) {
        this.lucroEstimado = lucroEstimado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorCompraTotal() {
        return valorCompraTotal;
    }

    public void setValorCompraTotal(double valorCompraTotal) {
        this.valorCompraTotal = valorCompraTotal;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "quantidade=" + quantidade +
                ", lucroEstimado=" + lucroEstimado +
                ", valorVenda=" + valorVenda +
                ", valorCompra=" + valorCompra +
                ", produtoNome='" + produtoNome + '\'' +
                ", codigo=" + codigo +
                '}';
    }
}