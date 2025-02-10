package estoque.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "saida")
@SequenceGenerator(name = "seq_saida", sequenceName = "seq_saida", allocationSize = 1, initialValue = 1)
public class Saida {
    @Id
    private Long id;


    @Transient
    private String codigoProduto;

    @Column(nullable = false)
    private String quantidade;

    @Column(nullable = false)
    private Date data;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
    private Produto produto;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}



