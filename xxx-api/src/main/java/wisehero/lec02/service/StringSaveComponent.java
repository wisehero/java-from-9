package wisehero.lec02.service;

import wisehero.domain.service.StringRepository;

public class StringSaveComponent {

	private final StringRepository stringRepository = StringRepositoryLoader.getDefault();

	public static void main(String[] args) {
		StringSaveComponent component = new StringSaveComponent();
		component.mainLogin();
	}

	public void mainLogin() {
		stringRepository.save("문자열");
	}
}
