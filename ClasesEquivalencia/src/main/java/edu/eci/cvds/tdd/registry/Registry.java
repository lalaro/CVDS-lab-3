package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {
    private ArrayList<Person> personR = new ArrayList<>();


    public RegisterResult registerVoter(Person p) {
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }
    
        if(p.getAge()<=18){
            return RegisterResult.INVALID_AGE;
        }

        for (Person pe : personR) {
            if (pe.getId() == p.getId()) {
                return RegisterResult.DUPLICATED;
            }
        }
    
        personR.add(p);
        return RegisterResult.VALID;
    }
    
    

}