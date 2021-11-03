package com.example.demo.service;

import com.example.demo.model.Action;
import com.example.demo.model.CashRegister;
import com.example.demo.repository.ActionRepository;
import com.example.demo.repository.CashRegisterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionController {

    private final ActionRepository actionRepository;

    public ActionController(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }


    public Action addAction(Action action) {
        return actionRepository.save(action);
    }


    public Action updateAction(Action action) {
        return actionRepository.save(action);
    }

    public void deleteAction(Long id) {
        actionRepository.deleteById(id);
    }

    public List<Action> findAllAction() {
        return actionRepository.findAll();
    }

}
