# Проект по автоматизации тестирования для Bell Integrator
<a target="_blank" href="https://bellintegrator.ru/">Cайт Bell Integrator</a>

<image src="https://bellintegrator.ru/catalog/view/theme/bellOne/image/logo_BellIntegrator_rus.svg">

## :pushpin: <a id="list"></a> Содержание:

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Реализованные проверки</a>

* <a href="#console">Запуск из терминала</a>
  
* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#allure">Allure отчеты</a>

* <a href="#telegram">Отчёт в Telegram</a>

* <a href="#testops">Интеграция с Allure TestOps</a>

* <a href="#jira">Интеграция с Jira</a>


## :hammer_and_wrench: <a id="tools"></a> Технологии и инструменты
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/Idea.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="images/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="images/GitHub.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="images/Junit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/Allure.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="images/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>



## :scroll: <a id="cases"></a> Реализованные проверки

* Проверка отображения и элементов формы обратной связи
* Проверка отсутствия нежелательных warnings на странице поиска
* Проверка отображения основных элементов страницы обучения
* Проверка работы фильтров на странице вакансий и соответствия отфильтрованных вакансий заданному фильтру
* Проверка работы меню филиалов на странице контактов

## :computer: <a id="console"></a> Запуск из терминала
```bash
 gradle clean autotest_bell_remote
```

## <a href="https://www.jenkins.io/" id="jenkins"><img src="images/Jenkins.svg" width="50" height="50"  alt="jenkins" /> </a> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/018_klyul_Diplom_Web/)

Для запуска сборки необходимо перейти в раздел <code><strong>*Собрать с параметрами*</strong></code> и нажать кнопку <code><strong>*Собрать*</strong></code>.
<a href="https://jenkins.autotests.cloud/job/018_klyul_Diplom_Web/#"><img src="images/jenkins.png" alt="jenkins"/></a>
<p align="center">
</p>


## <a href="https://github.com/allure-framework/allure2" id="allure"><img src="images/Allure.svg" width="50" height="50"  alt="Allure"  /></a> Allure отчеты
:information_source: По итогам сборки в Jenkins собирается [отчет в Allure Report](https://jenkins.autotests.cloud/job/018_klyul_Diplom_Web/allure/)
> Для просмотра необходимо залогиниться в Jenkins
* Подключено добавление в отчет:
    - скриншота финального состояния
    - исходного кода страницы
    - логов браузера
    - видео прохождения тестов
<p align="center">
<img src="images/allurereport1.png">
<img src="images/allurereport2.png">
</p>


## <a id="telegram"><img src="images/Telegram.svg" width="50" height="50" /></a> Отчёт в Telegram 

После завершения сборки сообщение с основными результатами прогона тестов отправляется через созданный бот в выбранный телеграм-канал
<p align="center">
<img src="images/tgbot.png">

##  <a id="testops"><img src="images/Allure_TO.svg" width="50" height="50" /></a> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/2279/launches)

### Основной дашборд
<p align="center">
<img src="images/Allure_TODash.png">
</p>

### Список тестов с результатами прогона

<p align="center">
  <img src="images/allure-testops-testcases.png" alt="dashboard" width="900" />
</p>

### Тест-кейсы
Тест-кейсы, автоматические созданные в Allure Testops, на основе разработанных автотестов 
<p align="center">
  <img src="images/allure-testops-results.png" alt="testcase" width="900" />
</p>



## <a id="jira"><img width="30" alt="Jira" src="images/jira-logo.svg" /></a> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-703)
:information_source: Настроена интеграция Allure TestOps с Jira.
Тест-кейсы и результаты прогонов можно прикреплять к необходимым задачам.

<img alt="Jira" src="images/Jira.png" />
