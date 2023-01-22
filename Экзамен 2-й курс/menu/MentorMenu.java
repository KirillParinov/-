package menu;


import domain.Group;
import domain.Mentor;
import repository.RepositoryMentor;
import service.Service;
import service.ServiceMentor;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class MentorMenu {
    LocalDate data = LocalDate.now();
    Scanner scanner = new Scanner(System.in);

    private final Service<Mentor> mentorService;

    private final Menu menu;
    private final GroupMenu groupMenu;

    public MentorMenu(Menu menu,GroupMenu groupMenu,Service<Mentor> mentorService) {
        this.menu=menu;
        this.groupMenu=groupMenu;
        this.mentorService=mentorService;
    }


    public void drawMentor() throws SQLException {
        System.out.println("--- Воспитатели ---");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("0. Назад");

        switch ( scanner.nextInt() ){
            case 1->{
                newMentor();
            }
            case 2->{
                deleteMentor();
            }
            case 3->{
                changeMentor();
            }
            case 0->{
                menu.draw();
            }
        }
    }
    public void newMentor() throws SQLException {
        System.out.println("Заполните данные:");
        System.out.print("1. Имя: ");   String name = scanner.next();
        System.out.print("2. Год рождения: ");  float age = data.getYear() - scanner.nextInt();
        System.out.print("3. Пол: ");   String pol = scanner.next();
        System.out.print("4. Зарплата: ");  int zp = scanner.nextInt();
        groupMenu.drawListGroup();
        System.out.print("5. Выберите группу: "); Long id_group = scanner.nextLong();

        Mentor mentor = new Mentor(null,name,age,pol,zp,id_group);
        mentorService.save(mentor);
    }
    public void deleteMentor() throws SQLException {
        drawListMentor();
        System.out.print("Выберите воспитателя которого хотите удалить: ");
        Mentor mentor = mentorService.find(scanner.nextLong());
        mentorService.delete(mentor);
    }
    public void changeMentor() throws SQLException {
        drawListMentor();
        System.out.print("Выберите воспитателя: ");
        Mentor mentor = mentorService.find(scanner.nextLong());

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
                    mentor.setName(scanner.next());
                }
                case 2 -> {
                    System.out.print("Введите новый год рождения: ");
                    mentor.setAge(data.getYear() - scanner.nextFloat());
                }
                case 3 -> {
                    System.out.print("Введите новый пол: ");
                    mentor.setPol(scanner.next());
                }
                case 4 -> {
                    System.out.println("Введите новую зарплату: ");
                    mentor.setZp(scanner.nextInt());
                }
                case 5 -> {
                    groupMenu.drawGroup();
                    System.out.println("Выберите новую группу: ");
                    mentor.setId_group(scanner.nextLong());
                }
                case 9 -> {
                    drawMentor();
                    q=1;
                }
                case 0 -> {
                    mentorService.update(mentor);
                    drawMentor();
                    q=1;
                }
            }


        }
    }

    public void drawListMentor() throws SQLException {
        System.out.println();
        System.out.println("--- Воспитатели ---");
        mentorService.list().forEach(System.out::println);
    }


}
