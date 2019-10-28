package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String newLine = System.getProperty("line.separator");
        try{
             WorksWithFile.loadFile();
            label:
            while (true) {
                System.out.println("Нажмите v, чтобы просмотрет контакты,"+newLine
                        + "Нажмите r, чтобы добавить новый контакт"+ newLine
                        + "Чтобы закрыть приложение введите off");
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String text = reader.readLine();
                switch (text) {
                    case "v":
                        WorksWithFile.viewContact();
                        break;
                    case "r":
                        WorksWithFile.contactRecord();
                        break;
                    case "off":
                        break label;
                    default:
                        System.out.println("Такой команды нет");
                        break;
                }
            }

        } catch(Exception e){
            e.printStackTrace();
        } finally {
            WorksWithFile.updateFile();
        }
    }
}
