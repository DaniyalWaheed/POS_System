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
public class ContractWorkers {
    private String id;
    private String workerName;
    private String contractDuration;
    private String date;
    private String phoneNumber;
    private String amount;

    public ContractWorkers(String id, String workerName, String contractDuration, String date, String phoneNumber, String amount) {
        this.id = id;
        this.workerName = workerName;
        this.contractDuration = contractDuration;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public String getContractDuration() {
        return contractDuration;
    }

    public String getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setContractDuration(String contractDuration) {
        this.contractDuration = contractDuration;
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
