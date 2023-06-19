public class List {
    private ProfileList head;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public List() {
        this.head = null;
    }

    public void add(String name, String job, int age){
        ProfileList temp = new ProfileList(name, job, age);
        temp.setNext(head);
        head = temp;
        size++;
    }

    public String toString() {
        ProfileList temp = head;

        if (head == null) {
            size = -1;
            return "Очередь пуста";
        }

        String back = "Имя: " + temp.getName() + "\nРабота: " + temp.getJob() + "\nВозраст: " + temp.getAge() + "\n";
        head = temp.getNext();
        size--;

        if (head == null) {
            size = -1;
            return back + "\n\nОчередь закончилась";
        }
        return back;
    }
}