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

Для начала необходимо запустить init.sql, который в себе содержит запросы для создания таблицы и внесение в нее данных. Создадутся таблицы с данными, с которыми мы будет взаимодействовать посредством API, Http и JSON.

**Описание эндпоинтов:**
p.s Присутствуют файлы json сохрененные из Postman

Университет:

```Get запрос на адрес http://localhost:8081/api/v1/university:```
Получаем в ответ: 
```
[
    {
        "name": "BMSTU",
        "address": "Moscow, 2nd Baumanskaya str., 5",
        "foundation_year": 1830,
        "website": "https://bmstu.ru/"
    },
    {
        "name": "MEPHI",
        "address": "Kashirskoe sh., 31, Moscow",
        "foundation_year": 1942,
        "website": "https://mephi.ru/"
    },
    {
        "name": "MIPT",
        "address": "Institutsky Lane, 9, Dolgoprudny",
        "foundation_year": 1946,
        "website": "https://mipt.ru/"
    },
    {
        "name": "MIET",
        "address": "Shokina Square, 1, Zelenograd, Moscow",
        "foundation_year": 1965,
        "website": "https://miet.ru/"
    }
]
```
Т.е. получили DTO всех добавленных университетов

Получаем отдельный университет по id
```Get запрос по id из БД на адрес: http://localhost:8081/api/v1/university/1```
Получаем в ответ:
```
{
    "name": "BMSTU",
    "address": "Moscow, 2nd Baumanskaya str., 5",
    "foundation_year": 1830,
    "website": "https://bmstu.ru/"
}
```

Далее попробуем создать какую-нибудь новую запись в БД:
```Post зпрос на адрес http://localhost:8081/api/v1/university```

Для этого отправим соответствующий запрос в формате json:
```
{
    "name": "RUDN",
    "address": "Miklukho-Maklaya str., 6, Moscow",
    "foundation_year": 1960,
    "website": "https://www.rudn.ru/"
}
```

Получим в ответ только код выполнения запроса - 200

Также можно изменить сущность. Для этого вызываем метод Patch по адресу ```http://localhost:8081/api/v1/university/2```
Например, изменим веб-сайт в свойствах. Отправляем запрос:
```
{
    "website": "https://open.mephi.ru/unit/5"
}
```
Если сущность с таким ID была найдена, то изменим ее в соответствии с указанным параметром. Значение поменяется прямо в БД. Иначе вернет 304 (NOT_MODIFIED).

В репозитории присутствуют json файлы с запросами из Postman

**Аналогично проведем с Faculty**

Отправим запрос ```Get http://localhost:8081/api/v1/faculty```

В ответ мы получаем список наших объектов, содержащие в себе информацию об университете:
```
[
    {
        "name": "IU",
        "code": "11.03.03",
        "gpa": 252.0,
        "description": "Informatics and management system",
        "university": {
            "name": "BMSTU",
            "address": "Moscow, 2nd Baumanskaya str., 5",
            "foundation_year": 1830,
            "website": "https://bmstu.ru/"
        }
    },
    {
        "name": "RT",
        "code": "11.03.04",
        "gpa": 207.0,
        "description": "Radio engineering",
        "university": {
            "name": "BMSTU",
            "address": "Moscow, 2nd Baumanskaya str., 5",
            "foundation_year": 1830,
            "website": "https://bmstu.ru/"
        }
    },
    {
        "name": "LaPlas",
        "code": "12.03.05",
        "gpa": 281.0,
        "description": "Lasers and Plasma",
        "university": {
            "name": "MEPHI",
            "address": "Kashirskoe sh., 31, Moscow",
            "foundation_year": 1942,
            "website": "https://open.mephi.ru/unit/5"
        }
    }
]
```

Отправляя запрос по конкретному ID получим описание в json факультета:

``` Get http://localhost:8081/api/v1/faculty/1```:

```
{
    "name": "IU",
    "code": "11.03.03",
    "gpa": 252.0,
    "description": "Informatics and management system",
    "university": {
        "name": "BMSTU",
        "address": "Moscow, 2nd Baumanskaya str., 5",
        "foundation_year": 1830,
        "website": "https://bmstu.ru/"
    }
}
```

Далее попробуем отправить данные в прилолжение. Для него подготавливаем тело запроса. Чтобы избежать путанницы, для Post будет свой DTO. Чтобы связать факультет и университет необходимо в запросе указать имя вуза:
```
{
        "name": "BoI",
        "code": "38.03.05",
        "gpa": 114.2,
        "description": "Buisness Informatics",
        "university": "RUDN"
}
```

Нам вернется ответ 200. В таблицу БД добавилась соответствующая запись, а по запросу ```Get http://localhost:8081/api/v1/faculty``` получим обновленный json.

Для изменения воспользуемся Patch:
```Patch http://localhost:8081/api/v1/faculty/4```
 и отправим тело: 
 ```
 {
    "name": "BI"
}
 ``` 
 
 по итогу, если мы отправим на этот id get запрос, то получим:
 ```
 {
    "name": "BoI",
    "code": "38.03.05",
    "gpa": 114.2,
    "description": "Buisness Informatics",
    "university": {
        "name": "RUDN",
        "address": "Miklukho-Maklaya str., 6, Moscow",
        "foundation_year": 1960,
        "website": "https://www.rudn.ru/"
    }
}
 ```


Чтобы удалить запись из БД необходимо отправить delete запроспо соответствующему ID:
```Delete http://localhost:8081/api/v1/faculty/4```
После этого запроса вернется ответ 200, запись будет удалена.



