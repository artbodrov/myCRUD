package crud.view;

import crud.model.Label;
import crud.repo.IoLabelRepo;
import crud.repo.LabelRepository;

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
        int id;
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
                    LabelRepository ioLabelRepo = new IoLabelRepo();
                    ioLabelRepo.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (choice == 2) {

                try {
                    Label label = new Label();
                    LabelRepository ioLabelRepo = new IoLabelRepo();
                    System.out.println("Введите Label");
                    s = br.readLine();
                    label.setName(s);
                    ioLabelRepo.create(label);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (choice == 3) {
                try {
                    LabelRepository labelRepo = new IoLabelRepo();
                    System.out.println("Введите номер Label который хотите удалить");
                    id = cs.nextInt();
                    labelRepo.delete(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (choice == 4) {
                try {


                    LabelRepository ioLabelRepo = new IoLabelRepo();
                    System.out.println("Введите номер Label который хотите изменить");

                    ioLabelRepo.update();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (choice == 0) {
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

