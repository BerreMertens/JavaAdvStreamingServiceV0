package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AccountConstructorTest {
    private Account account;


    @BeforeEach
    public void init(){
        account = new Account("test@gmail.com","password12");
    }

    @Test
    public void AccountConstructorDefaultProfile(){
        assertEquals("profile1",account.getFirstProfile().getName());
        assertNull(account.getFirstProfile().getDateOfBirth());
    }
}
