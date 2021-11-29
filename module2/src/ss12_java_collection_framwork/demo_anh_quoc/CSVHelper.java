package ss12_java_collection_framwork.demo_anh_quoc;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {
    private static final String path= "src/ss12_java_collection_framwork/demo_anh_quoc/contact.csv";

    List<Contact> read() {
        List<Contact> res= new ArrayList<>();

        try{
            File file= new File(path);
            if(!file.exists())
                file.createNewFile();

            BufferedReader bufferedReader= new BufferedReader(new FileReader(path));
            String line;

            while ( (line= bufferedReader.readLine()) != null){
                String[] tmp= line.split(",");
                Contact contact= new Contact(Integer.parseInt(tmp[0]), tmp[1], tmp[2]);
                res.add(contact);
            }

            bufferedReader.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return res;
    }

    void write(List<Contact> contacts) {
        try(BufferedWriter bufferedWriter= new BufferedWriter(new FileWriter(path))) {
            for (Contact contact : contacts){
                bufferedWriter.write(String.format("%s,%s,%s", contact.getId(), contact.getName(), contact.getDescription()));
                bufferedWriter.newLine();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
