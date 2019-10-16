package ru.sber.edu.services;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sber.edu.entity.Bank;
import ru.sber.edu.exceptions.BankNotFoundException;
import ru.sber.edu.repository.BankRepository;

import java.util.List;

@Service("bankService")
@Transactional
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Bank> findAll() {
        return Lists.newArrayList(bankRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Bank findById(Long id) {
        return bankRepository.findById(id)
                .orElseThrow(() -> new BankNotFoundException(id));
    }

    @Override
    public Bank save(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Bank update(Bank newBank, Long id) {
        return bankRepository.findById(id)
                .map(bank -> {
                    bank.setName(newBank.getName());
                    return bankRepository.save(bank);
                })
                .orElseGet(() -> {
                    newBank.setId(id);
                    return bankRepository.save(newBank);
                });
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        bankRepository.deleteById(id);
    }

}
