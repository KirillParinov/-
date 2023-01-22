package domain;

public class Person {
    private Long id;
    private String name;
    private Float age;
    private String pol;
    private Long id_group;


    public Person(Long id, String name, Float age,String pol, Long id_group) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.pol=pol;
        this.id_group = id_group;
    }

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAge() {
        return age;
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public Long getId_group() {
        return id_group;
    }

    public void setId_group(Long id_group) {
        this.id_group = id_group;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", pol='" + pol + '\'' +
                ", id_group=" + id_group +
                '}';
    }
}