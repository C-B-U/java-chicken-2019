package service;

import DTO.TableDTO;
import constants.Menu;
import domain.*;

public class PosService {

    private final TableDTO tableDTO;

    public PosService() {
        this.tableDTO = new TableDTO();
    }

    public void saveOrderList(Table table, Menu menu, int quantity) {
        OrderList orderList = table.getOrderList();
        orderList.saveOrder(menu, quantity);
    }

    public void updateTableOrderStatus(Table table) {
        TableStatus tableStatus = tableDTO.getTableStatus();
        tableStatus.changeTableOrderStatus(table);
    }

    public void updateTablePaymentStatus(Table table) {
        TableStatus tableStatus = tableDTO.getTableStatus();
        tableStatus.changeTablePaymentStatus(table);
    }

    public Payment applyDiscount(Table table, int paymentNumber) {
        Payment payment = new Payment(table.getOrderList());
        payment.applyDiscount(paymentNumber);
        return payment;
    }

    public TableList getTableList() {
        return tableDTO.getTableList();
    }

    public TableStatus getTableStatus() {
        return tableDTO.getTableStatus();
    }
}
