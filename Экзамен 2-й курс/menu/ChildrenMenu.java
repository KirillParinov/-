package menu;

import domain.Children;
import domain.Group;
import repository.RepositoryChildren;
import repository.RepositoryGroup;
import service.Service;
import service.ServiceChildren;
import service.ServiceGroup;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class ChildrenMenu {
    LocalDate data = LocalDate.now();
    Scanner scanner = new Scanner(System.in);

    private final Service<Children> childrenService;

    private final Menu menu;
    private final GroupMenu groupMenu;

    public ChildrenMenu(Menu menu,GroupMenu groupMenu, Service<Children> childrenService) {
        this.menu=menu;
        this.groupMenu=groupMenu;
        this.childrenService=childrenService;
    }

    public void drawChildren() throws SQLException {
        System.out.println("--- Дети ----");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("0. Назад");

        switch (scanner.nextInt()){
            case 1->{
                newChildren();
            }
            case 2->{
                deleteChildren();
            }
            case 3->{
                changeChildren();
            }
            case 0->{
                menu.draw();
            }
        }
    }
    private void newChildren() throws SQLException {
        System.out.println("Заполните данные: ");
        System.out.println("Имя: ");
        String name = scanner.next();
        System.out.println("Год рождения:");
        float age = data.getYear() - scanner.nextInt();
        System.out.println("Пол:");
        String pol = scanner.next();
        groupMenu.drawListGroup();
        System.out.println("Выберите группу:");
        Long id_group = scanner.nextLong();

        Children children = new Children(null,name,age,pol,id_group);
        childrenService.save(children);
    }
    private void deleteChildren() throws SQLException {
        drawListChildren();
        System.out.println("Выберите какого ребенка хотите удалить: ");
        Children children = childrenService.find(scanner.nextLong() );
        childrenService.delete(children);
    }
    private void changeChildren() throws SQLException {
        groupMenu.drawListGroup();
        System.out.print("Выберите группу:");
        Long id_group = scanner.nextLong();

        childrenService.getListPoIdGroup(id_group).forEach(System.out::println);
        System.out.print("Выберите ребенка: ");
        Long id_child = scanner.nextLong();

        Children children = childrenService.find(id_child);

        System.out.println( children );
        int q=0;

        while (q==0){
            System.out.println("Что хотите изменить?");
            System.out.println("1. Имя");
            System.out.println("2. Возраст");
            System.out.println("3. Пол");
            System.out.println("4. Группу");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            switch ( scanner.nextInt() ){
                case 1->{
                    System.out.print("Введите новое имя: "); children.setName( scanner.next() );
                }
                case 2->{
                    System.out.print("Введите новый год рождения: "); children.setAge( data.getYear() - scanner.nextFloat() );
                }
                case 3-> {
                    System.out.println("Введите новый пол: "); children.setPol( scanner.next() );
                }
                case 4->{
                    groupMenu.drawListGroup();
                    System.out.print("Выберите новую группу: "); children.setId_group(scanner.nextLong() );
                }
                case 9->{
                    drawChildren();
                    q=1;
                }
                case 0->{
                    childrenService.update(children);
                    menu.draw();
                    q=1;
                }
            }
        }
    }

    public void drawListChildren() throws SQLException {
        System.out.println();
        System.out.println("--- Дети ---");
        childrenService.list().forEach(System.out::println);
    }

}
