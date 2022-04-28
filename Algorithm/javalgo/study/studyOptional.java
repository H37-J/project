import java.util.ArrayList;
import java.util.Optional;

public class studyOptional {
    
    public static void main(String[] args){
        ArrayList<Persons> list = new ArrayList<>();
        Persons p = new Persons(14,"data");
        list.add(p);

        Optional<String> optional = Optional.ofNullable(p.getName());
        String name = optional.orElse("null");
        System.out.println(name);
        
        Optional<String> optional2 = Optional.ofNullable(p.getName());
        String result = optional2.orElseThrow().toUpperCase();
    }
}

class Persons{
    int age;
    String name;

    public Persons(){

    }

    public Persons(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public String getName(){
        return this.name;
    }
}
