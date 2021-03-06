# Методы сортировки [![Build Status](https://img.shields.io/badge/Version-2022/05/20-red.svg)](#SortingMethods)
Разновидности методов сортировки на Java.
<hr>

### Ссылки
[Описание проекта](#описание-проекта)

[Примеры](#примеры)

[Добавленные методы сортировок](#добавленные-методы-сортировок)

[Скачать поледнюю версию](https://github.com/YarikBur/Sorting-methods/releases)

<hr>

## Описание проекта
Проект создан с целью личного ознакомления с методами сортировки.

Путь к файлу, в котором будет записан результат времени сортировки.
```java
private static String filePath = "F:\\Desktop\\methods.xls";
```

Сколько раз надо будет повторять сортировку массива одной длины (заполнение у массива каждый раз генерируется).
```java
private static int attempts = 3;
```

В основном файле можно указать классы (методы сортировки), которые будут работать с массивами.
```java
private static SortingMethod[] methods = {
  new BoubleSorting(),
  new ShakerSorting(),
  new CombSorting(),
  new InsertSorting(),
  new SelectionSort(),
  new FastSorting()
};
```

Создаются массивы указанной длины, которые учавствуют в сортировке.
```java
private static int[][] array = {
  new int[10],
  new int[100],
  new int[1000],
  new int[10000],
  new int[100000]
};
```

## Примеры
Запуск приложения с искользованием аргументов.
Аргументы не обязательные. Стандартные значения приведены выше.
```
java -jar methods.jar "path" attempts
```

![Excel Output](https://github.com/YarikBur/Sorting-methods/blob/main/readme-images/Excel.png)

На изображении видно, что каждый вид сортировки будет заноситься на отдельный лист в книге.
Каждая строчка - это кол-во чисел в массиве, который потом будет сортироваться.

## Добавленные методы сортировок
[Директория с классами методов сортировки](https://github.com/YarikBur/Sorting-methods/tree/main/src/ru/asfick/methods)

| Статус | Название |
| :---: | :---: |
| :heavy_check_mark: | Сортировка пузырьком |
| :heavy_check_mark: | Шейкерная сортировка |
| :heavy_check_mark: | Сортировка расчёской |
| :heavy_check_mark: | Сортировка вставками |
| :heavy_check_mark: | Сортировка выбором |
| :heavy_check_mark: | Быстрая сортировка |
| :x: | Сортировка слиянием |
| :x: | Пирамидальная сортировка |
