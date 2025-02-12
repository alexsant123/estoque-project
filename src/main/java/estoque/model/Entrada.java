package estoque.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "entrada")
@SequenceGenerator(name = "seq_entrada", sequenceName = "seq_entrada", allocationSize = 1, initialValue = 1)
public class Entrada implements Serializable {


    private static final long serialVersionUID = 1L;



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_entrada")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = true, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
    private Produto produto;

    @Column(nullable = true)
    private LocalDate date;

    public Entrada() {

    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
