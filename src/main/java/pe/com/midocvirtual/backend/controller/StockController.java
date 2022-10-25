package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Stock;
import pe.com.midocvirtual.backend.repositories.StockRepository;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class StockController {
    @Autowired
    private StockRepository repo;
    @GetMapping("/stock/lista/{idFarmacia}")
    public List<Stock> getStocks(@PathVariable Long idFarmacia){
        List<Stock> stocks=repo.findAllByFarmaciaId(idFarmacia);
        for (Stock stock:stocks){
            stock.setFarmacia(null);
            stock.getProducto().setStocks(null);
            stock.getProducto().setDetalleVentas(null);
            stock.getProducto().getProveedor().setProductos(null);
        }
        return stocks;
    }
    @PostMapping("/stock")
    public Stock addStock(@RequestBody Stock stock){
        return repo.save(stock);
    }

    @GetMapping("/stock/{idStock}")
    public Optional<Stock> getStock(@PathVariable Long idStock){
        Optional<Stock> stock=repo.findById(idStock);
        stock.get().getProducto().getProveedor().setProductos(null);
        stock.get().getProducto().setStocks(null);
        stock.get().getProducto().setDetalleVentas(null);
        stock.get().getFarmacia().setStocks(null);
        stock.get().getFarmacia().setOrdenes(null);
       return stock;
    }
    @PutMapping("/stock/update")
    public Stock updateStock(@RequestBody Stock stock){
        return repo.save(stock);
    }
}
