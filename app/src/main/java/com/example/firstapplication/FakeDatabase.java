package com.example.firstapplication;

import java.util.ArrayList;
import java.util.List;

public class FakeDatabase {

    private List<Notes> listOfNotes = new ArrayList<>();

    public FakeDatabase() {

        listOfNotes.add(new Notes("Note1", "The Arch of Remembrance is a First World War memorial designed by Sir Edwin Lutyens and located in Victoria Park, Leicester, in the East Midlands of England. A committee was \n formed in 1919 to propose a permanent memorial, and the first proposal was accepted, but eventually cancelled due to a shortage of funds. \nThe committee then asked for a memorial arch, which Lutyens presented to a public meeting in 1923.","12.02.2020"));
        listOfNotes.add(new Notes("Note2", "Steven Paul Jobs (/dʒɒbz/; February 24, 1955 – October 5, 2011) was an American business magnate, industrial designer, investor, and media proprietor","12.02.2020"));
        listOfNotes.add(new Notes("Note3", "Jobs was born in San Francisco,","12.02.2020"));
        listOfNotes.add(new Notes("Note4", "Ayxan Ustaya Hürmetler","12.02.2020"));
        listOfNotes.add(new Notes("Note5", "Jobs and Wozniak co-founded Apple in 1976 to sell Wozniak's Apple I personal computer","12.02.2020"));
        listOfNotes.add(new Notes("Note6", "Android Studioda Ilk app. BABAAT","12.02.2020"));
        listOfNotes.add(new Notes("Note7", "Apple acquired NeXT in 1997, and Jobs became CEO of his former company within a few months. He was largely responsible for helping revive Apple, which had been at the verge of bankruptcy.","12.02.2020"));
        listOfNotes.add(new Notes("Note8", "His biological father, Abdulfattah John (al-)Jandali (Arabic: عبد الفتاح الجندلي) (b. 1931), grew up in Homs, Syria, and was born into an Arab Muslim household.[4] While an undergraduate at the American University of Beirut, Lebanon, he was a student activist and spent time in prison for his political activities.[4] He pursued a PhD at the University of Wisconsin, where he met Joanne Carole Schieble, a Catholic of Swiss and German descent.[4][5] As a doctoral candidate, Jandali was a teaching assistant for a course Schieble was taking, although both were the same age.","12.02.2020"));
        listOfNotes.add(new Notes("Note9", "The Last Words to say","12.02.2020"));
        listOfNotes.add(new Notes("Note1", "The Arch of Remembrance is a First World War memorial designed by Sir Edwin Lutyens and located in Victoria Park, Leicester, in the East Midlands of England. A committee was \n formed in 1919 to propose a permanent memorial, and the first proposal was accepted, but eventually cancelled due to a shortage of funds. \nThe committee then asked for a memorial arch, which Lutyens presented to a public meeting in 1923.","12.02.2020"));
        listOfNotes.add(new Notes("Note2", "Steven Paul Jobs (/dʒɒbz/; February 24, 1955 – October 5, 2011) was an American business magnate, industrial designer, investor, and media proprietor","12.02.2020"));
        listOfNotes.add(new Notes("Note3", "Jobs was born in San Francisco,","12.02.2020"));
        listOfNotes.add(new Notes("Note4", "Ayxan Ustaya Hürmetler","12.02.2020"));
        listOfNotes.add(new Notes("Note5", "Jobs and Wozniak co-founded Apple in 1976 to sell Wozniak's Apple I personal computer","12.02.2020"));
        listOfNotes.add(new Notes("Note6", "Android Studioda Ilk app. BABAAT","12.02.2020"));
        listOfNotes.add(new Notes("Note7", "Apple acquired NeXT in 1997, and Jobs became CEO of his former company within a few months. He was largely responsible for helping revive Apple, which had been at the verge of bankruptcy.","12.02.2020"));
        listOfNotes.add(new Notes("Note8", "His biological father, Abdulfattah John (al-)Jandali (Arabic: عبد الفتاح الجندلي) (b. 1931), grew up in Homs, Syria, and was born into an Arab Muslim household.[4] While an undergraduate at the American University of Beirut, Lebanon, he was a student activist and spent time in prison for his political activities.[4] He pursued a PhD at the University of Wisconsin, where he met Joanne Carole Schieble, a Catholic of Swiss and German descent.[4][5] As a doctoral candidate, Jandali was a teaching assistant for a course Schieble was taking, although both were the same age.","12.02.2020"));
        listOfNotes.add(new Notes("Note9", "The Last Words to say","12.02.2020"));
    }

    public List<Notes> getListOfNotes() {
        return listOfNotes;
    }
}
