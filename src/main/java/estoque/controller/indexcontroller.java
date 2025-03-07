package estoque.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class indexcontroller {

  @GetMapping("/entrada")
  public static String entrada() {
  return "/entrada";
  }

  @GetMapping("/saida")
  public static String saida() {
    return "/saida";
  }
  @GetMapping("/dashboard")
  public static String dashboard() {
    return "/dashboard";

  }
  @GetMapping("/index")
  public static String index() {
    return "/index";
  }




}
