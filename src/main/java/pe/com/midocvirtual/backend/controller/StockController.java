package pe.com.midocvirtual.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.midocvirtual.backend.entities.Stock;
import pe.com.midocvirtual.backend.exceptions.ResourceNotFoundException;
import pe.com.midocvirtual.backend.repositories.StockRepository;
import pe.com.midocvirtual.backend.services.StockServices;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(path = "/api")
public class StockController {
    @Autowired
    private StockServices repo;
    @GetMapping("/stock/lista/{idFarmacia}")
    public ResponseEntity<List<Stock>> getStocks(@PathVariable Long idFarmacia){
        List<Stock> stocks=repo.getStocks(idFarmacia);
        if (stocks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Stock>>(stocks,HttpStatus.OK);
    }
    @PostMapping("/stock")
    public ResponseEntity<List<Stock>> addStock(@RequestBody List<Stock> stock){
        List<Stock> lista=repo.addStock(stock);
        return new ResponseEntity<List<Stock>>(lista,HttpStatus.CREATED);
    }
    @GetMapping("/stock/{idStock}")
    public ResponseEntity<Stock> getStock(@PathVariable Long idStock){
        Stock stock= repo.getStock(idStock);
       return new ResponseEntity<Stock>(stock,HttpStatus.OK);
    }
    @PutMapping("/stock/update")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock){
        Stock stock1=repo.editStock(stock);
        return new ResponseEntity<Stock>(stock1,HttpStatus.OK);
    }
    @DeleteMapping("/stock/{id}")
    public ResponseEntity<HttpStatus> deleteStock(@PathVariable Long id){
        repo.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
