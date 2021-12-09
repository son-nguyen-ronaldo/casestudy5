package controller;

import model.Admin;

import java.util.ArrayList;
import java.util.List;

public class AdminManager implements IGeneralUser<Admin> {
    public AdminManager() {
    }

    private List<Admin> admins = new ArrayList<>();

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    @Override
    public void addAll(Admin admin) {
        admins.add(admin);
    }

    @Override
    public void showAll() {

    }

    @Override
    public void removeByIdentity(String Identity) {

    }

    @Override
    public void updateByIdentity(String Identity, Admin admin) {

    }

    @Override
    public int searchByIdentity(String Identity) {
        return 0;
    }

    public Admin isLogin(Admin admin) {
        for (Admin admin1 : admins) {
            if (admin.getName().equals(admin1.getName()) && admin.getPassword().equals(admin1.getPassword())) {
                return admin1;

            }
        }
        return null;
    }
}