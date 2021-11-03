package com.example.demo;

import com.example.demo.model.Action;
import com.example.demo.model.CashRegister;
import com.example.demo.service.ActionController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/action")
public class ActionResource {
    private final ActionController actionController;

    public ActionResource(ActionController actionController) {
        this.actionController = actionController;
    }


    @PostMapping("/add")
    public ResponseEntity<Action> addAction(@RequestBody Action action) {
        Action newAction = actionController.addAction(action);
        return new ResponseEntity<>(newAction, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Action> updateAction(@RequestBody Action action) {
        Action updateAction = actionController.updateAction(action);
        return new ResponseEntity<>(updateAction, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAction(@PathVariable("id") Long id) {
        actionController.deleteAction(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Action>> getAllAction () {
        List<Action> action = actionController.findAllAction();
        return new ResponseEntity<>(action, HttpStatus.OK);
    }
}
