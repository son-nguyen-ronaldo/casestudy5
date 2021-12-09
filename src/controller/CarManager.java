package controller;

import model.car.Car;
import io.ReadWriteFileCar;

import java.util.ArrayList;
import java.util.List;

public class CarManager implements IGeneralManager<Car> {
    private List<Car> carList = new ArrayList<>();
    private  static CarManager carManager;
    ReadWriteFileCar readWriteFileCar = ReadWriteFileCar.getInstance();
    public static CarManager getInstance(){
        if(carManager == null){
            carManager = new CarManager();
        }
        return  carManager;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    private CarManager() {
    }

    public CarManager(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public void addAll(Car car) {
        carList.add(car);
       try {
           readWriteFileCar.writeList(getCarList());
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Override
    public void showAll() {
        for (Car car : carList) {
            System.out.println(car);
        }
    }

    @Override
    public void removeByLicensePlate(String licensePlate) {
        int index = searchByLicensePlate(licensePlate);
        if (index!=-1){
            carList.remove(index);
        }else {
            System.out.println("Không tìm thấy Biển số xe này >>>.");
        }
        try {
            readWriteFileCar.writeList(getCarList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateByLicensePlate(String licensePlate, Car car) {
        int index = searchByLicensePlate(licensePlate);
        if (index != -1) {
            carList.set(index, car);
        } else {

            System.out.println("Không tìm thấy biển số này >>.");
        }
        try {
            readWriteFileCar.writeList(getCarList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int searchByLicensePlate(String licensePlate) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getLicensePlate().equalsIgnoreCase(licensePlate)){
                return carList.indexOf(carList.get(i));
            }
        }
        return -1;
    }
}
