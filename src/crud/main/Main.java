package crud.main;

import crud.repo.IoLabelRepo;
import crud.view.ViewLabel;
import crud.view.ViewPost;
import crud.view.ViewWriter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean t = true;
        System.out.println("Добро пожаловать в CRUD!");
        int choice;
        Scanner cs = new Scanner(System.in);

        while (t) {


            System.out.println("Выберете меню:");
            System.out.println("    1. Writer");
            System.out.println("    2. Post");
            System.out.println("    3. Label");
            System.out.println("    0. Выход");

            choice = cs.nextInt();
            if (choice == 1) {
                ViewWriter viewWriter = new ViewWriter();
                viewWriter.run();

            } else if (choice == 2) {
                ViewPost viewPost = new ViewPost();
                viewPost.run();

            } else if (choice == 3) {
                ViewLabel viewLabel = new ViewLabel();
                viewLabel.run();
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