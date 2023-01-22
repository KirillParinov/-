package test;

import domain.*;
import menu.Menu;
import repository.*;
import service.*;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

        Repository<Group> groupRepository = new RepositoryGroup();
        Service<Group> groupService = new ServiceGroup(groupRepository);

        Repository<Children> childrenRepository = new RepositoryChildren();
        Service<Children> childrenService = new ServiceChildren(childrenRepository);

        Repository<Mentor> mentorRepository = new RepositoryMentor();
        Service<Mentor> mentorService = new ServiceMentor(mentorRepository);

        Repository<Babysitter> babysitterRepository = new RepositoryBabysitter();
        Service<Babysitter> babysitterService = new ServiceBabysitter(babysitterRepository);

        Repository<Worker> workerRepository = new RepositoryWorker();
        Service<Worker> workerService = new ServiceWorker(workerRepository);

        Repository<WorkGroup> workGroupRepository = new RepositoryWorkGroup();
        Service<WorkGroup> workGroupService = new ServiceWorkGroup(workGroupRepository);


        Menu menu = new Menu(groupService, childrenService, mentorService, babysitterService, workerService, workGroupService);

        while (true) {
            menu.draw();
        }


}
}