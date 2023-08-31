package service;

import domain.Menu;
import domain.Table;
import domain.TableRepository;

public class ChickenService {

    TableRepository tableRepository = new TableRepository();

    public void  order(int tableNumber, Menu menu, int quantity) {
        tableRepository.addMenu(tableNumber, menu, quantity);
    }

    public Table findByTableNumber(int tableNumber) {
        return TableRepository.findByTableNumber(tableNumber);
    }
}