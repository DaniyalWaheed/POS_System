/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

/**
 *
 * @author daniy
 */
public class Products {
    private String id;
    private String name;
    private String volume;
    private String rate;
    private String quantity;
    private String amount;

    public Products(String id, String name, String volume, String rate, String quantity, String amount) {
        this.id = id;
        this.name = name;
        this.volume = volume;
        this.rate = rate;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getRate() {
        return rate;
    }

    public String getVolume() {
        return volume;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
