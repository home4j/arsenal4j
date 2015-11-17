package me.joshua.arsenal4j.spring.aop.service;

public interface MessageService {

	/**
	 * 注解放在接口上是无效的，需要放在具体实现类上
	 */
	// @Log
	public void echo(String message);
}
