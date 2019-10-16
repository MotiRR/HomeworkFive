package ru.sber.edu.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    //@OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    //private List<AccountType> accounts = new ArrayList();

    public Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }

    /*public AccountType addAccount(String name) {
        AccountType account = new AccountType(name);
        accounts.add(account);
        account.setBank(this);
        return account;
    }*/

}
