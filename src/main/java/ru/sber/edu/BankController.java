package ru.sber.edu;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.sber.edu.entity.Bank;

import ru.sber.edu.exceptions.BankNotFoundException;
import ru.sber.edu.services.BankService;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {
    private final BankService service;

    BankController(BankService service) {
        this.service = service;
    }

    // Aggregate root
    @GetMapping
    List<Bank> readAllBank() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Bank createBank(@RequestBody Bank newBank) {
        return service.save(newBank);
    }

    // Single item
    @GetMapping("/{id}")
    Bank readOneBank(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    Bank updateBank(@RequestBody Bank newBank, @PathVariable Long id) {
        return service.update(newBank, id);
    }

    @DeleteMapping("/{id}")
    void deleteBank(@PathVariable Long id) {
        service.deleteById(id);
    }
}
