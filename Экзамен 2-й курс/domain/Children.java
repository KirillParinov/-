package domain;

public class Children extends Person {


    public Children(Long id, String name, Float age, String pol, Long id_group) {
        super(id, name, age, pol, id_group);
    }

    @Override
    public String toString() {
        return "Children{"+
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", pol='" + getPol() + '\'' +
                '}';
    }

}
