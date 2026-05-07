package com.simplify.restservices.controllers;

import com.simplify.restservices.entities.Order;
import com.simplify.restservices.entities.User;
import com.simplify.restservices.exceptions.OrderException;
import com.simplify.restservices.exceptions.OrderNotFoundException;
import com.simplify.restservices.exceptions.UserNotFoundException;
import com.simplify.restservices.repositories.OrderRepository;
import com.simplify.restservices.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class OrderController {

    private UserRepository userRepository;
    private OrderRepository orderRepository;

    public OrderController(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{userid}/orders")
    public List<Order> getAllOrders(@PathVariable Long userid) {
        Optional<User> userOptional = this.userRepository.findById(userid);

        if(userOptional.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }

        return userOptional.get().getOrders();
    }

    @PostMapping("/{userid}/orders")
    public ResponseEntity<Order> createUserOrder(@PathVariable Long userid, @RequestBody Order order) {
        Optional<User> userOptional = this.userRepository.findById(userid);
        if(userOptional.isEmpty()) {
            throw new UserNotFoundException("User Not Found");
        }

        User user = userOptional.get();
        order.setUser(user);

        return new ResponseEntity<>(this.orderRepository.save(order), HttpStatus.CREATED);
    }

    @GetMapping("/{userid}/orders/{orderid}")
    public ResponseEntity<Order> getOrderByOrderId(@PathVariable Long userid, @PathVariable Long orderid) {
        Optional<User> userOptional = this.userRepository.findById(userid);
        if(userOptional.isEmpty()) {
            throw new UserNotFoundException("User Not Found");
        }

        User user = userOptional.get();
        List<Order> orders = user.getOrders();
        Optional<Order> foundOrder = orders.stream()
                .filter(order -> order.getId().equals(orderid))
                .findFirst();

        if(foundOrder.isEmpty()) {
            throw new OrderNotFoundException("Orden no encontrada para el usuario " + user.getId());
        }
        return new ResponseEntity<>(foundOrder.get(), HttpStatus.OK);
    }

    @PutMapping("/{userid}/orders/{orderid}")
    public ResponseEntity<Order> updateOrderById(@PathVariable Long userid, @PathVariable Long orderid, @RequestBody Order order) {
        Optional<User> userOptional = this.userRepository.findById(userid);
        if(userOptional.isEmpty()) {
            throw new UserNotFoundException("User Not Found");
        }
        User userDB = userOptional.get();

        Optional<Order> orderOptional = this.orderRepository.findById(orderid);
        if(orderOptional.isEmpty()) {
            throw new OrderNotFoundException("Order Not Found");
        }
        Order orderDB = orderOptional.get();

        if(!orderDB.getUser().getId().equals(userDB.getId())) {
            throw new OrderException("La orden no pertenece al usuario");
        }

        orderDB.setDescription(order.getDescription());
        return new ResponseEntity(this.orderRepository.save(orderDB), HttpStatus.OK);
    }

    @DeleteMapping("/{userid}/orders/{orderid}")
    public ResponseEntity<Void> deleteOrderById(@PathVariable Long userid, @PathVariable Long orderid) {
        Optional<User> userOptional = this.userRepository.findById(userid);
        if(userOptional.isEmpty()) {
            throw new UserNotFoundException("User Not Found");
        }
        User userDB = userOptional.get();

        Optional<Order> orderOptional = this.orderRepository.findById(orderid);
        if(orderOptional.isEmpty()) {
            throw new OrderNotFoundException("Order Not Found");
        }
        Order orderDB = orderOptional.get();

        if(!orderDB.getUser().getId().equals(userDB.getId())) {
            throw new OrderException("La orden no pertenece al usuario");
        }
        this.orderRepository.deleteById(orderid);
        return ResponseEntity.noContent().build();
    }
}
