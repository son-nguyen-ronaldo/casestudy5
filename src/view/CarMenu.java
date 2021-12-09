package view;

import controller.CarManager;
import model.car.Car;
import io.ReadWriteFileCar;

import java.util.Scanner;

public class CarMenu {


    public void run() {
        CarManager carManager = CarManager.getInstance();
        try {
            carManager.setCarList(ReadWriteFileCar.getInstance().readList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        dissplayCar();
        int choice = -1 ;
        while (choice !=0){
            System.out.println("1. Thêm xe");
            System.out.println("2. Hiển thị xe");
            System.out.println("3. Update xe");
            System.out.println("4. Xóa xe");
            System.out.println("0. Quay lại");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    addCar(carManager);
                    break;
                }
                case 2:{
                    displayCar(carManager);
                    break;
                }
                case 3:{
                    updateCar(carManager);
                    break;
                }
                case 4:{
                    deleteCar(carManager);
                    break;
                }
                case 0: {
                }
            }

        }
    }
     public void dissplayCar() {
        Car car1 = new Car("Lexus LS500h", "White", "C01", "19D-8888", "vip");
        Car car2 = new Car(" BMW 750Li", " Yellow", "c02", "19D-2222", "vip");
        Car car3 = new Car(" Mercedes-Benz CLS 500", " Pink", "c03", "19D-3333", "vip");
        Car car4 = new Car("  Infiniti Q70", "White", "C04", "19D-6666", "vip");
        Car car5 = new Car(" Kia Morning Standard", " Pink", "C05", "19D-1234", "economy");
        Car car6 = new Car("Cadillac CT6", "Green", "C06", "19D-9999", "vip");
        Car car7 = new Car("Hyundai Grand i10", "Green", "C07", "19D-1212", "economy");
        Car car8 = new Car("Chevrolet Spark", " Pink", "C08", "19D-6886", "economy");
        Car car9 = new Car("Suzuki Celerio", " Yellow", "C09", "19D-8998", "economy");
        Car car10 = new Car(" Honda City 1.5", "White", "C10", "19D-2131", "economy");
         CarManager carManager =CarManager.getInstance();
         carManager.addAll(car1);
        carManager.addAll(car2);
        carManager.addAll(car3);
        carManager.addAll(car4);
        carManager.addAll(car5);
        carManager.addAll(car6);
        carManager.addAll(car7);
        carManager.addAll(car8);
        carManager.addAll(car9);
        carManager.addAll(car10);

         for (Car car:carManager.getCarList()
              ) {
             System.out.println(car);
         }
    }

    private void deleteCar(CarManager carManager) {
        System.out.println("Xóa thông tin xe");
        System.out.println("Nhập biển số xe");
        Scanner scanner = new Scanner(System.in);
        String bsx =scanner.nextLine();
        carManager.removeByLicensePlate(bsx);
    }

    private void updateCar(CarManager carManager) {
        System.out.println("Sửa thông tin xe");
        System.out.println("Nhập biển số xe");
        Scanner scanner = new Scanner(System.in);
        String bsx =scanner.nextLine();
        carManager.updateByLicensePlate(bsx,inputCar());
    }

    private void displayCar(CarManager carManager) {
        System.out.println("Hiển thị xe");
        carManager.showAll();
    }

    private void addCar(CarManager carManager) {
        System.out.println("Thêm Xe");
        carManager.addAll(inputCar());
    }

    private Car inputCar() {
        System.out.println("Nhập tên xe");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Nhập màu xe");
        String color = scanner.nextLine();
        System.out.println("Nhập id");
        String id = scanner.nextLine();
        System.out.println("Nhập biển số xe");
        String bsx = scanner.nextLine();
        System.out.println("Nhập loại xe");
        String type = scanner.nextLine();
        return new Car(name, color, id, bsx, type);
    }



}
