package ru.sber.edu;

import ru.sber.edu.entity.Bank;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RestClientTest {

    final Logger logger = LoggerFactory.getLogger(RestClientTest.class);
    private static final String URL_GET_ALL_SINGERS = "http://localhost:8081/api/banks";
    private static final String URL_GET_SINGER_BY_ID = "http://localhost:8081/api/banks/{id}";
    private static final String URL_CREATE_SINGER = "http://localhost:8081/api/banks";
    private static final String URL_UPDATE_SINGER = "http://localhost:8081/api/banks/{id}";
    private static final String URL_DELETE_SINGER = "http://localhost:8081/api/banks/{id}";
    RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void testFindAll() {
        logger.info("--> Testing retrieve all singers");
        Bank[] banks = restTemplate.getForObject(URL_GET_ALL_SINGERS, Bank[].class);
        assertTrue(banks.length == 2);
        listBanks(banks);
    }

    @Test
    public void testFindById() {
        logger.info("--> Testing retrieve a singer by id : 1");
        Bank bank = restTemplate.getForObject(URL_GET_SINGER_BY_ID, Bank.class, 1);
        assertNotNull(bank);
        logger.info(bank.toString());
    }

    @Test
    public void testUpdate() {
        logger.info("--> Testing update singer by id : 1");
        Bank bank = restTemplate.getForObject(URL_UPDATE_SINGER, Bank.class, 1);
        bank.setName("MMM");
        restTemplate.put(URL_UPDATE_SINGER, bank, 1);
        logger.info("Singer update successfully: " + bank);
    }

    @Test
    public void testDelete() {
        logger.info("--> Testing delete singer by id : 3");
        restTemplate.delete(URL_DELETE_SINGER, 3);
        Bank[] banks = restTemplate.getForObject(URL_GET_ALL_SINGERS, Bank[].class);
        Boolean found = false;
        for (Bank s : banks) {
            if (s.getId() == 3) {
                found = true;
            }
        }
        assertFalse(found);
        listBanks(banks);
    }

    @Test
    public void testCreate() {
        logger.info("--> Testing create bank");
        Bank bankNew = new Bank();
        bankNew.setName("New Bank");
        bankNew = restTemplate.postForObject(URL_CREATE_SINGER, bankNew, Bank.class);
        logger.info("Singer created successfully: " + bankNew);
    }

    private void listBanks(Bank[] banks) {
        Arrays.stream(banks).forEach(s -> logger.info(s.toString()));
    }
}



