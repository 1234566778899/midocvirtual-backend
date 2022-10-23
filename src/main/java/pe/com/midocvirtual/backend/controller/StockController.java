package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Stock;
import pe.com.midocvirtual.backend.repositories.StockRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class StockController {
    @Autowired
    private StockRepository repo;
    @GetMapping("/stock/{idFarmacia}")
    public List<Stock> getStocks(@PathVariable Long idFarmacia){
        List<Stock> stocks=repo.findAllByFarmaciaId(idFarmacia);
        for (Stock stock:stocks){
            stock.setFarmacia(null);
            stock.getProducto().setStocks(null);
            stock.getProducto().getProveedor().setProductos(null);
        }
        return stocks;
    }
    @PostMapping("/stock")
    public Stock addStock(@RequestBody Stock stock){
        return repo.save(stock);
    }
}
