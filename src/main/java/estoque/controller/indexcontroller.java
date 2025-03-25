package estoque.controller;


import estoque.model.Entrada;
import estoque.repository.EntradaRepository;
import estoque.service.DashboardService;
import estoque.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class indexcontroller {

@Autowired
  EntradaRepository entradaRepository;
  @GetMapping("/entrada")
  public static String entrada() {
    return "/entrada";
  }

  @GetMapping("/saida")
  public static String saida() {
    return "/saida";
  }
  @GetMapping("/dashboard")
  public static String dashboard(Model model) {


    model.addAttribute("message",  "80");
    return "/dashboard";

  }
  @GetMapping("/index")
  public static String index() {
    return "/index";
  }
  //@GetMapping("/lista")
  public String mostrarEntradas(Model model) {


    return "/lista"; // Nome do template Thymeleaf
  }



}



