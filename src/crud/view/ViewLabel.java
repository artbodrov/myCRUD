package crud.view;

import crud.model.Label;
import crud.repo.LabelRepo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class ViewLabel {
    public void run() {
        boolean t = true;
        System.out.println("Добро пожаловать в Label!");
        int choice;
        String s;
        Scanner cs = new Scanner(System.in);

        while (t) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Выберете меню:");
            System.out.println("    1. Посмотреть список Label");
            System.out.println("    2. Создать новый Label");
            System.out.println("    3. Удалить Label");
            System.out.println("    4. Изменить Label");
            System.out.println("    0. Выход");

            choice = cs.nextInt();
            if (choice == 1) {
                try {

                    LabelRepo labelRepo = new LabelRepo();
                    labelRepo.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (choice == 2) {

                try {
                    Label label = new Label();
                    LabelRepo labelRepo = new LabelRepo();
                    System.out.println("Введите Label");
                    s = br.readLine();
                    label.setName(s);
                    labelRepo.create(label);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (choice == 3) {
                try {

                    LabelRepo labelRepo = new LabelRepo();
                    labelRepo.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (choice == 4) {
                try {

                    LabelRepo labelRepo = new LabelRepo();
                    labelRepo.change();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else if (choice == 0) {
                t = false;
            } else {
                System.out.println("!");
                System.out.println("!!");
                System.out.println("!!!");
                System.out.println("введите корректный номер меню!!!");
                System.out.println("!!!");
                System.out.println("!!");
                System.out.println("!");

            }
        }
    }
}

