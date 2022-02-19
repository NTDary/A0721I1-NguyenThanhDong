package service;

import model.SandwichCondiments;

public class CondimentsService {
    SandwichCondiments sandwichCondiments = new SandwichCondiments();
    public void save(String [] condiments){
        sandwichCondiments.setCondiments(condiments);
    }
    public String[] showCondiments(){
        return sandwichCondiments.getCondiments();
    }
}
