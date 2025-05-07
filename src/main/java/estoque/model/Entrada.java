package estoque.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "entrada")
@SequenceGenerator(name = "seq_entrada", sequenceName = "seq_entrada", allocationSize = 1, initialValue = 1)
public class Entrada implements Serializable {


    private static final long serialVersionUID = 1L;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_entrada")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
    private Produto produto;


    private int quantidade;
     private Double valorCompra;
     private Double  valorVendaSujerido;

    @Column(name = "date")
    private LocalDate date;


    public Entrada() {

    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getValorVendaSujerido() {
        return valorVendaSujerido;
    }

    public void setValorVendaSujerido(Double valorVendaSujerido) {
        this.valorVendaSujerido = valorVendaSujerido;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "id=" + id +
                 ", quantidade=" + quantidade +
                ", valorCompra=" + valorCompra +
                ", valorVendaSujerido=" + valorVendaSujerido +
                ", date=" + date +
                '}';
    }
}
