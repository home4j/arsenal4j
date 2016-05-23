package me.joshua.arsenal4j.java.demo.extension.simple;

import me.joshua.arsenal4j.java.demo.extension.Default;

/**
 * 简单扩展点。 没有Wrapper。
 *
 * @author ding.lid
 */
@Default("impl1")
public interface SimpleExt {
	String echo(String s);

	String yell(String s);

	String bang(int i);
}