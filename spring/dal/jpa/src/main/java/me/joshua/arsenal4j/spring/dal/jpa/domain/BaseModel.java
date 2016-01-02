package me.joshua.arsenal4j.spring.dal.jpa.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.domain.Persistable;

import me.joshua.arsenal4j.java.commons.BaseObject;

@MappedSuperclass
public class BaseModel extends BaseObject implements Persistable<Long> {

	private static final long serialVersionUID = 2643469515894409270L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Version
	protected Long version;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public boolean isNew() {
		return null == getId();
	}
}
