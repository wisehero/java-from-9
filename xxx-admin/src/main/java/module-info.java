module com.admin {
	requires com.domain; // 컴파일 + 런타임 의존성
	// requires static com.domain;  -> 컴파일 타임에만 접근
	// requires transitive com.domain; -> domain 모듈이 갖고있는 모듈도 호출 가능
}
