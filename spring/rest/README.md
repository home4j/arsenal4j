<bean id="jackson2ObjectMapperBuilder"
	class="org.springframework.http.converter.json.Jackson2ObjectMapperBuilder">
	<property name="propertyNamingStrategy">
		<!-- 获取常量值，http://stackoverflow.com/questions/2897819/spring-using-static-final-fields-constants-for-bean-initialization -->
		<util:constant
			static-field="com.fasterxml.jackson.databind.PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES" />
	</property>
</bean>

<!-- 用FactoryBean构造实例，http://stackoverflow.com/questions/3236850/spring-using-builder-pattern-to-create-a-bean -->
<bean id="mappingJackson2HttpMessageConverter" factory-bean="jackson2ObjectMapperBuilder"
	factory-method="build" />