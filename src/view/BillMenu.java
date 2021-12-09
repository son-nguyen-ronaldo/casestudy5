package view;

import controller.BillManager;
import controller.CarManager;
import controller.UserManager;
import model.bill.Bill;
import model.car.Car;
import model.uer.User;
import io.ReadWriteFileBill;

import java.time.LocalDate;
import java.util.Scanner;
public class BillMenu {

    public void runBill() {
        BillManager billManager = BillManager.getInstance();
       try {
           billManager.setBillList(ReadWriteFileBill.getInstance().readList());
       } catch (Exception e) {
           e.printStackTrace();
       }
        int choice;
        do {
            System.out.println("1.Hiển thị Bill");
            System.out.println("2. Thêm mới Bill");
            System.out.println("3. Sửa Bill");
            System.out.println("4. Xóa BIll");
            System.out.println("5.Tính tiền ");
            System.out.println("0. Quay Lại");
            System.out.println("Nhập lựa chọn của bạn");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    showBill(billManager);
                    break;
                }
                case 2: {
                    addNewBill(billManager);
                    break;
                }
                case 3:{
                    updateBill(billManager);
                    break;
                }
                case 4:{
                    deleteBill(billManager);
                    break;
                }
                case 5:{
                    totalMoney(billManager);
                    break;
                }
                case 0:{
                }
            }

        } while (choice != 0);
    }

    private void totalMoney(BillManager billManager) {
        int index=0;
        long money;
        if (billManager.getBillList().get(index).getCar().getType().equals("vip")){
            money= billManager.getBillList().get(index).getTotalPrice() * 2;
        }else {
           money= billManager.getBillList().get(index).getTotalPrice();
        }
        System.out.println("GIá Tiền phải trả là : " +money);
    }

    private void deleteBill(BillManager billManager) {
        System.out.println("4. Xóa BIll");
        System.out.println("Nhập biển số xe");
        Scanner scanner = new Scanner(System.in);
        String bsx =scanner.nextLine();
        billManager.removeByLicensePlate(bsx);
    }

    private void updateBill(BillManager billManager) {
        System.out.println("3. Sửa Bill");
        System.out.println("Nhập biển số xe");
        Scanner scanner = new Scanner(System.in);
        String bsx =scanner.nextLine();
        billManager.updateByLicensePlate(bsx,inputBill());
    }

    private void addNewBill(BillManager billManager) {
        System.out.println("Thêm mới Bill");
        billManager.addAll(inputBill());

    }

    private Bill inputBill() {
        System.out.println("Thêm danh sách BIll");
        System.out.println("Nhập ID");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        System.out.println("Nhập CMND");
        String identity = sc.nextLine();
        searchUser(identity);
        System.out.println("Nhập biển số xe");
        String bsx =sc.nextLine();
        searchCar(bsx);
        return new Bill(id,searchCar(bsx),searchUser(identity),checkIn(),checkOut());
    }

    private LocalDate checkOut() {
        System.out.println("Ngày trả");
        return  check();

    }

    private LocalDate checkIn() {
        System.out.println("Ngày Thuê");
        return check();
    }

    private LocalDate check() {
        System.out.println("Nhập năm");
        Scanner scanner =new Scanner(System.in);
        int year =scanner.nextInt();
        System.out.println("Nhập tháng");
        Scanner scanner1 =new Scanner(System.in);
        int month =scanner1.nextInt();
        System.out.println("Nhập ngày");
        Scanner scanner2 =new Scanner(System.in);
        int day =scanner2.nextInt();
        return  LocalDate.of(year,month,day);
    }

    private void showBill(BillManager billManager) {
        billManager.showAll();
    }

    private User searchUser(String identity) {

        UserManager userManager = UserManager.getInstance();
        int index= userManager.searchByIdentity(identity);
       return userManager.getUserList().get(index);
    }
    private Car searchCar(String licensePlate) {
        CarManager carManager = CarManager.getInstance();
        int index = carManager.searchByLicensePlate(licensePlate);
        return carManager.getCarList().get(index);
    }
//    private void checkCar(String licensePlate){
//        Scanner scanner =new Scanner(System.in);
//        String bsx =scanner.nextLine();
//        if (searchCar(licensePlate).getLicensePlate().equals(bsx)){
//            System.err.println("Xe đã được thuê");
//        }
//    }

}
