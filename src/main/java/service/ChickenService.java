package service;

import domain.Menu;
import domain.TableRepository;

public class ChickenService {

    TableRepository tableRepository = new TableRepository();

    public void  order(int tableNumber, Menu menu, int quantity) {
        tableRepository.addMenu(tableNumber, menu, quantity);
    }
}