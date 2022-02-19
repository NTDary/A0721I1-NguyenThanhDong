package repository;

import model.SimpleDictionary;

import java.util.HashMap;

public class SimpleDictionaryRepository {
    SimpleDictionary simpleDictionary = new SimpleDictionary();
    public HashMap<String, String> dictonaryLibrary(){
        HashMap<String, String> map = new HashMap<>();
        map.put("shool","truong");
        map.put("dog","cho");
        map.put("visible","ro rang");
        map.put("pen","but");
        return map;
    }
}
