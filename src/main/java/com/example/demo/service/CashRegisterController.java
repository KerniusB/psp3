package com.example.demo.service;

import com.example.demo.model.CashRegister;
import com.example.demo.repository.CashRegisterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashRegisterController {

    private final CashRegisterRepository cashRegisterRepository;

    public CashRegisterController(CashRegisterRepository cashRegisterRepository) {
        this.cashRegisterRepository = cashRegisterRepository;
    }


    public CashRegister addCashRegister(CashRegister cashRegister) {
        return cashRegisterRepository.save(cashRegister);
    }


    public CashRegister updateCashRegister(CashRegister cashRegister) {
        return cashRegisterRepository.save(cashRegister);
    }

    public void deleteCashRegister(Long id) {
        cashRegisterRepository.deleteById(id);
    }

    public List<CashRegister> findAllCashRegister() {
        return cashRegisterRepository.findAll();
    }

}
