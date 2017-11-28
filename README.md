# taiji-work-day1128

spring-boot.pdf 24章（配置文件读取的优先级）
	配置文件： properties  files,  YAML  files,  environment  variables  and command-line arguments
	使用方法： @Value
			   @ConfigurationProperties 不会警告
（外部定义的properties文件 优于 开发时写的）
				baidu:	四种方式可以把配置文件放到外部的：
						1.在jar包的同一目录下建一个config文件夹，然后把配置文件放到这个文件夹下；
						2.直接把配置文件放到jar包的同级目录；
						3.在classpath下建一个config文件夹，然后把配置文件放进去；
						4.在classpath下直接放配置文件。

						优先级是从一到四依次降低的






@component(把普通pojo实例化到spring容器中)
	即:@component("方法名")-->service中不用注解，直接定义方法 -->main(){ getBean(方法名)} 
	   @component()-->main(){ getBean(.class)}

ConfigurationProperties赋值
		① pojo类中添加 @ConfigurationProperties("prefix")(ps:括号内容可有可无);
		② .properties 文件中赋值 perfix.filed(pojo属性名)=值
		③ 自动注解生成bean
		④ main(){  getBean  }
Value赋值
		① pojo类中属性上添加@Value("${spring.application.name}")
		② .properties 文件中赋值 spring.application.name=值



命令行联系（多个配置文件，用于测试）
mvn -Pnexus package -DskipTests 打包成jar
(文件赋值pdf-24.3)在项目下新建application.properties文件，里面写入app.count=88
java -jar target\autoconfig-0.0.1-SNAPSHOT.jar 
(命令行赋值)
java -jar target\autoconfig-0.0.1-SNAPSHOT.jar --app.count=100
(命令行添加日志)
java -jar target\autoconfig-0.0.1-SNAPSHOT.jar --app.count=110 --logging.level.root=DEBUG
(新建application-prod.properties，改变赋值，命令行运行（可以用多个文件，逗号隔开）)
java -jar target\autoconfig-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod

(可以通过SpringApplication.setAddCommandLineProperties(false)禁用命令行配置)

有外部配置文件，先执行外部的。没有的话，执行内部的properties。


PM:
 LOG的切换(pdf-51章)
	POM: <artifactId>spring-boot-starter</artifactId>
		 <artifactId>spring-boot-starter-logging</artifactId>
		 <artifactId>spring-boot-starter-log4j2</artifactId>
	log4j2.xml:
http://www.baeldung.com/spring-git-information