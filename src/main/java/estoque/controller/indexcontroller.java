package estoque.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexcontroller {

  @GetMapping("/entrada")
  public String entrada() {
  return "/entrada";
  }

  @GetMapping("/saida")
  public  String saida() {
    return "/saida";
  }

  @GetMapping("/dashboard")
  public String index() {
    return "/dashboard";
  }




}
