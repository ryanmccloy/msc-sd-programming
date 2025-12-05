/**
 * 
 */
package myorderapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * This class is a simple console-based application that reads orders from a CSV
 * and displays a menu to process the orders
 */
public class OrderProcessingApp {

	/**
	 * Shared queue that stores all imported Order objects.
	 */
	public static Queue<Order> orders = new LinkedList<Order>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Order Application Started");
		System.out.println("-------------------------");
		System.out.println();

		try {
			importOrders();
			drawMenu();
		} catch (Exception e) {
			System.out.println("Sorry - contact your admin.");
		}

		System.out.println();
		System.out.println("-------------------------");
		System.out.println("Order Application Stopped");

	}

	/**
	 * prints menu of application to the console
	 */
	private static void drawMenu() {

		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			
			// small delay to allow any actions to be notified to user
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}

			// menu
			System.out.println();
			System.out.println("Order Menu");
			System.out.println();
			System.out.println("1. Show all orders");
			System.out.println("2. Search for order");
			System.out.println("3. Process order");
			System.out.println("0. Quit");
			System.out.println();
			
			// check for int entry
            while (!sc.hasNextInt()) {
            	System.out.println();
                System.out.print("Please enter a number: ");
                sc.next(); // discard invalid input
                
            }
            
            System.out.println();
            choice = sc.nextInt();
            sc.nextLine(); // clear newline
            
            // process user choice
            switch (choice) {
            case 1: displayOrders(); break;
            case 2: 
            	System.out.print("Enter order ID to search for: ");
                while (!sc.hasNextInt()) {
                    System.out.print("Please enter a number: ");
                    sc.next(); // discard invalid input
                }
                int orderID = sc.nextInt();
                sc.nextLine(); // clear newline
 
                Order order = searchForOrder(orderID);
 
                if (order != null) {
                    System.out.println("\nOrder details");
                    order.displayAll();
                } else {
                    System.out.println("\nCan't find that order!\n");
                }
            	break;
            case 3: 
            	// in a new Thread - start processing the next order (dequeue)
                System.out.println("Processing orders started");
                Thread t = new Thread(new ProcessOrders());
                t.start();
                break;
            case 0: System.out.println("Goodbye! See you next time!"); break;
            default: System.out.println("Invalid choice. Please try again.");
            }
            
           

		} while (choice != 0);
		
		sc.close();

	}

	/** searches for an order by orderID and returns it
	 * 
	 * @param orderID
	 * @return
	 */
	private static Order searchForOrder(int orderID) {
		
		Order orderFound = null;
		
		for (Order order : orders) {
			
			if (order.getOrderID() == orderID) {
				orderFound = order;
				break;
			}
			
		}
		
		return orderFound;
	}

	/**
	 * displays all orders from the orders queue
	 */
	private static void displayOrders() {
		
		for (Order order : orders) {
			order.displayAll();
		}
		
	}

	/**
	 * Imports orders from a CSV file and stores them in the queue
	 */
	private static void importOrders() {

		File file = new File("amazon_orders.csv"); // ensure file exists in your program
		String data;

		try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {

			// skip the header
			br.readLine();

			// loop & process lines
			while ((data = br.readLine()) != null) {

				// split the CSV line into parts
				String[] orderParts = data.split(",");

				// create an order object
				Order order = new Order();

				// OrderID,CustomerName,ItemID,ItemName,Quantity,DeliveryArea,Priority

				// OrderID
				try {
					order.setOrderID(Integer.parseInt(orderParts[0]));
				} catch (NumberFormatException e) {
					System.err.println("Unable to read the order ID number. Skipping order line.");
					System.out.println();
					continue; // skip this order and move to next line
				}

				// CustomerName
				order.setCustomerName(orderParts[1]);

				// ItemID
				try {
					order.setItemID(Integer.parseInt(orderParts[2]));
				} catch (NumberFormatException e) {
					System.err.println("Unable to read the item ID number. Skipping order line.");
					System.out.println();
					continue; // skip this order and move to next line
				}

				// ItemName
				order.setItemName(orderParts[3]);

				// Quantity
				try {
					order.setQuantity(Integer.parseInt(orderParts[4]));
				} catch (NumberFormatException e) {
					System.err.println("Unable to read the item quantity. Defaulting to 1.");
					order.setQuantity(1);

				}

				// DeliveryArea
				order.setDeliveryArea(orderParts[5]);

				// Priority
				switch (orderParts[6]) {
				case "NORMAL":
					order.setPriority(Priority.NORMAL);
					break;
				case "HIGH":
					order.setPriority(Priority.HIGH);
					break;
				default:
					System.err.println("Unrecognised priority. Defaulting to Normal");
					order.setPriority(Priority.NORMAL);
				}

				// store the order in the queue
				orders.add(order);

			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found - cannot import orders.");
		} catch (IOException e) {
			System.out.println("Problem reading from file.");
		}

		// statistics
		System.out.println();
		System.out.println("Order read complete.");
		System.out.println("Number of orders processed : " + orders.size());
		System.out.println("-------------------------------");
		System.out.println();

	}

}
