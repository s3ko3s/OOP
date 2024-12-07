package L5.model.training;

import java.util.ArrayList;
import java.util.List;

import L5.model.Specialize;
import L5.model.client.Client;

public class GroupTraining extends Training {
    Specialize specializeType;
    List<Client> clients;

    public GroupTraining(Specialize specializeType) {
        this.specializeType = specializeType;
        this.clients = new ArrayList<>();
    }

    @Override
    public Specialize getSpecializeType() {
        return specializeType;
    }

    @Override
    public List<Client> getClients() {
        return clients;
    }

    @Override
    public void clearTraining() {
        clients = new ArrayList<>();
    }

    @Override
    public void deleteClientToTraining(Client client) {
        for (Client client1 : clients) {
            if (client.equals(client1)){
                clients.remove(client);
            }
        }
    }

    @Override
    public void addClientToTraining(Client client) {
        clients.add(client);
    }
}
