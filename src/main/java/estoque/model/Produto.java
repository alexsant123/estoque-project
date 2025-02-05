package estoque.model;

import java.util.Date;

public class Produto {

    private long id;
    private String codigo;
    private Date data;
    private String produtoNome;
    private String valorCompra;
    private String valorVenda;
    private String lucroEstimado;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setData(Date data) {
        this.data = data;
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

    public Date getData() {
        return data;
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
