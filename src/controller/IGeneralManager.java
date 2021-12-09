package controller;

public interface IGeneralManager <T>{
    void  addAll(T t);
    void showAll();
    void removeByLicensePlate(String licensePlate);
    void  updateByLicensePlate(String licensePlate,T t);
    int searchByLicensePlate(String licensePlate);
}
