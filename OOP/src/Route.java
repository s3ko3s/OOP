import java.util.ArrayList;
import java.util.List;

class Route {
    private String routeNumber;
    private List<Station> stations;
    private Vehicle vehicle;

    public Route(String routeNumber, Vehicle vehicle) {
        this.routeNumber = routeNumber;
        this.vehicle = vehicle;
        this.stations = new ArrayList<>();
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public List<Station> getStations() {
        return stations;
    }

    public void printRouteInfo() {
        System.out.println("Маршрут: " + routeNumber);
        System.out.println("Транспорт: " + vehicle.getVehicleNumber());
        System.out.println("Остановки:");
        for (Station station : stations) {
            System.out.println("- " + station.getName());
        }
    }
}