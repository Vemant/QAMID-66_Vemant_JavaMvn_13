package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    // ТЕСТЫ СИМПЛ
    // Симпл Запрос есть
    @Test
    public void matchesSimpleTaskQueryTrue() {
        SimpleTask simpleTask = new SimpleTask(
                1,
                "One"
        );
        String query = "One";
        boolean expected = true;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    // Симпл Запроса нет
    @Test
    public void matchesSimpleTaskQueryFalse() {
        SimpleTask simpleTask = new SimpleTask(
                1,
                "One"
        );
        String query = "Two";
        boolean expected = false;
        boolean actual = simpleTask.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    // ТЕСТЫ ЭПИК
    // Запрос в массиве есть
    @Test
    public void matchesEpicQueryTrue() {
        String[] subtasks = {"One", "Two", "Three"};
        Epic epic = new Epic(5, subtasks);

        String query = "Two";
        boolean expected = true;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    // Запроса в массиве нет
    @Test
    public void matchesEpicQueryFalse() {
        String[] subtasks = {"One", "Two", "Three"};
        Epic epic = new Epic(5, subtasks);

        String query = "Four";
        boolean expected = false;
        boolean actual = epic.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    // ТЕСТЫ МИТИНГ
    // Запрос топик есть
    @Test
    public void matchesMeetingQueryTopicTrueProjectFalseStartFalse() {
        Meeting meeting = new Meeting(
                1,
                "One",
                "Two",
                "Three"
        );

        String query = "One";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    // Запроса проджект есть
    @Test
    public void matchesMeetingQueryTopicFalseProjectTrueStartFalse() {
        Meeting meeting = new Meeting(1, "One", "Two", "Three");

        String query = "Two";
        boolean expected = true;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    // Старт есть, топика и проджекта нет
    @Test
    public void matchesMeetingQueryTopicFalseProjectFalseStartTrue() {
        Meeting meeting = new Meeting(1, "One", "Two", "Three");

        String query = "Three";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    // Ни топика, ни проджекта, ни старта нет
    @Test
    public void matchesMeetingQueryTopicFalseProjectFalseStartFalse() {
        Meeting meeting = new Meeting(1, "One", "Two", "Three");

        String query = "Four";
        boolean expected = false;
        boolean actual = meeting.matches(query);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetId() {
        Task task = new Task(1);
        int expected = 1;
        int actual = task.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetTitleOnSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "One");
        String expected = "One";
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSubtasksOnEpic() {
        String[] subtasks = {"One", "Two", "Three"};
        Epic epic = new Epic(1, subtasks);
        String[] expected = {"One", "Two", "Three"};
        String[] actual = epic.getSubtasks();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetTopicInMeeting() {
        Meeting meeting = new Meeting(1, "One", "Two", "Three");
        String expected = "One";
        String actual = meeting.getMeetingTopic();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetProjectInMeeting() {
        Meeting meeting = new Meeting(1, "One", "Two", "Three");
        String expected = "Two";
        String actual = meeting.getMeetingProject();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetStartInMeeting() {
        Meeting meeting = new Meeting(1, "One", "Two", "Three");
        String expected = "Three";
        String actual = meeting.getMeetingStart();
        Assertions.assertEquals(expected, actual);
    }
}
