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

        }





    }






