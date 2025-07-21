package estoque.controller;


import estoque.repository.EntradaRepository;
import estoque.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class indexcontroller {

  @Autowired
  static DashboardService dashboardService;

  @Autowired
  EntradaRepository entradaRepository;

  @GetMapping("/entrada")
  public String entrada() {
    return "/entrada";
  }

  @GetMapping("/saida")
  public String saida() {
    return "/saida";
  }

  @GetMapping({"/", "/index"})
  public String index(Model model) {
    model.addAttribute("conteudo", "index :: content");
    model.addAttribute("pageTitle", "Início - Stocki");
    return "index";
  }

  @GetMapping("/entradanova")
  public String entradanova() {

    return "/entradanova"; // Nome do template Thymeleaf
  }

  @GetMapping("/entradas")
  public String entradas() {

    return "/entradas"; // Nome do template Thymeleaf
  }

  @GetMapping("/saidas")
  public String saidas() {

    return "/saidas"; // Nome do template Thymeleaf
  }



}
