package menu;

import domain.Mentor;
import domain.WorkGroup;
import domain.Worker;
import repository.RepositoryWorkGroup;
import repository.RepositoryWorker;
import service.Service;
import service.ServiceWorkGroup;
import service.ServiceWorker;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class WorkerMenu {
    LocalDate data = LocalDate.now();

    Scanner scanner = new Scanner(System.in);

    private final Service<Worker> workerService;
    private final Service<WorkGroup> workGroupService;

    private final Menu menu;
    private final WorkGroupMenu workGroupMenu;

    public WorkerMenu(Menu menu,WorkGroupMenu workGroupMenu,Service<Worker> workerService,Service<WorkGroup> workGroupService) {
        this.menu=menu;
        this.workGroupMenu=workGroupMenu;
        this.workerService=workerService;
        this.workGroupService=workGroupService;
    }


    public void drawWorker() throws SQLException {
        System.out.println("--- Рабочие ---");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("0. Назад");

        switch (scanner.nextInt()){
            case 1->{
                newWorker();
            }
            case 2->{
                deleteWorker();
            }
            case 3->{
                changeWorker();
            }
            case 0->{
                menu.draw();
            }
        }
    }

    public void newWorker() throws SQLException {
        System.out.println("Заполните данные:");
        System.out.println("Имя: ");    String name = scanner.next();
        System.out.println("Год рождения: ");   float age = data.getYear() - scanner.nextInt();
        System.out.println("Пол: ");    String pol = scanner.next();
        System.out.println("Зарплату: ");   int zp = scanner.nextInt();
        workGroupMenu.drawListWork();
        System.out.print("Выберите профессию: ");
        Long id_work = scanner.nextLong();
        WorkGroup workGroup = workGroupService.find(id_work);
        Worker worker = new Worker(null,id_work,name,age,pol,zp, workGroup.getName() );
        workerService.save(worker);
    }
    public void deleteWorker() throws SQLException {
        drawListWorker();
        System.out.print("Выберите работника: ");
        Long id_worker = scanner.nextLong();
        Worker worker = workerService.find(id_worker);
        workerService.delete(worker);
    }
    public void changeWorker() throws SQLException {
        drawListWorker();
        System.out.print("Выберите воспитателя: ");
        Worker worker = workerService.find(scanner.nextLong());

        int q = 0;
        while (q == 0) {

            System.out.println("Что хотите изменить?");
            System.out.println("1. Имя");
            System.out.println("2. Возраст");
            System.out.println("3. Пол");
            System.out.println("4. Зарплату");
            System.out.println("5. Профессию");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.print("Введите новое имя:");
                    worker.setName(scanner.next());
                }
                case 2 -> {
                    System.out.print("Введите новый год рождения: ");
                    worker.setAge(data.getYear() - scanner.nextFloat());
                }
                case 3 -> {
                    System.out.print("Введите новый пол: ");
                    worker.setPol(scanner.next());
                }
                case 4 -> {
                    System.out.println("Введите новую зарплату: ");
                    worker.setZp(scanner.nextInt());
                }
                case 5 -> {
                    workGroupMenu.drawListWork();
                    System.out.println("Выберите новую группу: ");
                    worker.setId_work(scanner.nextLong());
                }
                case 9 -> {
                    drawWorker();
                    q=1;
                }
                case 0 -> {
                    workerService.update(worker);
                    drawWorker();
                    q=1;
                }
            }
        }
    }

    public void drawListWorker() throws SQLException {
        System.out.println();
        System.out.println("--- Работники ---");
        workerService.list().forEach(System.out::println);
    }
}