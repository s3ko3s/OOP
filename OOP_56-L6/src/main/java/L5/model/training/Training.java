package L5.model.training;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import L5.model.Specialize;
import L5.model.client.Client;

import java.util.List;

@Slf4j
@Getter
@NoArgsConstructor
public abstract class Training {

    public abstract Specialize getSpecializeType();
    public abstract void addClientToTraining(Client client);
    public abstract void deleteClientToTraining(Client client);
    public abstract List<Client> getClients();
    public abstract void clearTraining();
    public void log(String message){
        log.info(message);
    }
}
