package com.bmcotuk.mockito.business;

import com.bmcotuk.mockito.api.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Author: B. Mert Cotuk
 * Date:   25.01.2019
 * Time:   10:22
 * https://github.com/bmertcotuk
 */

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMockTest {

    @Mock
    TodoService todoServiceMock;
    // TodoService todoServiceMock = mock(TodoService.class);

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;
    // TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

    @Test
    public void testWithMock() {

        List<String> toDos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(toDos);

        List<String> springToDos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        assertEquals(2, springToDos.size());
        assertTrue(springToDos.contains("Learn Spring"));
        assertTrue(springToDos.contains("Learn Spring MVC"));
    }

    @Test
    public void testWithMockEmptyList() {

        List<String> toDos = Arrays.asList();
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(toDos);

        List<String> springToDos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0, springToDos.size());
        assertTrue(!springToDos.contains("Learn Spring"));
        assertTrue(!springToDos.contains("Learn Spring MVC"));
    }
}