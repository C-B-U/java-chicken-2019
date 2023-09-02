package service;

import constant.PaymentType;
import domain.Menu;
import domain.Table;
import domain.TableRepository;

public class ChickenService {

    TableRepository tableRepository = new TableRepository();

    public void order(int tableNumber, Menu menu, int quantity) {
        tableRepository.addMenu(tableNumber, menu, quantity);
    }

    public int payment(Table table, PaymentType type) {
        return table.payment(type);
    }

    public Table findByTableNumber(int tableNumber) {
        return TableRepository.findByTableNumber(tableNumber);
    }
}