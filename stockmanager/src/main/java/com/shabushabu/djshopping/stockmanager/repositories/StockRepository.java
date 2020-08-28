package com.shabushabu.djshopping.stockmanager.repositories;

import org.springframework.data.repository.CrudRepository;
import com.shabushabu.djshopping.stockmanager.model.Stock;

public interface StockRepository extends CrudRepository<Stock, String> {
}
