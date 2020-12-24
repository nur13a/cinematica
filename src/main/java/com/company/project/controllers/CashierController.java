package com.company.project.controllers;

import com.company.project.entities.Cashier;
import com.company.project.services.CashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cashier")
public class CashierController {
    @Autowired
    private CashierService cashierService;

    @GetMapping
    public ResponseEntity getAll() {
        List<Cashier> items = cashierService.getAll();
        try {
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity getById(@PathVariable("id") Long id) throws Exception {
        Cashier cashier = cashierService.getById(id);
        try {
            return new ResponseEntity<>(cashier, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Cashier cashierEntity) {
        Cashier cashier = cashierService.create(cashierEntity);
        try {
            return new ResponseEntity<>(cashier, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody Cashier cashierEntity) {
        try {
            cashierService.delete(cashierEntity);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Cashier itemEntity) {
        Cashier cashier = cashierService.update(itemEntity);
        try {
            return new ResponseEntity<>(cashier, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
