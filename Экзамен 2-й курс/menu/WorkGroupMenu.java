package menu;

import domain.Mentor;
import domain.WorkGroup;
import repository.RepositoryMentor;
import repository.RepositoryWorkGroup;
import service.Service;
import service.ServiceMentor;
import service.ServiceWorkGroup;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class WorkGroupMenu {

    Scanner scanner = new Scanner(System.in);


    private final Service<WorkGroup> workGroupService;
    private final Menu menu;

    public WorkGroupMenu(Menu menu,Service<WorkGroup> workGroupService) {
        this.menu=menu;
        this.workGroupService=workGroupService;
    }

    public void drawWork() throws SQLException {
        System.out.println("--- Рабочие места ---");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("0. Назад");

        switch (scanner.nextInt()){
            case 1->{
                newWork();
            }
            case 2->{
                deleteWork();
            }
            case 3->{
                changeWork();
            }
            case 0->{
                menu.draw();
            }
        }
    }

    public void newWork() throws SQLException {
        System.out.println("Заполните данные");
        System.out.print("Название: "); String name=scanner.next();
        WorkGroup workGroup = new WorkGroup(null,name);
        workGroupService.save(workGroup);
    }
    public void deleteWork() throws SQLException {
        drawListWork();
        System.out.print("Выберите рабочую профессия: ");
        WorkGroup workGroup = workGroupService.find( scanner.nextLong() );
        workGroupService.delete(workGroup);
    }
    public void changeWork() throws SQLException {
        drawListWork();
        System.out.print("Выберите рабочую профессия: ");
        WorkGroup workGroup = workGroupService.find(scanner.nextLong());

        int q = 0;

        while (q == 0) {

            System.out.println("Что хотите изменить?");
            System.out.println("1. Название");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.print("Ведите новое имя: ");
                    workGroup.setName(scanner.next());
                }
                case 9 -> {
                    drawWork();
                    q=1;
                }
                case 0 -> {
                    workGroupService.update(workGroup);
                    drawWork();
                    q=1;
                }
            }
        }
    }

    public void drawListWork() throws SQLException {
        System.out.println();
        System.out.println("--- Рабочие профессии ---");
        workGroupService.list().forEach(System.out::println);
    }


}
