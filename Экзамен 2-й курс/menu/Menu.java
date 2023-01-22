package menu;

import domain.*;
import service.Service;
import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;


public class Menu {

    Scanner scanner = new Scanner(System.in);

    private final GroupMenu groupMenu;
    private final ChildrenMenu childrenMenu ;
    private final MentorMenu mentorMenu;
    private final BabysitterMenu babysitterMenu;
    private final WorkGroupMenu workGroupMenu;
    private final WorkerMenu workerMenu;

    private final Service<Group> groupService;
    private final Service<Children> childrenService;
    private final Service<Mentor> mentorService;
    private final Service<Babysitter> babysitterService;
    private final Service<Worker> workerService;
    private final  Service<WorkGroup> workGroupService;


    public Menu(Service<Group> groupService, Service<Children> childrenService, Service<Mentor> mentorService, Service<Babysitter> babysitterService, Service<Worker> workerService, Service<WorkGroup> workGroupService) {
        this.groupService = groupService;
        this.childrenService = childrenService;
        this.mentorService = mentorService;
        this.babysitterService = babysitterService;
        this.workerService = workerService;
        this.workGroupService = workGroupService;
        this.groupMenu=new GroupMenu(this,groupService);
        this.mentorMenu=new MentorMenu(this,groupMenu,mentorService);
        this.babysitterMenu=new BabysitterMenu(this,groupMenu,babysitterService);
        this.childrenMenu=new ChildrenMenu(this,groupMenu,childrenService);
        this.workGroupMenu=new WorkGroupMenu(this,workGroupService);
        this.workerMenu=new WorkerMenu(this,workGroupMenu,workerService,workGroupService);
    }

    public void draw() throws SQLException {
        System.out.println("------ MENU ------");

        System.out.println("1. Дети");
        System.out.println("2. Группы");
        System.out.println("3. Воспитатели");
        System.out.println("4. Нани");
        System.out.println("5. Работники");
        System.out.println("6. Списки");
        System.out.println("9. Выход");

        execute();
    }

    private void execute() throws SQLException {
        int command = scanner.nextInt();

        switch (command) {
            case 1 -> {
                childrenMenu.drawChildren();
            }
            case 2->{
                groupMenu.drawGroup();
            }
            case 3->{
                mentorMenu.drawMentor();
            }
            case 4->{
                babysitterMenu.drawBabysitter();
            }
            case 5->{
                System.out.println("--- Работники ---");
                System.out.println("1. Работники");
                System.out.println("2. Рабочие профессии");
                System.out.println("0. Назад");

                switch (scanner.nextInt()){
                    case 1->{
                        workerMenu.drawWorker();
                    }
                    case 2->{
                        workGroupMenu.drawWork();
                    }
                    case 0->{
                        draw();
                    }
                }
            }
            case 6->{
                drawLists();
            }
            case 9 -> System.exit(0);
            default -> throw new IllegalArgumentException("No command found");
        }
    }

    private void drawLists() throws SQLException {
        System.out.println("--- Списки ---");

        System.out.println("1. Вывести всех детей ");
        System.out.println("2. Вывести всех воспитателей ");
        System.out.println("3. Вывести всех нянь ");
        System.out.println("4. Вывести всех работников ");
        System.out.println("5. Вывести группы с детьми, воспитателями и нянями");

        System.out.println("0. Назад в меню");
        int d= scanner.nextInt();

        switch (d){
            case 1 -> {
                childrenMenu.drawListChildren();
            }
            case 2->{
                mentorMenu.drawListMentor();
            }
            case 3->{
                babysitterMenu.drawListBebysitter();
            }
            case 4->{
                workerMenu.drawListWorker();
            }
            case 5->{
                drawListPoGroup();
            }
            case 0-> draw();
        }
    }
    private void drawListPoGroup() throws SQLException {
        List<Group> list = groupService.list();

        for (Group d: list) {
            System.out.println("--- Группа ---");
            System.out.println(d.getName());
            System.out.println("--- Воспитатели ---");
            mentorService.getListPoIdGroup(d.getId()).forEach(System.out::println);
            System.out.println("--- Няни ---");
            babysitterService.getListPoIdGroup(d.getId()).forEach(System.out::println);
            System.out.println("--- Дети ---");
            childrenService.getListPoIdGroup(d.getId());
        }

    }

}