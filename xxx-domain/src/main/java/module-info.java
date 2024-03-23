module com.domain {
	// exports -> 어떤 패키지를 노출할 것인가?
	// wisehero.domain을 노출하겠다. to All
	exports wisehero.domain;
	exports wisehero.domain.service;

	// api에만 공개하겠다.
	// exports wisehero.domain to com.api;

	// opens wisehero.domain;

	provides wisehero.domain.service.StringRepository with
			wisehero.domain.service.MemoryStringRepository,
			wisehero.domain.service.DatabaseStringRepository;
}
