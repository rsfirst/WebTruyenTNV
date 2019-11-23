package model;

import java.util.HashMap;
import java.util.Map;

public class Cart 
{

    private HashMap<Long, Item> cartItems;
    
    public Cart()
    {
        cartItems = new HashMap<>();
    }

    public Cart(HashMap<Long, Item> cartItems)
    {
        this.cartItems = cartItems;
    }
    
    public HashMap<Long, Item> getCartItems()
    {
        return cartItems;
    }
    
    public void setCartItems(HashMap<Long, Item> cartItems) {
        this.cartItems = cartItems;
    }
    
    //insert into cart
    public void plusToCart(Long Key, Item item)
    {
        if (cartItems.containsKey(Key))
        {
            int quantity_old = item.getQuantity();
            item.setQuantity(quantity_old + 1);
            cartItems.put(Key, item);
        }
        else
        {
            cartItems.put(Key, item);   
        }
    }
    //sub to cart
    public void subToCart(Long Key,Item item)
    {
        boolean check = cartItems.containsKey(Key);
        if (check)
        {
            int quantity_old = item.getQuantity();
            if(quantity_old <= 1)
            {
                cartItems.remove(Key);
            }
            else
            {
                item.setQuantity(quantity_old -1);
                cartItems.put(Key, item);
            }
        }
        else
        {
            cartItems.put(Key, item);   
        }
    }
    //remove from cart
    public void removeCart(Long Key)
    {
        boolean check = cartItems.containsKey(Key);
        if(check)
        {
            cartItems.remove(Key);
        }
    }
    //count item
    public int countItem()
    {
        return  cartItems.size();
    }
    //sum total 
    public double totalCart()
    {   
        double count = 0;
        //count  = prce * quantity;
        for(Map.Entry<Long,Item> list:cartItems.entrySet())
        {
            count += list.getValue().getProduct().getProductPrice()* list.getValue().getQuantity();
        }
        return count;
    }
}
