package com.bmcotuk.mockito.api;

import java.util.Arrays;
import java.util.List;

/**
 * Author: B. Mert Cotuk
 * Date:   25.01.2019
 * Time:   10:18
 * https://github.com/bmertcotuk
 */
public class TodoServiceStub implements TodoService {

    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn Dance");
    }

    public void deleteTodo(String todo) {

    }
}
