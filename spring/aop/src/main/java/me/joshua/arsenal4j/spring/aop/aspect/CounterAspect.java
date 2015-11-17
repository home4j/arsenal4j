package me.joshua.arsenal4j.spring.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import me.joshua.arsenal4j.spring.aop.commons.Counter;

@Aspect
@Component
public class CounterAspect {

	public static final String POINTCUT_COUNTERSERVICE = "execution(* me.joshua.arsenal4j.spring.aop.service.CounterService.*(..))"
			+ " && args(counter)";

	@Before(POINTCUT_COUNTERSERVICE)
	public void before(Counter counter) {
		counter.print("[Before]" + POINTCUT_COUNTERSERVICE);
	}

	@After(POINTCUT_COUNTERSERVICE)
	public void after(Counter counter) {
		counter.print("[After]" + POINTCUT_COUNTERSERVICE);
	}
}
