package com.jkxy.car.api.service;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.Inventory;

public interface CarInventoryService {

    Inventory findByCarId(int carId);

    void buyCarByCarId(Inventory inventory);

    void insertInventory(Inventory inventory);
}
