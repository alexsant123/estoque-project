package estoque.service;

import estoque.model.Produto;
import estoque.model.Saida;
import estoque.repository.ProdutoRepository;
import estoque.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.time.LocalDate;

@Service
public class SaidaService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private SaidaRepository saidaRepository;


    @Transactional
    public void processarSaida(Saida saida, Model model, int codigo) {


        Produto produto_repo = produtoRepository.findbyCodigo(codigo);

        if (produto_repo == null) {
            model.addAttribute("message", "Produto não existente");
        } else if (saida.getQuantidade() > produto_repo.getQuantidade()) {
            model.addAttribute("message", "quantidade não disponível no estoque");
        } else {
            // Atualizar a quantidade do produto
            produtoRepository.updateQuantidade(codigo, produto_repo.getQuantidade() - saida.getQuantidade());

            // Definir a data da saída e o produto relacionado
            LocalDate data = LocalDate.now();
            saida.setDate(data);
            saida.setProduto(produto_repo);

            // Salvar a saída no banco de dados
            saidaRepository.save(saida);

            model.addAttribute("message", "Saída feita com sucesso.");
        }


    }
}





