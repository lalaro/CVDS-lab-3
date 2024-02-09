package edu.eci.cvds.tdd.registry;

import java.beans.Transient;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person();
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
    // TODO Complete with more test cases

    @Test
    public void validVote(){
        Person person1 = new Person("Astro", 12345, 4, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person1);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void notValidVote(){
        Person person1 = new Person("Astro", 12345, 4, Gender.MALE, true);
        Person person2 = new Person("Astro", 12345, 7, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person1);
        RegisterResult result1 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.DUPLICATED, result1);
    }

    @Test
    public void personDead(){
        Person person1 = new Person("Astro", 12345, 4, Gender.MALE, false);
        RegisterResult result1 = registry.registerVoter(person1);
        Assert.assertEquals(RegisterResult.DEAD, result1);
    }
}