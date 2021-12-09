package view;

import controller.UserManager;
import model.uer.User;
import io.ReadWriteFileUser;

import java.util.Scanner;

public class UserMenu {

    public void runUser(){
        UserManager userManager = UserManager.getInstance();
        try{
            userManager.setUserList(ReadWriteFileUser.getInstance().readList());
        } catch (Exception e ) {
            e.printStackTrace();
        }
        int choice = -1 ;
        while (choice!=0) {
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Hiển thị danh sách khách hàng");
            System.out.println("3. Sửa thông tin khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("5. Tìm kiếm khách hàng");
            System.out.println("0. Quay lại");
            System.out.println("Nhập lựa chọn của bạn");
            Scanner scanner =new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice){
                case 1:{
                    addNewUser( userManager);
                    break;
                }
                case 2:{
                    showUserList(userManager);
                    break;
                }
                case 3:{
                        updateUser(userManager);
                    break;
                }
                case 4:{
                    deleteUser(userManager);
                    break;
                }
                case 5:{
                    searchUser(userManager);
                }
                case 0:

            }

        }
    }

    private void searchUser(UserManager userManager) {
        System.out.println("5. Tìm kiếm khách hàng");
        System.out.println("Nhập CMND");
        Scanner scanner =new Scanner(System.in);
        String identity =scanner.nextLine();
        userManager.searchByIdentity(identity);
    }

    private void deleteUser(UserManager userManager) {
        System.out.println("4. Xóa khách hàng");
        System.out.println("Nhập CMND");
        Scanner scanner =new Scanner(System.in);
        String identity =scanner.nextLine();
        userManager.removeByIdentity(identity);
    }

    private void updateUser(UserManager userManager) {
        System.out.println("3. Sửa thông tin khách hàng");
        System.out.println("Nhập CMND");
        Scanner scanner =new Scanner(System.in);
        String identity =scanner.nextLine();
        userManager.updateByIdentity(identity,inputUser());

    }

    private void showUserList(UserManager userManager) {
        System.out.println("Hiển thị danh sách khách hàng");
        userManager.showAll();
    }

    private void addNewUser(UserManager userManager) {
        System.out.println("1. Thêm khách hàng");
        userManager.addAll(inputUser());
    }

    private User inputUser() {
        System.out.println("Nhập tên");
        Scanner scanner =new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Nhập số CMND");
        String identity =scanner .nextLine();
        System.out.println("Nhập SDT");
        String phone = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address =scanner.nextLine();
        return new User(name,identity,phone,address);
    }

}
