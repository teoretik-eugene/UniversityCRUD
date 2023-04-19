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

Для данного мини-проекта используется Java 17

# Описание предметной области:
За основу была взята идея свзи сущности Университета и Факультета. Университет и факультеты связаны отношением ОДИН-КО-МНОГИМ, т.е. на один университет может приходиться несколько факультетов. 
Рассмотрим модели подробнее: 
Университет содержит в себе следующие свойства:
	-id - айди университета
	-name - название университета
	-address - адрес универа
	-foundationYear - год, когда универ был основан
	-website - основной сайт университета
	
Аналогино рассмотрим модель Факультет:
	-id - айди
	-name - название факультета
	-code - код специальности или факультета
	-gpa - средний балл по факультету
	-description - описание факультета
	-university - содержит в себе ссылку на id из Университета.
	
Таким образом, если мы будем обращаться к университету, то получим информацию только об университете, в то время как если обратимся к факультету, то сможем также получить информацию об университете тоже.

# Приложение

Для начала необходимо запустить init.sql, который в себе содержит запросы для создания таблицы и внесение в нее данных.
