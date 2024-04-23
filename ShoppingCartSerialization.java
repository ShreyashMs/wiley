
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
    public static ShoppingCart deserializeShoppingCart(String filename) {
        ShoppingCart cart = null;
        try (InputStream inputStream = new FileInputStream(filename);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            cart = (ShoppingCart) objectInputStream.readObject();
            System.out.println("Shopping cart deserialized successfully from " + filename);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println("Error occurred during deserialization: " + ex.getMessage());
        }
        return cart;
    }
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 50000));
        cart.addProduct(new Product("mobilee", 20000));

        String filename = "ShoppingCart.ser";
//        serializeShoppingCart(cart, filename);
        ShoppingCart deserializedCart = deserializeShoppingCart(filename);
        if (deserializedCart != null) {
            System.out.println("Deserialized Shopping Cart:");
            System.out.println(deserializedCart);
        }
    }
}
