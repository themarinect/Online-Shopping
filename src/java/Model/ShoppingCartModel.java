/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entities.Product;
import Entities.ProductCart;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author admin
 */
public class ShoppingCartModel {

    private ArrayList cartItems;
    private float amount;

    public ShoppingCartModel() {
        cartItems = new ArrayList();
    }

    public void addItem(int ProductId, int quantity) {
        ProductModel productModel = new ProductModel();
        ProductCart item = null;
        boolean match = false;
        for (int i = 0; i < cartItems.size(); i++) {
            if (((ProductCart) cartItems.get(i)).getProductID() == ProductId) {
                item = (ProductCart) cartItems.get(i);
                setAmount(getAmount() + quantity * item.getPrice());
                item.setQuantity(item.getQuantity() + quantity);
                match = true;
                break;
            }
        }//end of for loop

        if (!match) {
            item = new ProductCart();
            Product product = productModel.getProduct(ProductId);
            item.setProductID(product.getProductID());
            item.setProductName(product.getProductName());
            item.setPrice(product.getPrice());
            item.setQuantity(quantity);
            setAmount(getAmount() + quantity * item.getPrice());
            System.out.println(product.getProductName());
            cartItems.add(item);
        }
    }
    public void removeItem(int ProductId) {
        for (int i = 0; i < cartItems.size(); i++) {
            ProductCart item = (ProductCart) cartItems.get(i);
            if (item.getProductID() == ProductId) {
                setAmount(getAmount() - item.getPrice() * item.getQuantity());
                cartItems.remove(i);
                break;
            }
        }
    }
    public void removeAll() {
        cartItems.clear();
    }

    public Iterator getCartItems() {
        return cartItems.iterator();
    }

    public float getAmount() {
        return this.amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
