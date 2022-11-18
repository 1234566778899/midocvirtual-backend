package pe.com.midocvirtual.backend.services;

import pe.com.midocvirtual.backend.entities.Stock;

import java.util.List;

public interface StockServices {
    public List<Stock> getStocks(Long idFarmacia);
    public List<Stock> addStock(List<Stock> stock);
    public Stock getStock(Long id);
    public Stock editStock(Stock stock);
    public void deleteStock(Long id);
    List<Stock> getStockDisponibleParaVenta(Long idFarmacia);
}
