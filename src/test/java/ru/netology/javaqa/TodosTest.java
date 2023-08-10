package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.rmi.StubNotFoundException;

public class TodosTest {
    // ТЕСТ СОЗДАНИЯ ЕДИНОГО МАССИВА ХРАНЕНИЯ ЗАДАЧ
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    // ТЕСТЫ search из Todos
    @Test
    public void TaskMatchesEmptyFalse() {
        Task task = new Task(1);

        String query = "Two";
        boolean expected = false;
        boolean actual = task.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    // ТЕСТЫ МЕТОДА mathes для всех трёх классов
    // Общий массив, все элементы - запросы
    @Test
    public void TodosSearchAllIsQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "One");
        String[] subtasks = {"One", "Two", "Three",};
        Epic epic = new Epic(123, subtasks);
        Meeting meeting = new Meeting(
                145,
                "One",
                "Four",
                "Five"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "One";

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    // ОБщий массив, есть Симпл и Эпик
    @Test
    public void TodosSearchSimpleAndEpicIsQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "One");
        String[] subtasks = {"One", "Two", "Three",};
        Epic epic = new Epic(123, subtasks);
        Meeting meeting = new Meeting(
                345,
                "Three",
                "Four",
                "Five"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "One";

        Task[] expected = {simpleTask, epic};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    // Общий массив, есть Симпл и Митинг
    @Test
    public void TodosSearchSimpleAndMeetingIsQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "One");
        String[] subtasks = {"Two", "Three",};
        Epic epic = new Epic(123, subtasks);
        Meeting meeting = new Meeting(
                145,
                "One",
                "Four",
                "Five"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "One";

        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    // Общий массив, есть Эпик и Митинг
    @Test
    public void TodosSearchEpicAndMeetingIsQuery() {
        SimpleTask simpleTask = new SimpleTask(2, "Two");
        String[] subtasks = {"One", "Two", "Three",};
        Epic epic = new Epic(123, subtasks);
        Meeting meeting = new Meeting(
                145,
                "One",
                "Four",
                "Five"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "One";

        Task[] expected = {epic, meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    // Общий массив, есть Симпл
    @Test
    public void TodosSearchSimpleIsQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "One");
        String[] subtasks = {"Two", "Three",};
        Epic epic = new Epic(123, subtasks);
        Meeting meeting = new Meeting(
                345,
                "Three",
                "Four",
                "Five"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "One";

        Task[] expected = {simpleTask};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    // Общий массив, есть Эпик
    @Test
    public void TodosSearchEpicIsQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "One");
        String[] subtasks = {"One", "Two", "Three",};
        Epic epic = new Epic(123, subtasks);
        Meeting meeting = new Meeting(
                145,
                "One",
                "Four",
                "Five"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "Two";

        Task[] expected = {epic};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    // Общий массив, есть Митинг
    @Test
    public void TodosSearchMeetingIsQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "One");
        String[] subtasks = {"One", "Two", "Three",};
        Epic epic = new Epic(123, subtasks);
        Meeting meeting = new Meeting(
                145,
                "One",
                "Four",
                "Five"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "Four";

        Task[] expected = {meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    // Общий массив, запросов нет
    @Test
    public void TodosSearchNoneIsQuery() {
        SimpleTask simpleTask = new SimpleTask(1, "One");
        String[] subtasks = {"One", "Two", "Three",};
        Epic epic = new Epic(123, subtasks);
        Meeting meeting = new Meeting(
                145,
                "One",
                "Four",
                "Five"
        );
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        String query = "Ten";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }
}
