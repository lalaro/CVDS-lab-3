package edu.eci.cvds.tdd.registry;

import java.beans.Transient;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    private Person person;
    private Person person6;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;
    private RegisterResult result,result1,result2,result3,result4,result5, result6;

    @Test
    public void validateRegistryResult() {
        person = new Person("Astro",12345,20,Gender.FEMALE,true);
        RegisterResult result1 = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result1);
    }
    
    @Test
    public void validVote() {
        person1 = new Person("Astro", 12345, 19, Gender.MALE, true);
        RegisterResult result2 = registry.registerVoter(person1);
        Assert.assertEquals(RegisterResult.VALID, result2);
    }
    
    @Test
    public void notValidVote() {
        person2 = new Person("Astro", 12345, 20, Gender.MALE, true);
        person3 = new Person("Astro", 12345, 24, Gender.FEMALE, true);
        RegisterResult result3 = registry.registerVoter(person2);
        RegisterResult result4 = registry.registerVoter(person3);
        Assert.assertEquals(RegisterResult.DUPLICATED, result4);
    }
    
    @Test
    public void personDead() {
        person4 = new Person("MeQuieroMatar", 12, 18, Gender.MALE, false);
        RegisterResult result5 = registry.registerVoter(person4);
        Assert.assertEquals(RegisterResult.DEAD, result5);
    }
    
    @Test
    public void invalidAge() {
        person6 = new Person("MeQuieroMatarAunMas", 123423423, 4, Gender.MALE, true);
        RegisterResult result6 = registry.registerVoter(person6);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result6); 
    }
    
}