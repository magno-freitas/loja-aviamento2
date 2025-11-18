package com.loja.lojaaviamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LojaAviamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaAviamentoApplication.class, args);
	}

}
/*Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2025-11-18T15:59:44.931-03:00 ERROR 20076 --- [loja-aviamento] [  restartedMain] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration': Injection of autowired dependencies failed
at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:515) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1459) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:606) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:529) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:339) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:373) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:337) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.DefaultListableBeanFactory.instantiateSingleton(DefaultListableBeanFactory.java:1221) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingleton(DefaultListableBeanFactory.java:1187) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:1123) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:987) ~[spring-context-6.2.11.jar:6.2.11]
at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:627) ~[spring-context-6.2.11.jar:6.2.11]
at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.5.6.jar:3.5.6]
at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:752) ~[spring-boot-3.5.6.jar:3.5.6]
at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:439) ~[spring-boot-3.5.6.jar:3.5.6]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:318) ~[spring-boot-3.5.6.jar:3.5.6]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:1361) ~[spring-boot-3.5.6.jar:3.5.6]
at org.springframework.boot.SpringApplication.run(SpringApplication.java:1350) ~[spring-boot-3.5.6.jar:3.5.6]
at com.loja.lojaaviamento.LojaAviamentoApplication.main(LojaAviamentoApplication.java:10) ~[classes/:na]
at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:50) ~[spring-boot-devtools-3.5.6.jar:3.5.6]
Caused by: java.lang.RuntimeException: Could not postProcess org.springframework.security.config.annotation.web.builders.WebSecurity@8cf6950 of type class org.springframework.security.config.annotation.web.builders.WebSecurity
at org.springframework.security.config.annotation.configuration.AutowireBeanFactoryObjectPostProcessor.postProcess(AutowireBeanFactoryObjectPostProcessor.java:71) ~[spring-security-config-6.5.5.jar:6.5.5]
at org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration.setFilterChainProxySecurityConfigurer(WebSecurityConfiguration.java:159) ~[spring-security-config-6.5.5.jar:6.5.5]
at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103) ~[na:na]
at java.base/java.lang.reflect.Method.invoke(Method.java:580) ~[na:na]
at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredMethodElement.inject(AutowiredAnnotationBeanPostProcessor.java:854) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:146) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:509) ~[spring-beans-6.2.11.jar:6.2.11]
        ... 22 common frames omitted
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'mvcHandlerMappingIntrospectorRequestTransformer': Cannot resolve reference to bean 'mvcHandlerMappingIntrospector' while setting constructor argument
at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveReference(BeanDefinitionValueResolver.java:377) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveValueIfNecessary(BeanDefinitionValueResolver.java:135) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.ConstructorResolver.resolveConstructorArguments(ConstructorResolver.java:691) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:206) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1395) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1232) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:569) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:529) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:339) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:373) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:337) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:227) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveNamedBean(DefaultListableBeanFactory.java:1613) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveNamedBean(DefaultListableBeanFactory.java:1571) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveBean(DefaultListableBeanFactory.java:564) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.DefaultListableBeanFactory$1.getIfUnique(DefaultListableBeanFactory.java:490) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.security.config.annotation.web.builders.WebSecurity.setApplicationContext(WebSecurity.java:433) ~[spring-security-config-6.5.5.jar:6.5.5]
at org.springframework.context.support.ApplicationContextAwareProcessor.invokeAwareInterfaces(ApplicationContextAwareProcessor.java:110) ~[spring-context-6.2.11.jar:6.2.11]
at org.springframework.context.support.ApplicationContextAwareProcessor.postProcessBeforeInitialization(ApplicationContextAwareProcessor.java:85) ~[spring-context-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:429) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1818) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:419) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.security.config.annotation.configuration.AutowireBeanFactoryObjectPostProcessor.initializeBeanIfNeeded(AutowireBeanFactoryObjectPostProcessor.java:98) ~[spring-security-config-6.5.5.jar:6.5.5]
at org.springframework.security.config.annotation.configuration.AutowireBeanFactoryObjectPostProcessor.postProcess(AutowireBeanFactoryObjectPostProcessor.java:67) ~[spring-security-config-6.5.5.jar:6.5.5]
        ... 28 common frames omitted
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'mvcHandlerMappingIntrospector' defined in class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]: Error creating bean with name 'requestMappingHandlerMapping' defined in class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]: Ambiguous mapping. Cannot map 'indexController' method
com.loja.lojaaviamento.controller.IndexController#home()
to {GET [/]}: There is already 'dashboardController' bean method
com.loja.lojaaviamento.controller.DashboardController#home() mapped.
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1826) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:607) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:529) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:339) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:373) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:337) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.BeanDefinitionValueResolver.resolveReference(BeanDefinitionValueResolver.java:365) ~[spring-beans-6.2.11.jar:6.2.11]
        ... 51 common frames omitted
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'requestMappingHandlerMapping' defined in class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration$EnableWebMvcConfiguration.class]: Ambiguous mapping. Cannot map 'indexController' method
com.loja.lojaaviamento.controller.IndexController#home()
to {GET [/]}: There is already 'dashboardController' bean method
com.loja.lojaaviamento.controller.DashboardController#home() mapped.
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1826) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:607) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:529) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:339) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:373) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:337) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeansOfType(DefaultListableBeanFactory.java:748) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.context.support.AbstractApplicationContext.getBeansOfType(AbstractApplicationContext.java:1426) ~[spring-context-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.BeanFactoryUtils.beansOfTypeIncludingAncestors(BeanFactoryUtils.java:372) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.web.servlet.handler.HandlerMappingIntrospector.initHandlerMappings(HandlerMappingIntrospector.java:159) ~[spring-webmvc-6.2.11.jar:6.2.11]
at org.springframework.web.servlet.handler.HandlerMappingIntrospector.afterPropertiesSet(HandlerMappingIntrospector.java:146) ~[spring-webmvc-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1873) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1822) ~[spring-beans-6.2.11.jar:6.2.11]
        ... 58 common frames omitted
Caused by: java.lang.IllegalStateException: Ambiguous mapping. Cannot map 'indexController' method
com.loja.lojaaviamento.controller.IndexController#home()
to {GET [/]}: There is already 'dashboardController' bean method
com.loja.lojaaviamento.controller.DashboardController#home() mapped.
at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping$MappingRegistry.validateMethodMapping(AbstractHandlerMethodMapping.java:676) ~[spring-webmvc-6.2.11.jar:6.2.11]
at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping$MappingRegistry.register(AbstractHandlerMethodMapping.java:637) ~[spring-webmvc-6.2.11.jar:6.2.11]
at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping.registerHandlerMethod(AbstractHandlerMethodMapping.java:331) ~[spring-webmvc-6.2.11.jar:6.2.11]
at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping.registerHandlerMethod(RequestMappingHandlerMapping.java:507) ~[spring-webmvc-6.2.11.jar:6.2.11]
at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping.registerHandlerMethod(RequestMappingHandlerMapping.java:84) ~[spring-webmvc-6.2.11.jar:6.2.11]
at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping.lambda$detectHandlerMethods$2(AbstractHandlerMethodMapping.java:298) ~[spring-webmvc-6.2.11.jar:6.2.11]
at java.base/java.util.LinkedHashMap.forEach(LinkedHashMap.java:987) ~[na:na]
at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping.detectHandlerMethods(AbstractHandlerMethodMapping.java:296) ~[spring-webmvc-6.2.11.jar:6.2.11]
at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping.processCandidateBean(AbstractHandlerMethodMapping.java:265) ~[spring-webmvc-6.2.11.jar:6.2.11]
at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping.initHandlerMethods(AbstractHandlerMethodMapping.java:224) ~[spring-webmvc-6.2.11.jar:6.2.11]
at org.springframework.web.servlet.handler.AbstractHandlerMethodMapping.afterPropertiesSet(AbstractHandlerMethodMapping.java:212) ~[spring-webmvc-6.2.11.jar:6.2.11]
at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping.afterPropertiesSet(RequestMappingHandlerMapping.java:237) ~[spring-webmvc-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1873) ~[spring-beans-6.2.11.jar:6.2.11]
at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1822) ~[spring-beans-6.2.11.jar:6.2.11]
        ... 71 common frames omitted


Process finished with exit code 0*/