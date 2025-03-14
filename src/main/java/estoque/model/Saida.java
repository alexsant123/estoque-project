package estoque.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "saida")
@SequenceGenerator(name = "seq_saida", sequenceName = "seq_saida", allocationSize = 1, initialValue = 1)
public class Saida implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_saida")
    private Long id;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = true)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
    private Produto produto;

    @Column
    private double valor_venda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getValorVenda() {
        return valor_venda;
    }

    public void setValorVenda(double valorVenda) {
        this.valor_venda = valorVenda;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Saida saida = (Saida) o;
        return Objects.equals(produto, saida.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto);
    }
}



