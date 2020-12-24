package com.company.project.services;

import com.company.project.entities.Cashier;
import com.company.project.entities.Hall;
import com.company.project.entities.Session;
import com.company.project.entities.Ticket;
import com.company.project.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements BaseService<Ticket> {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private CashierService cashierService;
    @Autowired
    private HallService hallService;
    @Autowired
    private SessionService sessionService;

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.orElse(null);
    }

    @Override
    public Ticket create(Ticket model) {
        return ticketRepository.save(model);
    }

    @Override
    public Ticket update(Ticket model) {
        return ticketRepository.save(model);
    }

    @Override
    public void delete(Ticket model) {
        ticketRepository.delete(model);
    }

    public Ticket buy(Long id) throws Exception {
        Ticket ticket = getById(id);
        if (ticket != null) {
            ticket.setTicketStatus(true);
            Cashier cashier = cashierService.getById(ticket.getCashier().getId());
            cashier.setMoney(cashier.getMoney() + ticket.getPrice());
            Hall hall = hallService.getById(ticket.getSession().getHall().getId());
            hall.setPlaceCount(hall.getPlaceCount() - 1);
            hallService.update(hall);
            cashierService.update(cashier);
            update(ticket);
            return ticket;
        } else throw new Exception("Not found");

    }
}
