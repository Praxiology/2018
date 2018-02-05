package org.springframework.core.convert.support;

import org.springframework.util.ClassUtils;

public class DefaultConversionService extends GenericConversionService {

	/** Java 8's java.util.Optional class available? */
	private static final boolean javaUtilOptionalClassAvailable =
			ClassUtils.isPresent("java.util.Optional", DefaultConversionService.class.getClassLoader());

	/** Java 8's java.time package available? */
	private static final boolean jsr310Available =
			ClassUtils.isPresent("java.time.ZoneId", DefaultConversionService.class.getClassLoader());

	/** Java 8's java.util.stream.Stream class available? */
	private static final boolean streamAvailable = ClassUtils.isPresent(
			"java.util.stream.Stream", DefaultConversionService.class.getClassLoader());


}
