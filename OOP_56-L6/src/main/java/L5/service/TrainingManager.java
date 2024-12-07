package L5.service;

import L5.exception.TrainingIsBusyException;
import L5.model.training.Training;
import L5.exception.TrainingTypeException;
import lombok.extern.slf4j.Slf4j;
import L5.model.Specialize;
import L5.model.client.Client;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TrainingManager {

    private final Map<Specialize, Training> trainings;

    public TrainingManager() {
        this.trainings = new HashMap<>();
    }

    public void addClientToTraining(Training training, Client client) {
        try {
            isRightSpecialize(training.getSpecializeType(), client.getDirection());
            trainings.putIfAbsent(training.getSpecializeType(), training); //если тренировки ещё нет в списке, то добавить
            training.addClientToTraining(client);
        } catch (TrainingTypeException e) {
            log.info(e.getMessage());
        } finally {
            if (trainings.containsKey(client.getDirection())) {
                if (!trainings.get(client.getDirection()).getClients().contains(client)) {
                    Training correct = trainings.get(client.getDirection());
                    correct.addClientToTraining(client);
                    log.info("Клиент отправлен на нужную тренировку");
                }
            } else {
                throw new TrainingIsBusyException("сейчас записи на нужную тренировку нет");
            }
        }
    }

    private void isRightSpecialize(Specialize trainingType, Specialize clientType) throws TrainingTypeException {
        if (trainingType != clientType) {
            throw new TrainingTypeException("Клиенту нужна не эта тренировка");
        }
    }
}
