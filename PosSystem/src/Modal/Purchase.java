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
public class Purchase {
    private String id;
    private String customerName;
    private String purchaseDetails;
    private String date;
    private String debit;
    private String credit;

    public Purchase(String id, String customerName, String purchaseDetails, String date, String debit, String credit) {
        this.id = id;
        this.customerName = customerName;
        this.purchaseDetails = purchaseDetails;
        this.date = date;
        this.debit = debit;
        this.credit = credit;
    }

    public String getCredit() {
        return credit;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDate() {
        return date;
    }

    public String getDebit() {
        return debit;
    }

    public String getId() {
        return id;
    }

    public String getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPurchaseDetails(String purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
