package pe.com.midocvirtual.backend.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.midocvirtual.backend.entities.Stock;
import pe.com.midocvirtual.backend.exceptions.ResourceNotFoundException;
import pe.com.midocvirtual.backend.repositories.StockRepository;
import pe.com.midocvirtual.backend.services.StockServices;

import java.util.List;
import java.util.Optional;
@Service
public class StockServicesImp implements StockServices {

    @Autowired
    private StockRepository repo;

    public List<Stock> getStocks(Long idFarmacia) {
        List<Stock> stocks=repo.findAllByFarmaciaId(idFarmacia);
        for (Stock stock:stocks){
            stock.setFarmacia(null);
            stock.getProducto().setStocks(null);
            stock.getProducto().setDetalleVentas(null);
            stock.getProducto().getProveedor().setProductos(null);
        }
        return stocks;
    }
    public List<Stock> addStock(List<Stock> stock) {
        List<Stock> lista=repo.saveAll(stock);
        for (Stock stock1:lista){
            stock1.setProducto(null);
            stock1.setFarmacia(null);
        }
        return lista;
    }


    public Stock getStock(Long id) {
        Stock stock= repo.findById(id).get();
        stock.getProducto().getProveedor().setProductos(null);
        stock.getProducto().setStocks(null);
        stock.getProducto().setDetalleVentas(null);
        stock.getFarmacia().setStocks(null);
        stock.getFarmacia().setOrdenes(null);
        return stock;
    }

    public Stock editStock(Stock stock) {
        Stock stock1=repo.save(stock);
        stock1.setFarmacia(null);
        stock1.setProducto(null);
        return stock1;
    }
    public void deleteStock(Long id) {
        repo.deleteById(id);
    }
    public List<Stock> getStockDisponibleParaVenta(Long idFarmacia) {
        List<Stock> stocks=repo.getStockDisponibleParaVenta(idFarmacia);
        for (Stock stock:stocks){
            stock.setFarmacia(null);
            stock.getProducto().setStocks(null);
            stock.getProducto().setDetalleVentas(null);
            stock.getProducto().getProveedor().setProductos(null);
        }
        return stocks;
    }
}
