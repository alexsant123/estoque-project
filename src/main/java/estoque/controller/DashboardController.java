package estoque.controller;

import estoque.model.Produto;
import estoque.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

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
        Map<String, Long> contagemPorMes = dashboardService.contarSaidasPorMes();
        Map<String, Long> contagemEntradaPorMes = dashboardService.contarEntradasPorMes();

        List<Produto> produtos= dashboardService.gastos_Com_produtos();
        model.addAttribute("contagemPorMes", contagemPorMes);
        model.addAttribute("lucroTotal", lucroTotal);
        model.addAttribute("produtomaisvendido", produtomaisvendido);
        model.addAttribute("produtoscadastrados",contarProdutosRequistrados);
        model.addAttribute("unidades",unidades_produtos);
        model.addAttribute("ticketmedio",ticketmedio);
        model.addAttribute("contagemEntradaPorMes",contagemEntradaPorMes);
        model.addAttribute("produtos",produtos);
         return "/dashboard";
    }




}
