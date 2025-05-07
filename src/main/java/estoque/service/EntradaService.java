package estoque.service;

import estoque.model.Entrada;
import estoque.model.Produto;
import estoque.repository.EntradaRepository;
import estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;

@Service
public class EntradaService {


    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private EntradaRepository entradaRepository;




        public void salvarEntrada(Model model, Produto produto, Entrada entrada){

            if (produto == null || entrada == null) {
                model.addAttribute("message", "Erro: Produto ou Entrada inválidos.");
                return;
            }

            if (produtoRepository.existsByCodigo(produto.getCodigo()) ||
                    produtoRepository.existsByProdutoNome(produto.getProdutoNome())) {

                model.addAttribute("message", "Código ou nome do produto já existente");
            } else {
                LocalDate data = LocalDate.now();
                produtoRepository.save(produto);

                entrada.setDate(data);
                entrada.setProduto(produto);
                 entradaRepository.save(entrada);

                model.addAttribute("message", "Entrada realizada com sucesso");
            }
        }

    public Iterable<Entrada> findAll() {
        return entradaRepository.findAll(); // Obtendo todas as entradas
    }

    public void addNovaEntrada(Model model, Entrada entrada) {
      System.out.println(entrada.toString());
  }
    public Iterable<Produto> findAlll() {
        return produtoRepository.findAll(); // Obtendo todas as entradas
    }
}
