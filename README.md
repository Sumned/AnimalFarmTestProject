Для запуску проекту потрібен Docker, IntellijIdea або Gradle.

Схема з поставленого завдання

![test](readme/ZOO%20OOP%20Problem%20Schema.png)

У цій схемі є проблеми з визначенням ролей тварин у існуючій ієрархії - коза і корова одночасно являються і тваринами, і їжею.
Найкращим рішенням у цій ситуації буде розшитири схему і додати до неї більшу кількість посередніх сутностей,
які краще будуть описувати роль кожного окремого об'єкта в природній ієрархнії. В першу чергу,
ми розділимо їжу на їжу рослинного і тваринного походження, до рослинної їжі, відповідно, буде відноситиь трвара,
а до тваринної - коза і корова. В свою чергу, тварин ми відповідно розділюєм на сутності - хижаки і травоїдні.
До перших відноситься лев, до других - відносяться корови і кози. Відповідно, хижаки можуть вживати лише 
їжу тваринного походження, тобто кіз і корів, а травоїдні - їжу рослинного походження, тобто у нашому випадку - траву.
Тому виправлена схема буде виглядати ось так: