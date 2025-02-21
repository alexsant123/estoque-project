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


    public void processarSaida(Integer codigo, Integer quantidade, double valor_venda, Model model) {


        Integer qtd_repo = produtoRepository.Findquantidadebycodigo(codigo);

        if (quantidade > qtd_repo && quantidade==null) {

            model.addAttribute(model.addAttribute("message", "numero não disponível no estoque"));
        } else if (quantidade < qtd_repo) {

            produtoRepository.updateQuantidade(codigo, quantidade);
            LocalDate data = LocalDate.now();
            Saida saida = new Saida();
            saida.setDate(data);
            saida.setQuantidade(quantidade);
            saida.setValorVenda(valor_venda);
            saida.setProduto(produtoRepository.findbyCodigo(codigo));
            saidaRepository.save(saida);

            model.addAttribute(model.addAttribute("message", "saida feita com sucesso"));


        }


    }
}