package estoque.service;

import estoque.model.Saida;
import estoque.repository.ProdutoRepository;
import estoque.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;

@Service
public class SaidaService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private SaidaRepository saidaRepository;


    public void processarSaida(int codigo, int quantidade, double valor_venda, Model model) {


        if ( quantidade <= 0) {
            model.addAttribute("message", "Quantidade inválida.");
            return;
        }

        Integer qtd_repo = produtoRepository.Findquantidadebycodigo(codigo);

        if (quantidade > qtd_repo) {
            model.addAttribute("message", "Número não disponível no estoque.");
        } else {

            // Update the stock quantity after the sale
            produtoRepository.updateQuantidade(codigo, qtd_repo - quantidade);

            // Create a new Saida record
            LocalDate data = LocalDate.now();
            Saida saida = new Saida();
            saida.setDate(data);
            saida.setQuantidade(quantidade);
            saida.setValorVenda(valor_venda);
            saida.setProduto(produtoRepository.findbyCodigo(codigo));

            saidaRepository.save(saida);

            model.addAttribute("message", "Saída feita com sucesso.");
        }

    }
}