import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class studyClass {

    private final int age;
    private final String name;
    private final List<String> list;

    private studyClass(int age, String name) {
        this.age = age;
        this.name = name;
        this.list = new ArrayList<>();
    }

    public static studyClass of(int age, String name) {
        return new studyClass(age, name);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList(){
        return Collections.unmodifiableList(list);
    }

}


//불변클래스 만들기
//클래스를 final로
//클래스 변수를 private final로
//생성자 또는 정적 팩토리 메소드 추가
//참조에 의해 변경을 할떄는 방어저 복사를