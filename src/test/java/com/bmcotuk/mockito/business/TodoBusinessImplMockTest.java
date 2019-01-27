package com.bmcotuk.mockito.business;

import com.bmcotuk.mockito.api.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Author: B. Mert Cotuk
 * Date:   25.01.2019
 * Time:   10:22
 * https://github.com/bmertcotuk
 */
public class TodoBusinessImplMockTest {

    @Test
    public void testWithMock() {

        // BDD: Behavior-driven development (given, when, then of scenarios)

        // 1) GIVEN
        // create a mock
        TodoService todoServiceMock = mock(TodoService.class);
        // define behaviour, i.e. stub it
        List<String> toDos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Dance");
        // when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(toDos);
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(toDos); // the same functionality with different syntax
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

        // 2) WHEN
        List<String> springToDos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        // 3) THEN
        // assertEquals(2, springToDos.size());
        assertThat(springToDos.size(), is(2)); // the same functionality with more readable syntax
        assertTrue(springToDos.contains("Learn Spring"));
        assertTrue(springToDos.contains("Learn Spring MVC"));
    }

    @Test
    public void testWithMockEmptyList() {

        // create a mock
        TodoService todoServiceMock = mock(TodoService.class);

        // define behaviour
        List<String> toDos = Arrays.asList();
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(toDos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> springToDos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0, springToDos.size());
        assertTrue(!springToDos.contains("Learn Spring"));
        assertTrue(!springToDos.contains("Learn Spring MVC"));
    }
}