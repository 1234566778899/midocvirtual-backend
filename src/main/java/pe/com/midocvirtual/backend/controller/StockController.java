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
    public List<Stock> addStock(@RequestBody List<Stock> stock){
        List<Stock> lista=repo.saveAll(stock);
        for (Stock stock1:lista){
            stock1.setProducto(null);
            stock1.setFarmacia(null);
        }
        return lista;
    }

    @GetMapping("/stock/{idStock}")
    public Stock getStock(@PathVariable Long idStock){
        Stock stock=repo.findById(idStock).get();
        stock.getProducto().getProveedor().setProductos(null);
        stock.getProducto().setStocks(null);
        stock.getProducto().setDetalleVentas(null);
        stock.getFarmacia().setStocks(null);
        stock.getFarmacia().setOrdenes(null);
       return stock;
    }
    @PutMapping("/stock/update")
    public Stock updateStock(@RequestBody Stock stock){
        Stock stock1=repo.save(stock);
        stock1.setFarmacia(null);
        stock1.setProducto(null);
        return stock1;
    }
}
