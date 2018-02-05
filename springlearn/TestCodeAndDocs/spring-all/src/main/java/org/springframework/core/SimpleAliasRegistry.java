package org.springframework.core;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleAliasRegistry implements AliasRegistry {
	/** Map from alias to canonical name */
	private final Map<String, String> aliasMap = new ConcurrentHashMap<String, String>(16);

	public void registerAlias(String name, String alias) {
		
	}

	public void removeAlias(String alias) {
		
	}

	public boolean isAlias(String name) {
		return false;
	}

	public String[] getAliases(String name) {
		return null;
	}

}
