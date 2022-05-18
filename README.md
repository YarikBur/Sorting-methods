# Методы сортировки [![Build Status](https://img.shields.io/badge/Version-2022/05/18-red.svg)](#SortingMethods)
Разновидности методов сортировки на Java.
<hr>

### Ссылки
[Описание проекта](#описание-проекта)

[Примеры](#примеры)

[Добавленные методы сортировок](#добавленные-методы-сортировок)

<hr>

## Описание проекта
Проект создан с целью личного ознакомления с методами сортировки.

Путь к файлу, в котором будет записан результат времени сортировки.
```java
private static final String FILE_PATH = "F:\\Desktop\\methods.xls";
```

Сколько раз надо будет повторять сортировку массива одной длины (заполнение у массива каждый раз генерируется).
```java
private static final int ATTEMPTS = 3;
```

В основном файле можно указать классы (методы сортировки), которые будут работать с массивами.
```java
private static SortingMethod[] methods = {
  new BoubleSorting(),
  new ShakerSorting(),
  new CombSorting(),
  new InsertSorting()
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
| :x: | Сортировка выбором |
| :x: | Быстрая сортировка |
| :x: | Сортировка слиянием |
| :x: | Пирамидальная сортировка |
