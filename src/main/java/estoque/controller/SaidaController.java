package estoque.controller;

import estoque.model.Produto;
import estoque.model.Saida;
import estoque.repository.SaidaRepository;
import estoque.service.DashboardService;
import estoque.service.SaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class SaidaController {


    @Autowired
    DashboardService dashboardService;
    @Autowired
    SaidaService saidaService;

    @Autowired
    SaidaRepository saidaRepository;

    @RequestMapping(method = RequestMethod.POST, value = "/saidaProdutos")
    public ModelAndView tirarDoEstoque(Saida saida, ModelAndView modelAndView, @RequestParam int codigo) {
       modelAndView.setViewName("saida");



            saidaService.processarSaida(saida, modelAndView,codigo);
        return  modelAndView;

    }
    @GetMapping("/listasaidas")
    @ResponseBody
    public List<Saida> getSaidas() {
        List<Saida> saidas = (List<Saida>) saidaRepository.findAll();  //
        return ResponseEntity.ok(saidas).getBody();  // Retorna a lista como resposta JSON

    }



}
