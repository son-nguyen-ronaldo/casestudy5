package controller;

import model.uer.User;
import io.ReadWriteFileUser;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements IGeneralUser<User> {
    private List<User> userList = new ArrayList<>();
    ReadWriteFileUser readWriteFileUser = ReadWriteFileUser.getInstance();
    public UserManager(List<User> userList) {
        this.userList = userList;
    }
    private  static UserManager userManager;

    public static UserManager getInstance(){
        if(userManager == null){
            userManager = new UserManager();
        }
        return  userManager;
    }
    private UserManager() {
    }

    public ReadWriteFileUser getReadWriteFileUser() {
        return readWriteFileUser;
    }

    public void setReadWriteFileUser(ReadWriteFileUser readWriteFileUser) {
        this.readWriteFileUser = readWriteFileUser;
    }

    public static UserManager getUserManager() {
        return userManager;
    }

    public static void setUserManager(UserManager userManager) {
        UserManager.userManager = userManager;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public void addAll(User user) {
        userList.add(user);
       try {
           readWriteFileUser.writeList(userList);
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Override
    public void showAll() {
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Override
    public void removeByIdentity(String identity ) {
        int index = searchByIdentity(identity);
        if (index!=-1){
            userList.remove(index);
        }else {
            System.out.println("Không tìm thấy Biển số xe này >>>.");
        }

        try {
            readWriteFileUser.writeList(userList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateByIdentity(String identity, User user) {
        int index = searchByIdentity(identity);
        if (index != -1) {
            userList.set(index, user);
        } else {

            System.out.println("Không tìm thấy biển số này >>.");
        }
        try {
            readWriteFileUser.writeList(userList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int searchByIdentity(String identity) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getIdentity().equals(identity)){
                return i;

            }
        }
        return -1;
    }
}
