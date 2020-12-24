package com.company.project.services;

import com.company.project.entities.Hall;
import com.company.project.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HallService implements BaseService<com.company.project.entities.Hall> {
    @Autowired
    private HallRepository hallRepository;
    @Override
    public List<Hall> getAll() {
        return hallRepository.findAll();
    }

    @Override
    public Hall getById(Long id) {
        Optional<Hall> hall = hallRepository.findById(id);
        return hall.orElse(null);
    }

    @Override
    public Hall create(Hall model) {
        return hallRepository.save(model);
    }

    @Override
    public Hall update(Hall model) {
        return hallRepository.save(model);
    }

    @Override
    public void delete(Hall model) {
hallRepository.delete(model);
    }
}
