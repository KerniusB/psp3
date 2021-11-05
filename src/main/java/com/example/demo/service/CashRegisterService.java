package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.CashRegisterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashRegisterService {

    private final CashRegisterRepository cashRegisterRepository;

    public CashRegisterService(CashRegisterRepository cashRegisterRepository) {
        this.cashRegisterRepository = cashRegisterRepository;
    }


    public User add(User user) {
        return cashRegisterRepository.save(user);
    }


    public User update(User user) {
        return cashRegisterRepository.save(user);
    }

    public void deleteById(Long id) {
        cashRegisterRepository.deleteById(id);
    }

    public List<User> findAll() {
        return cashRegisterRepository.findAll();
    }


    public User findById(Long id) {
        return cashRegisterRepository.findById(id).orElse(null);
    }

}
