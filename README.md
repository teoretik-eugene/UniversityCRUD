# UniversityCRUD
Тестовое задание CRUD Rest Api приложения

Приветствую читающих. 
Данное тестовое приложение базируется на предметной области университет-факультеты.

# Необходимые зависимости:

Для запуска проекта необходима зависимость SpringBoot 2.7.10:

  <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
    
А также зависимость ModelMapper:

  <!-- https://mvnrepository.com/artifact/org.modelmapper/modelmapper -->
		<dependency>
			<groupId>org.modelmapper</groupId>
			<artifactId>modelmapper</artifactId>
			<version>2.4.5</version>
		</dependency>
		
Полный pom.xml файл приведен в репозитории


Для приложения используется реляционная БД PostgreSQL. Для того чтобы инициализировать данные, необходимо запустить sql запрос, который будет приведен в файле репозитория: ```init.sql```

