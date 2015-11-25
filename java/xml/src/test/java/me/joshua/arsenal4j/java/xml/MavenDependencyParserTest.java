package me.joshua.arsenal4j.java.xml;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Resources;

import me.joshua.arsenal4j.java.commons.TestUtils;

public class MavenDependencyParserTest {

	private MavenDependencyParser parser;

	@Before
	public void init() {
		parser = new MavenDependencyParser();
	}

	@Test
	public void test() throws Throwable {
		List<String> deps = new LinkedList<>();
		File pomDir = new File(Resources.getResource("pom").toURI());
		for (File pom : FileUtils.listFiles(pomDir, TrueFileFilter.TRUE, null)) {
			deps.addAll(parser.parse(pom));
		}
		Collections.sort(deps);
		TestUtils.print(deps);
	}

}
