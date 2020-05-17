package com.jkxy.car.api.service.Impl;

import com.jkxy.car.api.dao.InventoryDao;
import com.jkxy.car.api.pojo.Inventory;
import com.jkxy.car.api.service.CarInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("carInventoryService")
public class CarInventoryServiceImpl implements CarInventoryService {
    @Autowired
    private InventoryDao inventoryDao;

    @Override
    public Inventory findByCarId(int carId) {
        return inventoryDao.findByCarId(carId);
    }

    @Override
    public void buyCarByCarId(Inventory inventory) {
        inventoryDao.buyCarByCarId(inventory);
    }

    @Override
    public void insertInventory(Inventory inventory) {
        inventoryDao.insertInventory(inventory);

    }
}
