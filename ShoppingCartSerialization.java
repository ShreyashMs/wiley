
import java.io.*;

public class ShoppingCartSerialization {

    public static void serializeShoppingCart(ShoppingCart cart, String filename) {
        try (OutputStream outputStream = new FileOutputStream(filename);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject(cart);
            System.out.println("Shopping cart serialized successfully to " + filename);
        } catch (IOException ex) {
            System.err.println("Error occurred during serialization: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 1000));
        cart.addProduct(new Product("Phone", 500));

        String filename = "ShoppingCart.ser";
        serializeShoppingCart(cart, filename);
    }
}
