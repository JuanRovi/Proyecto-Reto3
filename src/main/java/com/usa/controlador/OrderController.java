/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.controlador;


import com.usa.modelo.Order;
import com.usa.servicio.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author roll-
 */

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class OrderController {
     @Autowired
    private OrderService service;

    
    /**
     * 
     * @return 
     */
    @GetMapping("/all")
    public List<Order> getOrder() {

        return service.getAll();

    }
    
    @GetMapping("/{id}")
    public Order getById(@PathVariable("id") Integer id){
        
        return service.getById(id);
    
    }
    
    
    /**
     * 
     * @param clone
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        System.out.println(order);
    return service.save(order);
    
    }
    
    
//    @PutMapping("/update")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Order update(@RequestBody Order order){
//    
//    return service.update(order);
//    
//    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer delete(@PathVariable Integer id){
    
       return  service.deleteOrder(id);
    
    }
    
//    @GetMapping("/{status}")
//    public List<Order> getByStatus(@PathVariable String status){
//    
//        return service.getStatus(status);
//    
//    }
    
    @GetMapping("/zona/{zone}")
    public List<Order> getByZone(@PathVariable String zone){
    
        return service.getZone(zone);
    
    }
    
    @PutMapping("/update")
    public Order update(@RequestBody Order order){
    
        return service.update(order);
    
    }
}
