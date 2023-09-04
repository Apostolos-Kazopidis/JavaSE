package com.kazopidis.app;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class PersonTest {
    static private Person p;

    @BeforeAll
    static void createPerson() {
        p = new Person("Bob", "123 str.", new Debit(0), new Credit(1000));
    }

    @Test
    void testName() {
        assertTrue(p.getName().length()<50);
    }

    @Nested
    @DisplayName("Testing usage of credit")
    class CreditTest {
        @Test
        void testWithdrawCredit() {
            p.getDebit().setBalance(909);
            assertTrue(p.getDebit().getBalance()<Credit.LIMIT);
        }
    }

    @Nested
    @DisplayName("Testing usage of debit")
    class DebitTest {
        @Test
        void testWithdrawDebit() {
            p.getDebit().setBalance(1000);
            int amount = 1100;
            p.getDebit().setBalance(p.getDebit().getBalance()-amount);
            assertTrue(p.getDebit().getBalance()>0);
        }
    }
}
