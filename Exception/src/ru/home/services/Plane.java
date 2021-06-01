package ru.home.services;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Plane implements Vehicles{
    private final int weight;
    private final int maxSpeed;
    private final int fuelVolume;
    private int currentSpeed=0;
    private int fuelRemaining=0;
    private final int maximumLoadTons;
    private int currentLoadTons=0;
    public Plane(int weight,int maxSpeed,int fuelVolume,int maximumLoadTons) {
        this.weight=weight;
        this.maxSpeed=maxSpeed;
        this.fuelVolume=fuelVolume;
        this.maximumLoadTons=maximumLoadTons;
    }

    @Override
    public void move(int currentSpeed)
    {
        try {
            if(this.maxSpeed<currentSpeed) throw new Exception();
            this.currentSpeed=currentSpeed;
            System.out.println("Я самолет и я лечу со скоростью "+currentSpeed);
        } catch (Exception e){
            System.out.println("Самолету нельзя превышать максимально допустимую скорость");
        }

    }

    @Override
    public void addFuel(int volume) throws Exception {
        if(this.fuelRemaining+volume>this.fuelVolume) throw new Exception();
      this.fuelRemaining+=volume;
    }

    @Override
    public int getfuelRemaining() {
        return this.fuelRemaining;
    }

    @Override
    public void drainFuel(int volume) {
        try{
            if(this.fuelRemaining-volume<0) throw new Exception();
            this.fuelRemaining-=volume;
        }catch (Exception e){
            throw new RuntimeException(e.getCause());
        }
    }



    @Override
    public void writeLog(Exception e) {
        String path = "c:\\logJava.txt";
        try(FileWriter writer = new FileWriter(path, false))
        {
            // запись всей строки
            String text = e.getMessage();
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void loading(int amount) throws Exception {
        try{
            if(this.currentLoadTons+amount>this.maximumLoadTons) throw new Exception();
            this.currentLoadTons+=amount;

        }catch (Exception e){
            throw new Exception("Превышена максимальная загрузка самолета",e);
        }


    }
}
