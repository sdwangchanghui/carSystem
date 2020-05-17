package com.jkxy.car.api.controller;

import com.jkxy.car.api.pojo.Car;
import com.jkxy.car.api.pojo.Inventory;
import com.jkxy.car.api.service.CarInventoryService;
import com.jkxy.car.api.service.CarService;
import com.jkxy.car.api.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carinventory")
public class CarInventoryController {

    @Autowired
    private CarInventoryService carInventoryService;

    /**
     * 通过carId更新库存信息
     *
     * @return
     */
    @PostMapping("buyCarByCarId")
    public JSONResult updateById(Inventory inventory) {
        Inventory inventory1Data = new Inventory();
        if ( inventory.getCarId() > 0 ){
            inventory1Data = carInventoryService.findByCarId(inventory.getCarId());
            int buyQuantity = inventory.getQuantity();
            if( inventory1Data.getQuantity() >= buyQuantity){
                inventory.setQuantity(inventory1Data.getQuantity() - buyQuantity );
                carInventoryService.buyCarByCarId(inventory);
                return JSONResult.ok("购买车辆ID："+ inventory.getCarId() +"成功, 数量:"+ buyQuantity +" 剩余库存：" + (inventory1Data.getQuantity() - buyQuantity ) );
            }else{
                return  JSONResult.errorException("购买失败！ 购买的数量:" + inventory.getQuantity() +" 超过车辆库存:"+ inventory1Data.getQuantity() );
            }
        }else{
            return  JSONResult.errorException("购买失败！输入的车辆ID不争取！");
        }


    }

    /**
     * 插入车辆库存信息
     *
     * @return
     */
    @PostMapping("insertCarInventory")
    public JSONResult insertInventory(Inventory inventory) {
        carInventoryService.insertInventory(inventory);
        return JSONResult.ok();
    }

}
