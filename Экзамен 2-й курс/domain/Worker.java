package domain;

public class Worker {
    private Long id;
    private Long id_work;
    private String name;
    private Float age;
    private String pol;
    private int zp;
    String prof;

    public Worker(Long id, Long id_work, String name, Float age, String pol, int zp, String prof) {
        this.id = id;
        this.id_work = id_work;
        this.name = name;
        this.age = age;
        this.pol = pol;
        this.zp = zp;
        this.prof=prof;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_work() {
        return id_work;
    }

    public void setId_work(Long id_work) {
        this.id_work = id_work;
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

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public int getZp() {
        return zp;
    }

    public void setZp(int zp) {
        this.zp = zp;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", id_work=" + id_work +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", pol='" + pol + '\'' +
                ", zp=" + zp +
                '}';
    }
}
