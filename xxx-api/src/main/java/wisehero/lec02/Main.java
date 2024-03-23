package wisehero.lec02;

import java.lang.reflect.Field;

import wisehero.domain.Lec02Person;

public class Main {
	public static void main(String[] args) throws Exception {
		Lec02Person p = new Lec02Person();

		Class<Lec02Person> personClass = Lec02Person.class;
		Field name = personClass.getDeclaredField("name");

		// Person의 private 필드 값을 조작할 수 있다.
		name.set(p, "ABC");
		System.out.println("name : " + p.getName());
	}
}
