<h1>Веб-приложение Spoon</h2>
<h2>Необходимое для запуска ПО</h2>
<li>Java 8
<li>MySQL
<li>Maven
<h2>Запуск приложения</h2>
Распаковать архив.<br>
<hr>
В файле /spoon/src/main/resources/application.properties поменять <del>db</del> на название своей схемы в базе данных MySQL:
<code>
spring.datasource.url=jdbc:mysql://localhost:3306/<del>db</del>?
useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
</code>
<hr>
Указать логин и пароль для доступа в базу данных:<br>
<code>
spring.datasource.username = <del>root</del>

spring.datasource.password = <del>root</del>
</code> 
<h2>Описание приложения</h2>
Spoon веб-приложение для кулинарных рецептов. Вы можете добавить рецепт, оценить его, сохранить рецепты других пользователей.
