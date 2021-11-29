package ss12_java_collection_framwork.demo_anh_quoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactService {
    private List<Contact> contacts= new ArrayList<>();
    private CSVHelper csvHelper= new CSVHelper();

    void save(Contact contact) {
        if(contact.getId()> 0){
            // edit
            int index= contacts.indexOf(contact);
            contacts.set(index, contact);
        }
        else {
            // add
            contact.setId(contacts.size() +1);
            contacts.add(contact);
        }

        csvHelper.write(contacts);
    }

    void delete(int id){
//        int size= contacts.size();
//        for (int i = 0; i < size; i++) {
//            if(id== contacts.get(i).getId()){
//                contacts.remove(i);
//                break;
//            }
//        }

        contacts.removeIf(e-> e.getId()== id);
    }

    List<Contact> getAll() {
        contacts= csvHelper.read();
        return contacts;
    }

    List<Contact> searchByName(String name){
        return contacts.stream().filter(e-> e.getName().contains(name)).collect(Collectors.toList());
    }

    List<Contact> sort(){
        Collections.sort(contacts, Comparator.comparing(Contact::getName));
        return contacts;
    }
}
