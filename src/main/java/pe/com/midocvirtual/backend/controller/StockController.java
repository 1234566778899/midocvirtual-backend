package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Stock;
import pe.com.midocvirtual.backend.exceptions.ResourceNotFoundException;
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
    public ResponseEntity<List<Stock>> getStocks(@PathVariable Long idFarmacia){
        List<Stock> stocks=repo.findAllByFarmaciaId(idFarmacia);
        if (stocks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        for (Stock stock:stocks){
            stock.setFarmacia(null);
            stock.getProducto().setStocks(null);
            stock.getProducto().setDetalleVentas(null);
            stock.getProducto().getProveedor().setProductos(null);
        }
        return new ResponseEntity<List<Stock>>(stocks,HttpStatus.OK);
    }
    @PostMapping("/stock")
    public ResponseEntity<List<Stock>> addStock(@RequestBody List<Stock> stock){
        List<Stock> lista=repo.saveAll(stock);
        for (Stock stock1:lista){
            stock1.setProducto(null);
            stock1.setFarmacia(null);
        }
        return new ResponseEntity<List<Stock>>(lista,HttpStatus.CREATED);
    }

    @GetMapping("/stock/{idStock}")
    public ResponseEntity<Optional<Stock>> getStock(@PathVariable Long idStock){
        Optional <Stock> stock= Optional.ofNullable(repo.findById(idStock).
                orElseThrow(() -> new ResourceNotFoundException("No se encontró stock con id: " + idStock)));;
        stock.get().getProducto().getProveedor().setProductos(null);
        stock.get().getProducto().setStocks(null);
        stock.get().getProducto().setDetalleVentas(null);
        stock.get().setFarmacia(null);
       return new ResponseEntity<Optional<Stock>>(stock,HttpStatus.OK);
    }
    @PutMapping("/stock/update")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock){
        Stock stock1=repo.save(stock);
        stock1.setFarmacia(null);
        stock1.setProducto(null);
        return new ResponseEntity<Stock>(stock1,HttpStatus.OK);
    }
    @DeleteMapping("/stock/{id}")
    public ResponseEntity<HttpStatus> deleteStock(@PathVariable Long id){
        repo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
