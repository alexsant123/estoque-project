package estoque.service;

import estoque.model.Entrada;
import estoque.model.Produto;
import estoque.repository.EntradaRepository;
import estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@Service
public class EntradaService {


    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EntradaRepository entradaRepository;


    public void salvarEntrada(Model model, Produto produto) {


        if ((produtoRepository.existsByCodigo(produto.getCodigo())==true|| (produtoRepository.existsByProdutoNome(produto.getProdutoNome()) == true ))){

            model.addAttribute("message", "código ou nome do produto já existente");

        } else {
            LocalDate data = LocalDate.now();

            Entrada entrada = new Entrada();
            entrada.setDate(data);
            entrada.setProduto(produto);
            entrada.setQuantidade(produto.getQuantidade());
            produtoRepository.save(produto);  // Salva o produto no banco
            entradaRepository.save(entrada);  // Salva a entrada no banco

            model.addAttribute("message", "Entrada realizada com sucesso");
        }


    }



}