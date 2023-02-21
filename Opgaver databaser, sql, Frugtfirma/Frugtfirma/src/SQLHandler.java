import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLHandler {
    String connectString = "jdbc:mysql://127.0.0.1:3306/Frugtfirma";
    String userName = "root";
    String passWord = "f4nt45y7";

    List<String> ordredata, kundedata, ordrelinjedata, varedata;
    public SQLHandler(List<String> ordredata, List<String> kundedata, List<String> varedata, List<String>  ordrelinjedata){
        this.ordredata = ordredata;
        this.kundedata = kundedata;
        this.ordrelinjedata = ordrelinjedata;
        this.varedata = varedata;
    }
    public void Sql (){
    String  kundeTable = "CREATE TABLE kunde (KundeID VARCHAR(45) not NULL PRIMARY KEY," +
            "Navn VARCHAR(45)," +
            "Adr VARCHAR(45)," +
            "Landekode VARCHAR(45)," +
            "Salgsmaal INTEGER)";
    String ordreTable = "CREATE TABLE ordre (OrdreID INTEGER not NULL PRIMARY KEY," +
            "KundeID VARCHAR(45)," +
            "Dato VARCHAR(45)," +
            "Fragt DOUBLE)";
    String  ordrelinjeTable = "CREATE TABLE ordrelinje (LinieID INTEGER not NULL PRIMARY KEY," +
            "OrdreID INTEGER," +
            "VareNr VARCHAR(45)," +
            "Subtotal DOUBLE)";
    String  vareTable = "CREATE TABLE vare (VareNr VARCHAR(45) not NULL PRIMARY KEY," +
            "Navn VARCHAR(45)," +
            "ListePris DOUBLE)";
    String dropTable = "DROP TABLE IF EXISTS kunde , ordrelinje, ordre, vare";

    String ordredataTable = "INSERT INTO ORDRE (OrdreID,KundeID,Dato,Fragt)" +
            "VALUES (?,?,?,?)";
    String kundedataTable = "INSERT INTO KUNDE (KundeID,Navn,Adr,Landekode,Salgsmaal)" +
            "VALUES (?,?,?,?,?)";
    String ordrelinjedataTable = "INSERT INTO ORDRELINJE (LinieID,OrdreID,VareNr,Subtotal)" +
            "VALUES (?,?,?,?)";
    String varedataTable = "INSERT INTO VARE (VareNr,Navn,ListePris)" +
            "VALUES (?,?,?)";

        try (Connection connection = DriverManager.getConnection(connectString, userName, passWord)) {
            System.out.println("Database connected!");
            DropTable(connection, dropTable, kundeTable, vareTable, ordreTable, ordrelinjeTable);
            for (int i = 0; i < ordredata.size(); i++)
            {
                PreparedStatement preparedStmt = connection.prepareStatement(ordredataTable);
                String[] sizeMatters = ordredata.get(i).split(",");
                preparedStmt.setString(1, sizeMatters[0]);
                preparedStmt.setString(2, sizeMatters[1]);
                preparedStmt.setString(3, sizeMatters[2]);
                preparedStmt.setDouble(4, Double.parseDouble(sizeMatters[3]));
                preparedStmt.executeUpdate();

                System.out.println("Ordre 66 executed");
            }
            for (int i = 0; i < kundedata.size(); i++)
            {
                PreparedStatement preparedStmt = connection.prepareStatement(kundedataTable);
                String[] sizeMatters = kundedata.get(i).split(",");
                preparedStmt.setString(1, sizeMatters[0]);
                preparedStmt.setString(2, sizeMatters[1]);
                preparedStmt.setString(3, sizeMatters[2]);
                preparedStmt.setString(4, sizeMatters[3]);
                if (sizeMatters[4].equals("NULL"))
                {
                    sizeMatters[4] = "0";
                }
                preparedStmt.setInt(5, Integer.parseInt(sizeMatters[4]));
                preparedStmt.executeUpdate();
                System.out.println("kunde 99 executed");
            }
            for (int i = 0; i < varedata.size(); i++)
            {
                PreparedStatement preparedStmt = connection.prepareStatement(varedataTable);
                String[] sizeMatters = varedata.get(i).split(",");
                preparedStmt.setString(1, sizeMatters[0].toString());
                preparedStmt.setString(2, sizeMatters[1].toString());
                preparedStmt.setDouble(3, Double.parseDouble(sizeMatters[2]));
                preparedStmt.executeUpdate();

                System.out.println("vare ;)) executed");
            }
            for (int i = 0; i < ordrelinjedata.size(); i++)
            {
                PreparedStatement preparedStmt = connection.prepareStatement(ordrelinjedataTable);
                String[] sizeMatters = ordrelinjedata.get(i).split(",");
                preparedStmt.setInt(1, Integer.parseInt(sizeMatters[0]));
                System.out.println("1 ");
                preparedStmt.setInt(2, Integer.parseInt(sizeMatters[1]));
                System.out.println("2 ");
                preparedStmt.setString(3, sizeMatters[2]);
                System.out.println("3 ");
                preparedStmt.setDouble(4, Double.parseDouble(sizeMatters[3]));
                System.out.println("4 ");
                preparedStmt.executeUpdate();
                System.out.println("Ordrelinje Screw you guys, I'm going hoome");
            }
//            stmt.executeUpdate(kundeTable.toString());
//            stmt.executeUpdate(ordreTable.toString());
//            stmt.executeUpdate(ordrelinjeTable.toString());
//            stmt.executeUpdate(vareTable.toString());
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
    public void DropTable(Connection connection, String dropTable, String kundeTable, String vareTable, String ordreTable, String ordrelinjeTable)
    {
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(dropTable);
            preparedStmt.execute();
            preparedStmt = connection.prepareStatement(kundeTable);
            preparedStmt.execute();
            preparedStmt = connection.prepareStatement(ordreTable);
            preparedStmt.execute();
            preparedStmt = connection.prepareStatement(vareTable);
            preparedStmt.execute();
            preparedStmt = connection.prepareStatement(ordrelinjeTable);
            preparedStmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
