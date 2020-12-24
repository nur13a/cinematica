package com.company.project.services;

import com.company.project.entities.Session;
import com.company.project.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService implements BaseService<Session> {
    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public List<Session> getAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Session getById(Long id) {
        Optional<Session> session = sessionRepository.findById(id);
        return session.orElse(null);
    }

    @Override
    public Session create(Session model) {
        return sessionRepository.save(model);
    }

    @Override
    public Session update(Session model) {
        return sessionRepository.save(model);
    }

    @Override
    public void delete(Session model) {
        sessionRepository.delete(model);
    }

}
