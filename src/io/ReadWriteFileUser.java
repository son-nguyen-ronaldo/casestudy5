package io;


import model.uer.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileUser extends ReadWriteFiles<User> {
    private static ReadWriteFileUser readWriteFileUser;

    private ReadWriteFileUser() {
    }
    public static ReadWriteFileUser getInstance(){
        if(readWriteFileUser == null){
            readWriteFileUser = new ReadWriteFileUser();
        }
        return  readWriteFileUser;
    }


    @Override
    public void writeList(List<User> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        File file = new File("listUser.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> readList() {
        List<User> adminList = new ArrayList<>();
        File file = new File("listUser.txt");
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
            adminList = (List<User>) ois.readObject();
            ois.close();
            fis.close();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return adminList;

    }
}
