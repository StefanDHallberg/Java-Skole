import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fileHandler {
    String kundeFil = "C:\\Users\\Fugl\\Desktop\\Databaser 2. semester-20230203\\Opgaver databaser, sql, Frugtfirma\\Tekstfiler\\Kunde.txt";
    String ordreFil = "Ordre.txt";
    String odrelinjeFil = "C:\\Users\\Fugl\\Desktop\\Databaser 2. semester-20230203\\Opgaver databaser, sql, Frugtfirma\\Tekstfiler\\Ordrelinie.txt";
    String vareFil = "C:\\Users\\Fugl\\Desktop\\Databaser 2. semester-20230203\\Opgaver databaser, sql, Frugtfirma\\Tekstfiler\\Vare.txt";

    public List<String> returnOrderFile(){
        List<String> Converter = new ArrayList<>();
        int i = 0;
        try {
        File myObj = new File(ordreFil);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            if (i == 0){
                String data = myReader.nextLine();
            }
            if (i > 0){
                String data = myReader.nextLine();
            Converter.add(data);
            }
            i++;
        }
        myReader.close();
        System.out.println(Converter.get(0));
        } catch(Exception c){
            System.out.println(c);
        }
    return Converter;
    }
    public List<String> returnKundeFile(){
        int i = 0;
        List<String> Converter = new ArrayList<>();

        try {
            File myObj = new File(kundeFil);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                if (i == 0){
                    String data = myReader.nextLine();
                }
                if (i > 0){
                    String data = myReader.nextLine();
                    Converter.add(data);
                }
                i++;
            }
            myReader.close();
            System.out.println(Converter.get(0));
        } catch(Exception c){
            System.out.println(c);
        }
        return Converter;
    }
    public List<String> returnOrdrelinjeFile(){
        int i = 0;
        List<String> Converter = new ArrayList<>();
        try {
            File myObj = new File(odrelinjeFil);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                if (i == 0){
                    String data = myReader.nextLine();
                }
                if (i > 0){
                    String data = myReader.nextLine();
                    Converter.add(data);
                }
                i++;
            }
            myReader.close();
            System.out.println(Converter.get(0));
        } catch(Exception c){
            System.out.println(c);
        }
        return Converter;
    }
    public List<String> returnVareFile(){
        int i = 0;
        List<String> Converter = new ArrayList<>();
        try {
            File myObj = new File(vareFil);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                if (i == 0){
                    String data = myReader.nextLine();
                }
                if (i > 0){
                    String data = myReader.nextLine();
                    Converter.add(data);
                }
                i++;
            }
            myReader.close();
            System.out.println(Converter.get(0));
        } catch(Exception c){
            System.out.println(c);
        }
        return Converter;
    }
}
