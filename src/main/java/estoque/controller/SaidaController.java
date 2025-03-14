package estoque.controller;

import estoque.model.Produto;
import estoque.model.Saida;
import estoque.repository.SaidaRepository;
import estoque.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class SaidaController {

    @Autowired
    SaidaService saidaService;

    @Autowired
    SaidaRepository saidaRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/saidaProdutos")
    public String tirarDoEstoque(Saida saida, Model model, int codigo) {

        if ( saida.getQuantidade() <= 0) {

            return model.addAttribute("message", "Quantidade inválida.").toString();
        }else {
            saidaService.processarSaida(saida, model,codigo);
        }




        return  "saida";

    }
    @GetMapping("/saidas")
    @ResponseBody
    public List<Saida> getSaidas() {
        List<Saida> saidas = (List<Saida>) saidaRepository.findAll();  //

        return ResponseEntity.ok(saidas).getBody();  // Retorna a lista como resposta JSON

    }

}
