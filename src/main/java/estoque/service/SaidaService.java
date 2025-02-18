package estoque.service;

import estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaidaService {

   @Autowired
   private  ProdutoRepository produtoRepository ;



  public void processarSaida(String codigo, String quantidade, String valorVenda) {

     String   qtd= produtoRepository.Findquantidadebycodigo(codigo);
      int num_repository = Integer.parseInt(qtd);
     int qtd_saida_int = Integer.parseInt(quantidade);

     if (qtd_saida_int<num_repository) {



































         
     }


      System.out.println(qtd);







  }






}
