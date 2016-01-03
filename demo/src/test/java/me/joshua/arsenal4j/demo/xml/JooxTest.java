package me.joshua.arsenal4j.demo.xml;

import org.joox.JOOX;
import org.joox.Match;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Element;

import com.google.common.io.Resources;

/**
 * 试用JOOX，非常好用的xml选择器{@link https://github.com/jOOQ/jOOX}
 * 
 * @author daonan.zhan
 */
public class JooxTest {

	@Test
	public void test() throws Throwable {
		Match deps = JOOX.$(Resources.getResource("pom/pom.xml")).find("dependency");
		Assert.assertTrue(deps.size() > 0);
		for (Element dep : deps) {
			String groupId = JOOX.$(dep).find("groupId").text();
			String artifactId = JOOX.$(dep).find("artifactId").text();
			System.out.println(groupId + ":" + artifactId);
		}
	}
}