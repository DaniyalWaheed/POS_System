/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modal;

import com.healthmarketscience.jackcess.ColumnBuilder;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Table;
import com.healthmarketscience.jackcess.TableBuilder;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
/**
 *
 * @author daniy
 */
public class DatabaseCreation {
    
    private static Database createDatabase(String databaseName) throws IOException {
        return DatabaseBuilder.create(Database.FileFormat.V2000,new File(databaseName));
    }

    private static TableBuilder createTable(String tableName) {
        return new TableBuilder(tableName);
    }

    public static void addColumn(Database database, TableBuilder tableName, String columnName, Types sqlType) throws SQLException, IOException {
        tableName.addColumn(new ColumnBuilder(columnName).setSQLType(Types.INTEGER).toColumn()).toTable(database);
    }

    public static void startDatabaseProcess() throws IOException, SQLException {
        String databaseName = "D:\\PosSystem/posDb.accdb"; // Creating an MS Access database
        Database database = createDatabase(databaseName);

        String contractWorker = "ContractWorker";
        String dailyWages = "DailyWages";
        String normalWorker = "NormalWorker";
        String products = "Products";
        String purchase = "Purchase";
        String sales = "Sales";
        String stock = "Stock";
        String user = "User";

// Creating table
        Table table1 = createTable(contractWorker)
                .addColumn(new ColumnBuilder("ID").setSQLType(Types.INTEGER).toColumn())
                .addColumn(new ColumnBuilder("Name").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("ContractPeriod").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Date").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("PhoneNumber").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Amount").setSQLType(Types.INTEGER).toColumn())
                .toTable(database);
        
        Table table2 = createTable(dailyWages)
                .addColumn(new ColumnBuilder("ID").setSQLType(Types.INTEGER).toColumn())
                .addColumn(new ColumnBuilder("Name").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Date").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Amount").setSQLType(Types.INTEGER).toColumn())
                .toTable(database);
        
        Table table3 = createTable(normalWorker)
                .addColumn(new ColumnBuilder("ID").setSQLType(Types.INTEGER).toColumn())
                .addColumn(new ColumnBuilder("Name").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Date").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("PhoneNumber").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Salary").setSQLType(Types.INTEGER).toColumn())
                .toTable(database);
        
        Table table4 = createTable(products)
                .addColumn(new ColumnBuilder("ID").setSQLType(Types.INTEGER).toColumn())
                .addColumn(new ColumnBuilder("ProductName").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Volume").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Rate").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Quantity").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Amount").setSQLType(Types.VARCHAR).toColumn())
                .toTable(database);
        
        Table table5 = createTable(purchase)
                .addColumn(new ColumnBuilder("ID").setSQLType(Types.INTEGER).toColumn())
                .addColumn(new ColumnBuilder("CustomerName").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("PurchaseDetails").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Date").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Debit").setSQLType(Types.INTEGER).toColumn())
                .addColumn(new ColumnBuilder("Credit").setSQLType(Types.INTEGER).toColumn())
                .toTable(database);
        
        Table table6 = createTable(sales)
                .addColumn(new ColumnBuilder("ID").setSQLType(Types.INTEGER).toColumn())
                .addColumn(new ColumnBuilder("CustomerName").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("SalesDetails").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Date").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Debit").setSQLType(Types.INTEGER).toColumn())
                .addColumn(new ColumnBuilder("Credit").setSQLType(Types.INTEGER).toColumn())
                .toTable(database);
        
        Table table7 = createTable(stock)
                .addColumn(new ColumnBuilder("ProductName").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("Quantity").setSQLType(Types.INTEGER).toColumn())
                .addColumn(new ColumnBuilder("Rate").setSQLType(Types.INTEGER).toColumn())
                .addColumn(new ColumnBuilder("Volume").setSQLType(Types.INTEGER).toColumn())
                .addColumn(new ColumnBuilder("Amount").setSQLType(Types.INTEGER).toColumn())
                .toTable(database);
        
        Table table8 = createTable(user)
                .addColumn(new ColumnBuilder("userName").setSQLType(Types.VARCHAR).toColumn())
                .addColumn(new ColumnBuilder("password").setSQLType(Types.VARCHAR).toColumn())
                .toTable(database);
        
        
        table8.addRow("admin", "1234");//Inserting values into the table
    }
    
}
