public class ProfileList {
    private String name;
    private String job;
    private int age;
    private ProfileList next;

    public ProfileList(String name, String job, int age) {
        this.name = name;
        this.job = job;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getAge() {
        return age;
    }

    public ProfileList getNext() {
        return next;
    }

    public void setNext(ProfileList next) {
        this.next = next;
    }
}