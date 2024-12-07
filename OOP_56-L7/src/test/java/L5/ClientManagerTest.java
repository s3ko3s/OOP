package L5;

import L5.exception.WrongDateException;
import L5.model.Specialize;
import L5.model.client.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import L5.service.ClientManager;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClientManagerTest {
    private static final LocalDate birthday = LocalDate.of(2000, 8, 10);
    private static final LocalDate date = LocalDate.of(2024, 11, 10);
    private static final Client CLIENT = new Client("FIO", Specialize.YOGA, birthday, date);
    private static final String VALID_DATE = "2024-11-10";
    private static final String INVALID_DATE = "2024/08/10";
    private static final String INVALID_DATE2 = "1999-08-10";
    private final ClientManager clientManager = new ClientManager();

    @Test
    @DisplayName("Дата записи валидная, ошибки не будет")
    void setDateOfReceptionValid() {
        clientManager.setDateOfReception(CLIENT, VALID_DATE);
        assertEquals(CLIENT.getWorkout(), LocalDate.parse(VALID_DATE));
    }


    @Test
    @DisplayName("Ошибка валидации формата даты записи")
    void setDateOfReceptionInValid() {
        assertThrows(WrongDateException.class,
                () -> clientManager.setDateOfReception(CLIENT, INVALID_DATE));
    }

    @Test
    @DisplayName("Ошибка валидации даты записи")
    void setDateOfReceptionInvalidPast() {
        assertThrows(WrongDateException.class,
                () -> clientManager.setDateOfReception(CLIENT, INVALID_DATE2));
    }
}
