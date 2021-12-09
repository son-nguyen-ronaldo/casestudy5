package controller;

public interface IGeneralUser <T>{
    void  addAll(T t);
    void showAll();
    void removeByIdentity(String Identity);
    void  updateByIdentity(String Identity,T t);
    int searchByIdentity(String Identity);
}
