package com.company.project.services;

import com.company.project.entities.Cashier;
import com.company.project.repositories.CashierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CashierService implements BaseService<Cashier> {
    @Autowired
    private CashierRepository cashierRepository;

    public List<Cashier> getAll() {
        return cashierRepository.findAll();
    }

    @Override
    public Cashier getById(Long id) {
        Optional<Cashier> cashier = cashierRepository.findById(id);
        return cashier.orElse(null);
    }

    @Override
    public Cashier create(Cashier model) {
        return cashierRepository.save(model);
    }

    @Override
    public Cashier update(Cashier model) {
        return cashierRepository.save(model);
    }

    @Override
    public void delete(Cashier model) {
        cashierRepository.delete(model);
    }
}
