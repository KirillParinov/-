package menu;

import domain.Babysitter;
import repository.RepositoryBabysitter;
import service.Service;
import service.ServiceBabysitter;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class BabysitterMenu {
    LocalDate data = LocalDate.now();
    Scanner scanner = new Scanner(System.in);

    private final Service<Babysitter> babysitterService;

    private final GroupMenu groupMenu;
    private final Menu menu;

    public BabysitterMenu(Menu menu,GroupMenu groupMenu,Service<Babysitter> babysitterService) {
        this.menu=menu;
        this.groupMenu=groupMenu;
        this.babysitterService = babysitterService;
    }

    public void drawBabysitter() throws SQLException {
        System.out.println("--- Няни ---");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("0. Назад");

        switch ( scanner.nextInt() ){
         case 1->{
             newBabysitter();
         }
         case 2->{
             deleteBabysitter();
         }
         case 3->{
             changeBabysitter();
         }
         case 0->{
             menu.draw();
         }
        }
    }
    public void newBabysitter() throws SQLException {
        System.out.println("Заполните данные:");
        System.out.print("1. Имя: ");   String name = scanner.next();
        System.out.print("2. Год рождения: ");  float age = data.getYear() - scanner.nextInt();
        System.out.print("3. Пол: ");   String pol = scanner.next();
        System.out.print("4. Зарплата: ");  int zp = scanner.nextInt();
        groupMenu.drawListGroup();
        System.out.print("5. Выберите группу: "); Long id_group = scanner.nextLong();

        Babysitter babysitter = new Babysitter(null,name,age,pol,zp,id_group);
        babysitterService.save(babysitter);
    }
    public void deleteBabysitter() throws SQLException {
        drawListBebysitter();
        System.out.print("Выберите воспитателя которого хотите удалить: ");
        Babysitter babysitter = babysitterService.find(scanner.nextLong());
        babysitterService.delete(babysitter);
    }
    public void changeBabysitter() throws SQLException {
        drawListBebysitter();
        System.out.print("Выберите воспитателя: ");
        Babysitter babysitter = babysitterService.find(scanner.nextLong());
        int q = 0;
        while (q == 0) {

            System.out.println("Что хотите изменить?");
            System.out.println("1. Имя");
            System.out.println("2. Возраст");
            System.out.println("3. Пол");
            System.out.println("4. Зарплату");
            System.out.println("5. Отдел");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.print("Введите новое имя:");
                    babysitter.setName(scanner.next());
                }
                case 2 -> {
                    System.out.print("Введите новый год рождения: ");
                    babysitter.setAge(data.getYear() - scanner.nextFloat());
                }
                case 3 -> {
                    System.out.print("Введите новый пол: ");
                    babysitter.setPol(scanner.next());
                }
                case 4 -> {
                    System.out.println("Введите новую зарплату: ");
                    babysitter.setZp(scanner.nextInt());
                }
                case 5 -> {
                    groupMenu.drawGroup();
                    System.out.println("Выберите новую группу: ");
                    babysitter.setId_group(scanner.nextLong());
                }
                case 9 -> {
                    drawBabysitter();
                    q=1;
                }
                case 0 -> {
                    babysitterService.update(babysitter);
                    drawBabysitter();
                    q=1;
                }
            }
        }
    }
    public void drawListBebysitter() throws SQLException {
        System.out.println();
        System.out.println("--- Няни ---");
        babysitterService.list().forEach(System.out::println);
    }

}