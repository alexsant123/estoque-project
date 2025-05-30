package estoque.service;

import estoque.model.Produto;
import estoque.model.Saida;
import estoque.repository.ProdutoRepository;
import estoque.repository.SaidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

   @Service
   public class SaidaService {

     @Autowired
     private ProdutoRepository produtoRepository;
     @Autowired
     private SaidaRepository saidaRepository;


     @Transactional
     public void processarSaida(Saida saida, ModelAndView modelAndView, @RequestParam int codigo) {


        Produto produto = produtoRepository.findByCodigo(codigo);

        if (produto != null && produto.getQuantidade() > saida.getQuantidade()) {
            produto.setQuantidade(produto.getQuantidade() - saida.getQuantidade());
            saida.setProduto(produto);
            LocalDate date = LocalDate.now();
            saida.setDate(date);
            produtoRepository.save(produto);
            saidaRepository.save(saida);
        }else {

            modelAndView.addObject("message"," inexistente ou quantidade insuficiente.");

        }



    }
   }















