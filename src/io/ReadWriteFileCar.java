package io;

import model.car.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileCar extends ReadWriteFiles<Car> {
    private static ReadWriteFileCar readWriteFileCar;

    private ReadWriteFileCar() {
    }
    public static ReadWriteFileCar getInstance(){
        if(readWriteFileCar == null){
            readWriteFileCar = new ReadWriteFileCar();
        }
        return  readWriteFileCar;
    }

    @Override
    public void writeList(List<Car> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        File file = new File("listCar.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> readList() {
        List<Car> carList = new ArrayList<>();
        File file = new File("listCar.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() == 0) {
            return new ArrayList<>();
        }
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            carList = (List<Car>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return carList;

    }
}
