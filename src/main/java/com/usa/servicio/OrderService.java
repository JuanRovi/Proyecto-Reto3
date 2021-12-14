package com.usa.servicio;

import com.usa.modelo.Order;
import com.usa.repositorio.OrderRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepositorio orderRepository;

    public List<Order> getAll(){

        return orderRepository.getAll();

    }

    public Order save(Order order){
        Optional<Order> orderExist=orderRepository.getOrderById(order.getId());

        if (orderExist.isEmpty()){

            return orderRepository.save(order);
        }
        else{
            return order;
        }
    }

    public Order update(Order order){

        if(order.getId() == null){

            return order;

        }else{
            Optional<Order> orderExist = orderRepository.getOrderById(order.getId());
            if(orderExist.isPresent()){
                if(order.getStatus() != null){

                    orderExist.get().setStatus(order.getStatus());

                }
                return orderRepository.save(order);
            }else{

                return order;

            }

        }

    }








    public Integer deleteOrder(Integer id){
        Optional<Order> orderExist = orderRepository.getOrderById(id);

        if(!orderExist.isEmpty() ){

            orderRepository.deleteOrder(id);
            return null;
        }
        else{
            return id;
        }
    }


    public Order getById(Integer id){

        Optional<Order> orderExist= orderRepository.getOrderById(id);
        if(orderExist.isPresent()){

            return orderExist.get();
        }
        else{

            return new Order();
        }
    }

    public List<Order> getZone(String country){

        return orderRepository.getZone(country);

    }

    public List<Order> getStatus(String zone){

        return orderRepository.getStatus(zone);

    }
}
