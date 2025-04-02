package estoque.controller;

import estoque.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    public
    String dashboard(Model model) {
        dashboardService.maisVendido_codigo();
        Integer lucroTotal = dashboardService.lucroTotal();
        String produtomaisvendido=dashboardService.maisVendido_codigo();
        Integer  contarProdutosRequistrados= Math.toIntExact(dashboardService.contarProdutosRequistrados());
        Integer unidades_produtos=dashboardService.contar_unidades_de_todos_os_produtos();
        double ticketmedio=dashboardService.ticketmedio();
        model.addAttribute("lucroTotal", lucroTotal);
        model.addAttribute("produtomaisvendido", produtomaisvendido);
        model.addAttribute("produtoscadastrados",contarProdutosRequistrados);
        model.addAttribute("unidades",unidades_produtos);
        model.addAttribute("ticketmedio",ticketmedio);

        return "/dashboard";
    }
}
