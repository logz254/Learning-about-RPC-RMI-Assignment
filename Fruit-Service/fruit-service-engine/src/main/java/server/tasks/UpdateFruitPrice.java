package server.tasks;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.FruitComputeEngine;
import server.interfaces.Task;

public class UpdateFruitPrice implements Task<String> {
    private final String fruitName;
    private final double newPrice;

    public UpdateFruitPrice(String fruitName, double newPrice) {
        this.fruitName = fruitName;
        this.newPrice = newPrice;
    }

    @Override
    public String execute() throws RemoteException {
        try {
            // Get the engine instance and update the fruit price in its storage
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            FruitComputeEngine engine = (FruitComputeEngine) registry.lookup("FruitComputeEngine");
            engine.updateFruitPrice(fruitName, newPrice);
            
            System.out.println("Updating fruit price for: " + fruitName + " to $" + newPrice);
            return "Fruit price updated successfully for " + fruitName + " to $" + newPrice;
        } catch (Exception e) {
            throw new RemoteException("Failed to update fruit price", e);
        }
    }
}