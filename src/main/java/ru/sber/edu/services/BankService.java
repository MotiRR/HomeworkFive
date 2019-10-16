package ru.sber.edu.services;

import ru.sber.edu.entity.Bank;

import java.util.List;

public interface BankService {
    List<Bank> findAll();

    Bank findById(Long id);

    Bank save(Bank bank);

    Bank update(Bank newBank, Long id);

    void deleteById(Long id);

}
