package estoque.service;

import estoque.model.Produto;
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


    public void processarSaida( Saida saida , Model model,int  codigo) {


        if ( saida.getQuantidade() <= 0) {
            model.addAttribute("message", "Quantidade inválida.");
            return;
        }

        Produto produto_repo=produtoRepository.findbyCodigo(codigo);


        if (saida.getQuantidade() > produto_repo.getQuantidade()) {
            model.addAttribute("message", "Número não disponível no estoque.");
        } else {

            produtoRepository.updateQuantidade(codigo, produto_repo.getQuantidade() - saida.getQuantidade());

            LocalDate data = LocalDate.now();

            saida.setDate(data);
            saida.setProduto(produto_repo);

            saidaRepository.save(saida);

            model.addAttribute("message", "Saída feita com sucesso.");
        }

    }
}