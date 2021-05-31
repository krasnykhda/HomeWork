package ru.home.services;

public class Runner {
    public static void Run() {
        Vehicles plane = new Plane(100, 1000, 40, 10);
        plane.move(10000);
        plane.move(1000);
        try {
            int addVolume = 20;
            plane.addFuel(addVolume);
            System.out.println("Залито " + addVolume + "единиц топлива. Текущий остаток " + plane.getfuelRemaining());
            addVolume = 20;
            plane.addFuel(addVolume);
            System.out.println("Залито " + addVolume + "единиц топлива. Текущий остаток " + plane.getfuelRemaining());

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        plane.drainFuel(40);
        //  plane.drainFuel(10);
        Vehicles ship = new Ship(1000, 50, 300, 100);
        ship.move(1110);
        Ship ship2 = null;
        try {
            plane.loading(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            plane.writeLog(e);
        }

        //ship2.move(30);
    }

}
