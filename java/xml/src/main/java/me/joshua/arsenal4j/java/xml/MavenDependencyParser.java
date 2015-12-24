package me.joshua.arsenal4j.java.xml;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MavenDependencyParser {

	private XPathExpressionLocal dependencyPath = new XPathExpressionLocal(
			"/project/dependencyManagement/dependencies/*");
	private XPathExpressionLocal groupIdPath = new XPathExpressionLocal("./groupId/text()");
	private XPathExpressionLocal artifactIdPath = new XPathExpressionLocal("./artifactId/text()");
	private XPathExpressionLocal versionPath = new XPathExpressionLocal("./version/text()");
	private XPathExpressionLocal typePath = new XPathExpressionLocal("./type/text()");

	public List<MavenArtifact> parse(File pom) throws Throwable {
		if (null == pom || !pom.exists()) {
			return Collections.emptyList();
		}

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		// 默认不启用Namespace的校验，否则会解析不出内容
		// docFactory.setNamespaceAware(true);
		DocumentBuilder builder = docFactory.newDocumentBuilder();
		Document doc = builder.parse(pom);

		return parse(doc);
	}

	private List<MavenArtifact> parse(Document doc) throws Throwable {
		NodeList nodes = (NodeList) dependencyPath.get().evaluate(doc, XPathConstants.NODESET);
		List<MavenArtifact> deps = new LinkedList<MavenArtifact>();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			String groupId = (String) groupIdPath.get().evaluate(node, XPathConstants.STRING);
			String artifactId = (String) artifactIdPath.get().evaluate(node, XPathConstants.STRING);
			String version = (String) versionPath.get().evaluate(node, XPathConstants.STRING);
			version = StringUtils.replace(version, "${version.not.exist}", "999-not-exist");
			String type = (String) typePath.get().evaluate(node, XPathConstants.STRING);

			deps.add(new MavenArtifact(groupId, artifactId, version, type));
		}

		return deps;
	}

	private static class XPathExpressionLocal extends ThreadLocal<XPathExpression> {

		private String path;

		public XPathExpressionLocal(String path) {
			this.path = path;
		}

		@Override
		protected XPathExpression initialValue() {
			XPathFactory pathFactory = XPathFactory.newInstance();
			try {
				return pathFactory.newXPath().compile(path);
			} catch (XPathExpressionException e) {
				e.printStackTrace();
				throw new RuntimeException(String.format("XPathExpression creation error, path[%s]", path), e);
			}
		}
	}
}
