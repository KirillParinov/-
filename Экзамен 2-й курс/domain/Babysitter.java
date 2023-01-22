package domain;

public class Babysitter extends Person{

    private int zp;

    public Babysitter(Long id, String name, Float age, String pol,int zp, Long id_group) {
        super(id, name, age, pol, id_group);
        this.zp=zp;
    }

    public int getZp() {
        return zp;
    }

    public void setZp(int zp) {
        this.zp = zp;
    }

    @Override
    public String toString() {
        return "Babysitter{"+
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", pol='" + getPol() + '\'' +
                ", zp='" + zp + '\'' +
                ", id_group=" + getId_group() +
                '}';
    }
}
