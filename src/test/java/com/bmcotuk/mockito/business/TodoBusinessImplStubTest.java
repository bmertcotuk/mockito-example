package com.bmcotuk.mockito.business;

import com.bmcotuk.mockito.api.TodoService;
import com.bmcotuk.mockito.api.TodoServiceStub;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Author: B. Mert Cotuk
 * Date:   25.01.2019
 * Time:   10:22
 * https://github.com/bmertcotuk
 */
public class TodoBusinessImplStubTest {

    @Test
    public void testWithStub() {
        /*
            just like:
                List list = new ArrayList();
            where List is an interface and ArrayList is an implementation

         */
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);

        List<String> springToDos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, springToDos.size());
        assertTrue(springToDos.contains("Learn Spring"));
        assertTrue(springToDos.contains("Learn Spring MVC"));
    }
}