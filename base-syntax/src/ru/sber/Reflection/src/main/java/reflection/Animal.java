package reflection;

public class Animal {
    public String type;
    protected String name;
    private double weight;

    public Animal(String type, String name, double weight) {
        this.type = type;
        this.name = name;
        this.weight = weight;
    }

    public String information() throws Exception {
        return String.format("Тип: %s; Имя: %s; Вес: %s;", type, name, weight);
    }

    private String weightInf() throws NullPointerException {
        return String.format("%s весит %s кг", name, weight);
    }

    private Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

}
