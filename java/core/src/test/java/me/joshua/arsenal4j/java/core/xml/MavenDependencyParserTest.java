package me.joshua.arsenal4j.java.core.xml;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Resources;

public class MavenDependencyParserTest {

	private MavenDependencyParser parser;

	@Before
	public void init() {
		parser = new MavenDependencyParser();
	}

	@Test
	public void test() throws Throwable {
		List<MavenArtifact> deps = new LinkedList<>();
		File pomDir = new File(Resources.getResource("pom").toURI());
		for (File pom : FileUtils.listFiles(pomDir, TrueFileFilter.TRUE, null)) {
			deps.addAll(parser.parse(pom));
		}
		Assert.assertTrue(deps.size() > 0);
		Collections.sort(deps);

		for (MavenArtifact artifact : deps) {
			System.out.println("			<dependency>\r\n" + "				<groupId>" + artifact.getGroupId()
					+ "</groupId>\r\n" + "				<artifactId>" + artifact.getArtifactId() + "</artifactId>\r\n"
					+ "				<version>" + artifact.getVersion() + "</version>\r\n" + "			</dependency>");
		}
	}

}
