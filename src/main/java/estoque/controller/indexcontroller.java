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
  static DashboardService dashboardService;

@Autowired
  EntradaRepository entradaRepository;
  @GetMapping("/entrada")
  public  String entrada() {
    return "/entrada";
  }

  @GetMapping("/saida")
  public  String saida() {
    return "/saida";
  }

  @GetMapping("/index")
  public  String index() {
    return "/index";
  }
  @GetMapping("/entradanova")
  public String entradanova() {

    return "/entradanova"; // Nome do template Thymeleaf
  }



}



