package me.joshua.arsenal4j.java.demo.extension.generic;

import me.joshua.arsenal4j.java.demo.extension.Extension;

@Extension
public interface GenericExt<N> {

	public N plusOne(N numberic);
}
