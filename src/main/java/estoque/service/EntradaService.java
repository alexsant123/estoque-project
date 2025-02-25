package estoque.service;

import estoque.model.Entrada;
import estoque.model.Produto;
import estoque.repository.EntradaRepository;
import estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Service
public class EntradaService {



 @Autowired
 private ProdutoRepository produtoRepository;
@Autowired
 private EntradaRepository entradaRepository;


    public void salvarEntrada(Model model,Produto produto){


        int codigo_repo=produtoRepository.Findquantidadebycodigo(produto.getCodigo());
       String name_repo=produtoRepository.findByName(produto.getProdutoNome());



        if ((produto.getQuantidade()==codigo_repo) || name_repo==produto.getProdutoNome()){


            model.addAttribute("message", "código ou nome de produto já cadastrado");


        }else {

            LocalDate data = LocalDate.now();

            Entrada entrada = new Entrada();
            entrada.setDate(data);
            entrada.setProduto(produto);
            produtoRepository.save(produto);

            entradaRepository.save(entrada);
            model.addAttribute("message", "entrada realizada com sucesso");
        }


    }




    }

