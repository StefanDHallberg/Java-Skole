import com.mysql.cj.xdevapi.Table;
import java.lang.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        fileHandler fh = new fileHandler();
        SQLHandler sh = new SQLHandler(fh.returnOrderFile(), fh.returnKundeFile(), fh.returnVareFile(), fh.returnOrdrelinjeFile());
        sh.Sql();

    }
}