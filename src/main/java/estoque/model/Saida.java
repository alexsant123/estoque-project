package estoque.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "saida")
@SequenceGenerator(name = "seq_saida", sequenceName = "seq_saida", allocationSize = 1, initialValue = 1)
public class Saida {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_saida")
    private Long id;

    @Column(nullable = false)
    private String quantidade;

    @Column(nullable = true)
    private LocalDate date;

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



