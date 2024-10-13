public class Main {
    public static void main(String[] args) {
        // Создание автобуса
        Bus bus1 = new Bus("123");

        // Создание станций
        Station station1 = new Station("Станция 1");
        Station station2 = new Station("Станция 2");
        Station station3 = new Station("Станция 3");

        // Создание маршрута
        Route route1 = new Route("A", bus1);
        route1.addStation(station1);
        route1.addStation(station2);
        route1.addStation(station3);

        // Вывод информации о маршруте
        route1.printRouteInfo();
    }
}