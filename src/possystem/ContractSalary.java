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
public class ContractSalary {

    private String id;
    private String workerName;
    private String weight;
    private String rate;
    private String amount;

    public String salary = "12";

    public ContractSalary() {
    }

    public ContractSalary(String id, String workerName, String weight, String rate, String amount) {
        this.id = id;
        this.workerName = workerName;
        this.weight = weight;
        this.rate = rate;
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public String getId() {
        return id;
    }

    public String getRate() {
        return rate;
    }

    public String getWeight() {
        return weight;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    public String calculateSalary(String weight, String rate) {
        if (!weight.isEmpty() && !rate.isEmpty()) {
            return "" + Double.parseDouble(weight) * Double.parseDouble(rate);
        }
        else
            return "";
    }

    String getWeight(String newValue) {
        return newValue;
    }
}
