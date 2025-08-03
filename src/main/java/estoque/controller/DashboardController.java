package estoque.controller;

import estoque.model.Produto;
import estoque.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;




    @GetMapping({"/", "/index"})
    public String index(Model model) {

         Long  qtdProdutos=  dashboardService.contarProdutosRequistrados();
         Long  somaunidades=dashboardService.contar_unidades_de_todos_os_produtos();
        Map<String, Long>  saidasPorMes= dashboardService.contarSaidasPorMes();
        Map<String,Long>  entradasPorMes= dashboardService.contarEntradasPorMes();
        model.addAttribute("entradasPorMes", entradasPorMes);
        model.addAttribute("saidasPorMes", saidasPorMes);
        model.addAttribute("somaunidades", somaunidades);
         model.addAttribute("qtdProdutos",qtdProdutos);



        return "stocki.index";
    }



    }








