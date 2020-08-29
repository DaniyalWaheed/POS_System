/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package possystem;

/**
 *
 * @author daniy
 */
public class NormalWorker {
    private String id;
    private String workerName;
    private String date;
    private String phoneNumber;
    private String amount;

    public NormalWorker(String id, String workerName, String date, String phoneNumber, String amount) {
        this.id = id;
        this.workerName = workerName;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getWorkerName() {
        return workerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
