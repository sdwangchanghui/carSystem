package com.jkxy.car.api.dao;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.Inventory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface InventoryDao {

    @Select("select * from carInventory where inventoryId = #{inventoryId}")
    Inventory findById(int id);

    @Select("select * from carInventory where carId = #{carId}")
    Inventory findByCarId(int id);

    @Update("update carInventory set quantity = #{quantity} where carId = #{carId}")
    void buyCarByCarId(Inventory inventory);

    @Insert("insert into carInventory(carId,quantity) values(#{carId},#{quantity})")
    void insertInventory(Inventory inventory);
}
