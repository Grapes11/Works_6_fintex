package com.company;

import java.io.*;
import java.util.Arrays;

public class WorksWithFile  {

    private static String[] contacts;
    private static int numberLines;
    private static String newLine = System.getProperty("line.separator");


    public static void loadFile () throws IOException  {

        File file = new File("phone_book.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int l = (int) file.length();
        bufferedReader.mark(l*8);
        numberLines=0;

        while((bufferedReader.readLine()) != null) {
            numberLines++;
        }

        bufferedReader.reset();
        contacts = new String[numberLines];

        for (int i=0; i<= numberLines-1; i++) {
            contacts[i]=bufferedReader.readLine();
        }

        bufferedReader.close();
    }

    public static void updateFile () throws IOException {

        FileWriter writer = new FileWriter("phone_book.txt", false);

            for (int i=0;i<=numberLines-1;i++) {
                String text = contacts[i];
                writer.write(text);
                writer.append('\n');
            }
            writer.flush();

    }


    public static void contactRecord () throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Введите ФИО и номер телефона контакта, который хотите добавить в телефонную книгу"
                        + newLine + "Если вы ввели все контакты, которые хотели, введите off");
                String contact = reader.readLine();
                if (contact.equals("off")) {
                    break;
                }
                else {
                    for (int i=0; i<=numberLines-1; i++){
                        if (contact.equals(contacts[i]))
                            throw (new MyException());
                    }
                    numberLines++;
                    contacts = Arrays.copyOf(contacts, numberLines);
                    contacts[numberLines - 1] = contact;
                }
            }

    }
    public static void viewContact (){
        for (int i=0; i<=numberLines-1; i++){
            System.out.println(contacts[i]);
        }
    }
}
