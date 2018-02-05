package org.springframework.core.io.support;

import java.nio.charset.Charset;

import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

public class EncodedResource {
	
	private final Resource resource;

	private final String encoding;

	private final Charset charset;
	
	private EncodedResource(Resource resource, String encoding, Charset charset) {
		super();
		Assert.notNull(resource, "Resource must not be null");
		this.resource = resource;
		this.encoding = encoding;
		this.charset = charset;
	}

}
