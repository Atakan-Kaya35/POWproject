public class Person {
    static int counter = 0;
    int ID;
    String name;
    String adress;
    int age;
    int height;
    int weight;
    public Person(String name, String adress, int age, int height, int weight){
        counter++;
        this.ID = counter;
        this.name = name;
        this.adress = adress;
        this.age = age;
        this.weight = weight;
        this.weight = weight;
    }
}
