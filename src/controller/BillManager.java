package controller;

import model.bill.Bill;
import io.ReadWriteFileBill;

import java.util.ArrayList;
import java.util.List;

public class BillManager implements IGeneralManager<Bill>{
    private List<Bill> billList = new ArrayList<>();
    ReadWriteFileBill readWriteFileBill = ReadWriteFileBill.getInstance();
    private static BillManager billManager;
    private BillManager() {
    }

    public static BillManager getInstance(){
        if(billManager == null){
            billManager = new BillManager();
        }
        return  billManager;
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }




    @Override
    public void addAll(Bill bill) {
        billList.add(bill);
       try{
           readWriteFileBill.writeList(getBillList());
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Override
    public void showAll() {
        for (Bill bill:billList
             ) {
            System.out.println(bill);
        }
    }

    @Override
    public void removeByLicensePlate(String licensePlate) {
        int index = searchByLicensePlate(licensePlate);
        if (index!=-1){
            billList.remove(index);
        }else {
            System.out.println("Không tìm thấy Biển số xe này >>>.");
        }
        try{
            readWriteFileBill.writeList(getBillList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateByLicensePlate(String licensePlate, Bill bill) {
        int index = searchByLicensePlate(licensePlate);
        if (index != -1) {
            billList.set(index, bill);
        } else {

            System.out.println("Không tìm thấy biển số này >>.");
        }
        try{
            readWriteFileBill.writeList(getBillList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
        public int searchByLicensePlate(String licensePlate) {
        int index = -1;
        for (int i = 0; i < billList.size(); i++) {
            if (billList.get(i).getCar().getLicensePlate().equals(licensePlate)){
                return i;
            }
        }
        return index;
    }

}
