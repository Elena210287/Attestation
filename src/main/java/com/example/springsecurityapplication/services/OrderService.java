package com.example.springsecurityapplication.services;

import com.example.springsecurityapplication.models.Order;
import com.example.springsecurityapplication.models.Person;
import com.example.springsecurityapplication.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }



    //Возвращаем все товары (products)
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    //Возвращаем все товары по id
    public Order getOrderById(int id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElse(null);
    }

    //Сохраняем то, что пришло из формы (объект товара, т.е. products)
    @Transactional
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    //Обновить информацию
    @Transactional
    public void updateOrder(int id, Order order) {
        order.setId(id);
        orderRepository.save(order);
    }

    //Обновить статус заказа
    @Transactional
    public void updateOrderStatus(Order order) {
        orderRepository.save(order);
    }

    //Удаляем товары по id
    @Transactional
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
