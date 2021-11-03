package com.example.demo;

import com.example.demo.model.CashRegister;
import com.example.demo.service.CashRegisterController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cashRegister")
public class CashRegisterResource {
    private final CashRegisterController cashRegisterController;

    public CashRegisterResource(CashRegisterController cashRegisterController) {
        this.cashRegisterController = cashRegisterController;
    }

    @PostMapping("/add")
    public ResponseEntity<CashRegister> addCashRegister(@RequestBody CashRegister cashRegister) {
        CashRegister newCashRegister = cashRegisterController.addCashRegister(cashRegister);
        return new ResponseEntity<>(newCashRegister, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CashRegister> updateCashRegister(@RequestBody CashRegister cashRegister) {
        CashRegister updateAction = cashRegisterController.updateCashRegister(cashRegister);
        return new ResponseEntity<>(updateAction, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCashRegister(@PathVariable("id") Long id) {
        cashRegisterController.deleteCashRegister(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CashRegister>> getAllCashRegister () {
        List<CashRegister> cashRegister = cashRegisterController.findAllCashRegister();
        return new ResponseEntity<>(cashRegister, HttpStatus.OK);
    }
}
