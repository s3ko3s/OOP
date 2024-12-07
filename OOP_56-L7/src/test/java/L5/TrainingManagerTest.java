package L5;

import L5.exception.TrainingIsBusyException;
import L5.model.Specialize;
import L5.model.training.GroupTraining;
import L5.model.training.PersonalTraining;
import L5.model.training.Training;
import L5.model.client.Client;
import org.junit.jupiter.api.*;
import L5.service.TrainingManager;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainingManagerTest {

    private static final Training pilates = new PersonalTraining(Specialize.PILATES);
    private static final Training yoga = new GroupTraining(Specialize.YOGA);
    private static final LocalDate birthday = LocalDate.of(2000, 8, 10);
    private static final LocalDate date = LocalDate.of(2024, 10, 21);
    private static final Client CLIENT = new Client("FIO", Specialize.FITNESS, birthday, date);
    private static final Client CLIENT_2 = new Client("FIO", Specialize.YOGA, birthday, date);
    private static final Client CLIENT_3 = new Client("FIO", Specialize.PILATES, birthday, date);
    private static final TrainingManager TRAINING_MANAGER = new TrainingManager();
    List<Training> trainings = List.of(pilates, yoga);


    @AfterEach
    void clearShelves() {
        trainings.forEach(Training::clearTraining);
    }

    @Test
    @DisplayName("Проверим, у всех клиентов нужные им тренировки")
    void allTrainingsHaveCorrectClients() {
        assertDoesNotThrow(() ->
                TRAINING_MANAGER.addClientToTraining(pilates, CLIENT_3));
        assertDoesNotThrow(() ->
                TRAINING_MANAGER.addClientToTraining(yoga, CLIENT_2));
        for (Training training : trainings) {
            for (Client client : training.getClients()) {
                Assertions.assertEquals(training.getSpecializeType(), client.getDirection());
            }
        }
    }

    @Test
    @DisplayName("Проверим, что если мы вдруг перепутали тренировки, то наш менеджер все равно направит на нужную")
    void incorrectClientHasCorrectTraining() {
        assertDoesNotThrow(() -> TRAINING_MANAGER.addClientToTraining(
                pilates,
                CLIENT_2
        ));

        assertEquals(pilates.getClients().size(), 0);

        assertEquals(yoga.getClients().size(), 1);
        assertEquals(yoga.getSpecializeType(),
                yoga.getClients().get(0).getDirection());
    }

    @Test
    @DisplayName("Ошибка прикрепления клиента к тренировке")
    void trainingDoesNotExistsForClient() {
        assertThrows(TrainingIsBusyException.class,
                () -> TRAINING_MANAGER.addClientToTraining(pilates, CLIENT));
    }

}

