package b.udacity.reshu.javalib;

import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class myClass {

    List<String> list = asList(
            "Q. This Is Why You Should Hug Your Programmer\n" +    "Ans - A person who fixed a problem that you don't you have, in a way you don't understand.",
            "Q. What is algorithm?\n" + "Ans - Word used by programmers when they do not want to explain what they did.",
            "Q. What is hardware?\n" + "Ans - The part of a computer that you can kick.",
            "Q. What is the object oriented way to get wealthy?\n" + "Ans - Inheritance.",
            "Q. What do you call a programmer from Finland?\n" + "Ans - Nerdic.",
            "Q. What is the programmer's favourite hangout Place?\n" + "Ans - Foo Bar.",
            "Q. Why did the programmer quit his job?\n" + "Ans - Because he didn't get array."

    );


    public String getRandomJoke(){
        Random random = new Random();

        String randomJoke = list.get(random.nextInt(list.size()));
        return randomJoke;
    }


    }


