package me.joshua.arsenal4j.java.demo.maven;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

public class MavenArtifact implements Comparable<MavenArtifact> {
	private String groupId;
	private String artifactId;
	private String version;
	private String type;

	public MavenArtifact(String groupId, String artifactId, String version, String type) {
		super();
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
		this.type = type;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("%s:%s:%s:%s", groupId, artifactId, version, StringUtils.isEmpty(type) ? "jar" : type);
	}

	@Override
	public int compareTo(MavenArtifact o) {
		int result = 0;
		result = ObjectUtils.compare(groupId, o.groupId);
		if (0 != result) {
			return result;
		}

		result = ObjectUtils.compare(artifactId, o.artifactId);
		if (0 != result) {
			return result;
		}

		result = ObjectUtils.compare(version, o.version);
		if (0 != result) {
			return result;
		}

		result = ObjectUtils.compare(type, o.type);
		if (0 != result) {
			return result;
		}

		return 0;
	}

}
