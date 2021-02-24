package com.srikanth.functional.Functions;

import com.srikanth.functional.Functions.interfaces.NoArgFunction;

public class D_FunctionAsData {

    // Trying to demo how functions change the behaviour dynamically. Say, customized behaviour per environment
    // Scenario below is to demo loading person data from server

    // Person class
    protected static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    // Data loader class
    protected static class DataLoader {

        // We don't want to worry about choosing which method we want to use.
        // So use a NoArg function we created previously

        // NoArgFunction returning Person - Remember Generic type is return type
        public final NoArgFunction<Person> loadPerson;

        // Intialize based on the environment type
        public DataLoader(boolean isDevelopment) {
            this.loadPerson = isDevelopment
                    ? this::loadPersonFake
                    : this::loadPersonReal;
        }

        // Run this method on Prod env
        private Person loadPersonReal() {
            System.out.println("Loading person...");
            return new Person("Real Person", 29);
        }

        // Run this method in Dev env
        private Person loadPersonFake() {
            System.out.println("Returning fake person object...");
            return new Person("Fake Person", 100);
        }
    }

    public static void main(String[] args) {
        Boolean IS_DEVELOPMENT = true;

        DataLoader dataLoader = new DataLoader(IS_DEVELOPMENT);
        System.out.println(dataLoader.loadPerson.apply());

        IS_DEVELOPMENT = false;
        dataLoader = new DataLoader(IS_DEVELOPMENT);
        System.out.println(dataLoader.loadPerson.apply());
    }
}
