package server.tasks;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.FruitComputeEngine;
import server.interfaces.Task;

public class CalFruitCost implements Task<Double> {
    private final String fruitName;
    private final int quantity;

    public CalFruitCost(String fruitName, int quantity) {
        this.fruitName = fruitName;
        this.quantity = quantity;
    }

    @Override
    public Double execute() throws RemoteException {
        try {
            // Get actual fruit price from the engine's storage
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            FruitComputeEngine engine = (FruitComputeEngine) registry.lookup("FruitComputeEngine");
            double totalCost = engine.calculateFruitCost(fruitName, quantity);
            
            System.out.println("Calculated cost for " + quantity + " " + fruitName + "(s): $" + totalCost);
            return totalCost;
        } catch (Exception e) {
            throw new RemoteException("Failed to calculate fruit cost for " + fruitName, e);
        }
    }
}