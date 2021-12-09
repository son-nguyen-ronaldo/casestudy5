package view;

import controller.AdminManager;
import model.Admin;
import java.util.Scanner;

public class MenuManager {
    CarMenu carMenu = new CarMenu();
    UserMenu userMenu = new UserMenu();
    BillMenu billMenu = new BillMenu();
    AdminManager adminManager = new AdminManager();



    public void runMenu() {
        adminManager.addAll(new Admin("admin", "admin"));

        int choice;
        do {
            System.out.println("  =====ỨNG DỤNG QUẢN LÝ THUÊ XE =====");
            System.out.println("1.|           Đăng nhập             |");
            System.out.println("2.|       Xem danh sách xe          |");
            System.out.println("0.|             Thoát               |");
            System.out.println("  ===================================");
            System.out.println("       Nhập lựa chọn của bạn       ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    doLogin();
                    break;
                }
                case 2: {
                    client();
                    break;
                }
                case 0: {
                    System.exit(0);
                }
            }

        } while (choice != 0);
    }

    private void client() {
        int choice;
        do {
            System.out.println("1. Xem xe");
            System.out.println("0. quay lại");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    carMenu.dissplayCar();
                    break;
                }
                case 0:
            }
        }while (choice!=0);
    }
    public void runBill() {

        int choice;
        do {
            System.out.println("Hello Admin");
            System.out.println("1. Quản lý xe");
            System.out.println("2. Quản lý Bill");
            System.out.println("3. Quản lý khách hàng");
            System.out.println("0. Quay Lại");
            System.out.println("Nhập lựa chọn của Bạn");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                  carMenu.run();
                    break;
                }
                case 2: {
                    billMenu.runBill();
                    break;
                }
                case 3: {
                    userMenu.runUser();
                    break;
                }
                case 0: {

                }
            }
        } while (choice != 0);
    }

    private void doLogin() {
        System.out.println("Đăng Nhập");
        System.out.println("Nhập UserName");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Nhập password");
        String password = scanner.nextLine();
        Admin user = new Admin(name, password);
        if (adminManager.isLogin(user) != null) {
            runBill();
        } else {
            System.err.println("Sai tài khoản hoặc mật khẩu");
        }
    }
}
