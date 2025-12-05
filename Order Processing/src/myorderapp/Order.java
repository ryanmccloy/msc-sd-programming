package myorderapp;

/**
 * represents a preprocessed order in the system
 */
public class Order {
	/** Unique ID for the order. */
    private int orderID;

    /** Name of the customer who placed the order. */
    private String customerName;

    /** Unique ID for the ordered item. */
    private int itemID;

    /** Descriptive name of the ordered item. */
    private String itemName;

    /** Quantity of the item ordered. */
    private int quantity;

    /** Delivery area or region for this order. */
    private String deliveryArea;

    /** Priority level of the order (e.g. NORMAL or HIGH). */
    private Priority priority;

    /**
     * Default constructor that creates an empty Order object.
     * Fields can be set later using the setter methods.
     */
    public Order() {
    }

    /**
     * Full-argument constructor that initialises all fields
     * of the Order object.
     *
     * @param orderID       The unique ID of the order.
     * @param customerName  The name of the customer.
     * @param itemID        The unique ID of the item ordered.
     * @param itemName      The name of the item ordered.
     * @param quantity      The quantity of the item ordered.
     * @param deliveryArea  The delivery area for this order.
     * @param priority      The priority of the order (e.g. NORMAL, HIGH).
     */
    public Order(int orderID, String customerName, int itemID, String itemName,
                 int quantity, String deliveryArea, Priority priority) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.itemID = itemID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.deliveryArea = deliveryArea;
        this.priority = priority;
    }

    /**
     * Gets the order ID.
     *
     * @return The unique ID of this order.
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Sets the order ID.
     *
     * @param orderID The new order ID.
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * Gets the customer's name.
     *
     * @return The name of the customer who placed the order.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the customer's name.
     *
     * @param customerName The new customer name.
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Gets the item ID.
     *
     * @return The unique ID of the item ordered.
     */
    public int getItemID() {
        return itemID;
    }

    /**
     * Sets the item ID.
     *
     * @param itemID The new item ID.
     */
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    /**
     * Gets the item name.
     *
     * @return The name of the item ordered.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the item name.
     *
     * @param itemName The new item name.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Gets the quantity ordered.
     *
     * @return The quantity of the item ordered.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity ordered.
     *
     * @param quantity The new quantity of the item ordered.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the delivery area.
     *
     * @return The delivery area for this order.
     */
    public String getDeliveryArea() {
        return deliveryArea;
    }

    /**
     * Sets the delivery area.
     *
     * @param deliveryArea The new delivery area.
     */
    public void setDeliveryArea(String deliveryArea) {
        this.deliveryArea = deliveryArea;
    }

    /**
     * Gets the priority level of the order.
     *
     * @return The priority of the order (e.g. NORMAL or HIGH).
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Sets the priority level of the order.
     *
     * @param priority The new priority (e.g. NORMAL or HIGH).
     */
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    /**
     * Displays all details of this order to the console
     * in a formatted and readable way.
     */
    public void displayAll() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Item ID: " + itemID);
        System.out.println("Item Name: " + itemName.toUpperCase());
        System.out.println("Quantity: " + quantity);
        System.out.println("Delivery Area: " + deliveryArea);
        System.out.println("Priority: " + priority);
        System.out.println("----------------------------------------");
    }
}