public class Person {
    static int counter = 0;
    int ID;
    String name;
    String adress;
    int age;
    int height;
    int weight;
    String occupation;
    public Person(String name, String adress, int age, int height, int weight, String occupation){
        counter++;
        this.ID = counter;
        this.name = name;
        this.adress = adress;
        this.age = age;
        this.weight = weight;
        this.weight = weight;
        this.occupation = occupation;
    }
}
