package org.springframework.beans.factory.parsing;

import org.springframework.core.io.Resource;

public class ReaderContext {
	
	private final Resource resource;

	private final ProblemReporter problemReporter;

	private final ReaderEventListener eventListener;

	private final SourceExtractor sourceExtractor;


	public ReaderContext(Resource resource, ProblemReporter problemReporter,
			ReaderEventListener eventListener, SourceExtractor sourceExtractor) {

		this.resource = resource;
		this.problemReporter = problemReporter;
		this.eventListener = eventListener;
		this.sourceExtractor = sourceExtractor;
	}

}
