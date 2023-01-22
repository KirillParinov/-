package menu;

import domain.Children;
import domain.Group;
import repository.RepositoryChildren;
import repository.RepositoryGroup;
import service.Service;
import service.ServiceChildren;
import service.ServiceGroup;

import java.sql.SQLException;
import java.util.Scanner;

public class GroupMenu {
    Scanner scanner = new Scanner(System.in);

    private final Service<Group> groupService;
    private final Menu menu;

    public GroupMenu(Menu menu,Service<Group> groupService) {
        this.menu=menu;
        this.groupService=groupService;
    }

    public void drawGroup() throws SQLException {
        System.out.println("--- Группы ---");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("4. Выйти");

        switch (scanner.nextInt()){
            case 1->{
                newGroup();
            }
            case 2->{
                deleteGroup();
            }
            case 3->{
                changeGroup();
            }
            case 0->{
                menu.draw();
            }
        }
    }

    public void drawListGroup() throws SQLException {
        System.out.println();
        System.out.println("--- Группы ---");
        groupService.list().forEach(System.out::println);
    }
    private void newGroup() throws SQLException {
        System.out.println("Заполните данные: ");
        System.out.println("Название: ");
        String name = scanner.next();

        groupService.save(new Group(null,name));
        
    }
    private void deleteGroup() throws SQLException {
        drawListGroup();
        System.out.print("Выберите группу которую хотите удалить: ");
        Group group = groupService.find( scanner.nextLong() );
        groupService.delete( group );
    }
    private void changeGroup() throws SQLException {
        drawListGroup();
        System.out.print("Выберите группу:");
        Group group = groupService.find(scanner.nextLong());

        System.out.println(group);
        int q = 0;
        while (q == 0) {

            System.out.println("Что хотите изменить?");
            System.out.println("1. Название");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.print("Введите новое название группы: ");
                    group.setName(scanner.next());
                }
                case 9 -> {
                    drawGroup();
                    q=1;
                }
                case 0 -> {
                    groupService.update(group);
                    q=1;
                }
            }
        }
    }

}
