Схема з поставленого завдання

![task](readme/ZOO%20OOP%20Problem%20Schema.png)

У цій схемі є проблеми з визначенням ролей тварин у існуючій ієрархії - коза і корова одночасно являються і тваринами, і їжею.
Найкращим рішенням у цій ситуації буде розшитири схему і додати до неї більшу кількість посередніх сутностей,
які краще будуть описувати роль кожного окремого об'єкта в природній ієрархнії. В першу чергу,
ми розділимо їжу на їжу рослинного і тваринного походження, до рослинної їжі, відповідно, буде відноситиь трвара,
а до тваринної - коза і корова. В свою чергу, тварин ми відповідно розділюєм на сутності - хижаки і травоїдні.
До перших відноситься лев, до других - відносяться корови і кози. Відповідно, хижаки можуть вживати лише 
їжу тваринного походження, тобто кіз і корів, а травоїдні - їжу рослинного походження, тобто у нашому випадку - траву.
Тому виправлена схема буде виглядати ось так:

![solution](readme/img.png)

Для запуску проекту потрібен Java 17, Docker, IntellijIdea або Gradle.

Після скачування потрібно запустити в кореневій папці проекту docker-compose up,
після чого зайти на [http://localhost:8080/](http://localhost:8080/) і через Adminer підключитись до бази данних 
через користувача 'root' і паролем 'test', після чого імпортувати і виконати спочатку файл database/tables.sql,
а потім database/tables.sql. Після цьго можна запускати проект.
Опис API:
    Лев
        Створення лева:
            POST запит localhost:8085/lions?name={ім'я}
        Список усіх створених левів:
            GET запит localhost:8085/lions
        Отримати лева по імені:
            Get запит localhost:8085/lions/lion?name={ім'я}
        Погодувати лева (для цього спочатку потрібно створити тварин з відповідними іменами): 
            Put запит localhost:8085/lions/feed?lionName={ім'я лева}&foodName={ім'я тварини}&foodType={cow або goat}
    Корова
        Створення корови:
            POST запит localhost:8085/cows?name={ім'я}
        Список усіх створених корів:
            GET запит localhost:8085/cows
        Отримати корову по імені:
            Get запит localhost:8085/cows/cow?name={ім'я}
        Погодувати корову:
            PUT запит localhost:8085/cows/feed?name={ім'я (корови)}
    Коза
        Створення кози:
            POST запит localhost:8085/goats?name={ім'я}
        Список усіх створених кіз:
            GET запит localhost:8085/goats
        Отримати козу по імені:
            Get запит localhost:8085/goats/goat?name={ім'я}
        Погодувати козу:
            PUT запит localhost:8085/goats/feed?name={ім'я (кози)}

Правила:
    Хижаки можуть їсти лише м'ясо.
    Травоїдні можуть їсти лише рослинну їжу.
    Хижаки не можуть їсти уже з'їдених тварин.
    З'їдені тварини не можуть їсти.
    Хижаки не можуть їсти неіснуючих тварни.

            