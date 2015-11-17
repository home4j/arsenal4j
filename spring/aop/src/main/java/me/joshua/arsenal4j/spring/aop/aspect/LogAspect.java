package me.joshua.arsenal4j.spring.aop.aspect;

import me.joshua.arsenal4j.spring.aop.commons.Log;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Aspect应注册为Spring Bean，以使配置生效，{@link http
 * ://docs.spring.io/spring/docs/current/
 * spring-framework-reference/html/aop.html#aop-at-aspectj}，所以需要加上
 * {@code Component}注解。
 * 
 * @author Joshua
 *
 */
@Aspect
@Component
public class LogAspect {

	public static final String POINTCUT_ANNOTATION_LOG = "@annotation(me.joshua.arsenal4j.spring.aop.commons.Log)";
	public static final String POINTCUT_ANNOTATION_LOG_ARG = "@annotation(log)";
	public static final String POINTCUT_CLASS_MESSAGESERVICE = "execution(* me.joshua.arsenal4j.spring.aop.service.MessageServiceImpl.*(..))";
	public static final String POINTCUT_INTERFACE_MESSAGESERVICE = "execution(* me.joshua.arsenal4j.spring.aop.service.MessageService.*(..))";

	@After(POINTCUT_ANNOTATION_LOG)
	public void logByAnnotation() {
		printAspectMessage(POINTCUT_ANNOTATION_LOG);
	}

	@After(POINTCUT_ANNOTATION_LOG_ARG)
	public void logByAnnotationArg(Log log) {
		printAspectMessage(POINTCUT_ANNOTATION_LOG_ARG);
	}

	@After(POINTCUT_INTERFACE_MESSAGESERVICE + " && " + POINTCUT_ANNOTATION_LOG)
	public void logByAnnotation_and_interface() {
		printAspectMessage(POINTCUT_INTERFACE_MESSAGESERVICE + " && "
				+ POINTCUT_ANNOTATION_LOG);
	}

	@After(POINTCUT_INTERFACE_MESSAGESERVICE)
	public void logByInterface() {
		printAspectMessage(POINTCUT_INTERFACE_MESSAGESERVICE);
	}

	@After(POINTCUT_CLASS_MESSAGESERVICE)
	public void logByClass() {
		printAspectMessage(POINTCUT_CLASS_MESSAGESERVICE);
	}

	private void printAspectMessage(String pointcut) {
		System.out.println("Aspect introduce by " + pointcut);
	}
}
