public class Main {
    public static void main(String[] args) {
        List list = new List();

        list.add("Даниил", "Пожарный", 25);
        list.add("Александр", "Полицейский", 22);
        list.add("Артём", "Повар", 27);
        list.add("Евгений", "Инженер", 38);
        list.add("Владислав", "Бармен", 18);
        list.add("Илья", "Строитель", 26);

        while (list.getSize() >= 0){
            System.out.println(list.toString());
        }
    }
}