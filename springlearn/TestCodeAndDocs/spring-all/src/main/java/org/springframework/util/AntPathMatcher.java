package org.springframework.util;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AntPathMatcher implements PathMatcher {

	/** Default path separator: "/" */
	public static final String DEFAULT_PATH_SEPARATOR = "/";

	private static final int CACHE_TURNOFF_THRESHOLD = 65536;

	private static final Pattern VARIABLE_PATTERN = Pattern.compile("\\{[^/]+?\\}");

	private static final char[] WILDCARD_CHARS = { '*', '?', '{' };


	private String pathSeparator;

	private PathSeparatorPatternCache pathSeparatorPatternCache;

	private boolean caseSensitive = true;

	private boolean trimTokens = false;

	private volatile Boolean cachePatterns;

	private final Map<String, String[]> tokenizedPatternCache = new ConcurrentHashMap<String, String[]>(256);

	final Map<String, AntPathStringMatcher> stringMatcherCache = new ConcurrentHashMap<String, AntPathStringMatcher>(256);


	/**
	 * Create a new instance with the {@link #DEFAULT_PATH_SEPARATOR}.
	 */
	public AntPathMatcher() {
		this.pathSeparator = DEFAULT_PATH_SEPARATOR;
		this.pathSeparatorPatternCache = new PathSeparatorPatternCache(DEFAULT_PATH_SEPARATOR);
	}


	public boolean isPattern(String path) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean match(String pattern, String path) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean matchStart(String pattern, String path) {
		// TODO Auto-generated method stub
		return false;
	}


	public String extractPathWithinPattern(String pattern, String path) {
		// TODO Auto-generated method stub
		return null;
	}


	public Map<String, String> extractUriTemplateVariables(String pattern, String path) {
		// TODO Auto-generated method stub
		return null;
	}


	public Comparator<String> getPatternComparator(String path) {
		// TODO Auto-generated method stub
		return null;
	}


	public String combine(String pattern1, String pattern2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected static class AntPathStringMatcher {

		private static final Pattern GLOB_PATTERN = Pattern.compile("\\?|\\*|\\{((?:\\{[^/]+?\\}|[^/{}]|\\\\[{}])+?)\\}");

		private static final String DEFAULT_VARIABLE_PATTERN = "(.*)";

		private final Pattern pattern;

		private final List<String> variableNames = new LinkedList<String>();

		public AntPathStringMatcher(String pattern) {
			this(pattern, true);
		}

		public AntPathStringMatcher(String pattern, boolean caseSensitive) {
			StringBuilder patternBuilder = new StringBuilder();
			Matcher matcher = GLOB_PATTERN.matcher(pattern);
			int end = 0;
			while (matcher.find()) {
				patternBuilder.append(quote(pattern, end, matcher.start()));
				String match = matcher.group();
				if ("?".equals(match)) {
					patternBuilder.append('.');
				}
				else if ("*".equals(match)) {
					patternBuilder.append(".*");
				}
				else if (match.startsWith("{") && match.endsWith("}")) {
					int colonIdx = match.indexOf(':');
					if (colonIdx == -1) {
						patternBuilder.append(DEFAULT_VARIABLE_PATTERN);
						this.variableNames.add(matcher.group(1));
					}
					else {
						String variablePattern = match.substring(colonIdx + 1, match.length() - 1);
						patternBuilder.append('(');
						patternBuilder.append(variablePattern);
						patternBuilder.append(')');
						String variableName = match.substring(1, colonIdx);
						this.variableNames.add(variableName);
					}
				}
				end = matcher.end();
			}
			patternBuilder.append(quote(pattern, end, pattern.length()));
			this.pattern = (caseSensitive ? Pattern.compile(patternBuilder.toString()) :
					Pattern.compile(patternBuilder.toString(), Pattern.CASE_INSENSITIVE));
		}

		private String quote(String s, int start, int end) {
			if (start == end) {
				return "";
			}
			return Pattern.quote(s.substring(start, end));
		}

		/**
		 * Main entry point.
		 * @return {@code true} if the string matches against the pattern, or {@code false} otherwise.
		 */
		public boolean matchStrings(String str, Map<String, String> uriTemplateVariables) {
			Matcher matcher = this.pattern.matcher(str);
			if (matcher.matches()) {
				if (uriTemplateVariables != null) {
					// SPR-8455
					if (this.variableNames.size() != matcher.groupCount()) {
						throw new IllegalArgumentException("The number of capturing groups in the pattern segment " +
								this.pattern + " does not match the number of URI template variables it defines, " +
								"which can occur if capturing groups are used in a URI template regex. " +
								"Use non-capturing groups instead.");
					}
					for (int i = 1; i <= matcher.groupCount(); i++) {
						String name = this.variableNames.get(i - 1);
						String value = matcher.group(i);
						uriTemplateVariables.put(name, value);
					}
				}
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	private static class PathSeparatorPatternCache {

		private final String endsOnWildCard;

		private final String endsOnDoubleWildCard;

		public PathSeparatorPatternCache(String pathSeparator) {
			this.endsOnWildCard = pathSeparator + "*";
			this.endsOnDoubleWildCard = pathSeparator + "**";
		}

		public String getEndsOnWildCard() {
			return this.endsOnWildCard;
		}

		public String getEndsOnDoubleWildCard() {
			return this.endsOnDoubleWildCard;
		}
	}

}
