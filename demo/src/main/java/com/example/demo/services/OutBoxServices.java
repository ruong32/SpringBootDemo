package com.example.demo.services;

import com.example.demo.models.OutBox;
import com.example.demo.repositories.OutBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutBoxServices {
    @Autowired
    private OutBoxRepository repository;

    public void handleOutBoxEvent(OutBox outBox){
        repository.save(outBox);
        repository.delete(outBox);
    }
}
