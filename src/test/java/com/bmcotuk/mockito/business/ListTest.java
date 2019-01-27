package com.bmcotuk.mockito.business;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Author: B. Mert Cotuk
 * Date:   25.01.2019
 * Time:   17:27
 * https://github.com/bmertcotuk
 */
public class ListTest {

    @Test
    public void testListSize() {
        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(2);
        assertEquals(2, mockList.size());
    }

    @Test
    public void testListMultipleValues() {
        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, mockList.size());
        assertEquals(3, mockList.size());
    }

    @Test
    public void testListGet() {
        List mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("element");
        assertEquals("element", mockList.get(0));
        assertEquals(null, mockList.get(1));
    }

    @Test
    public void testListGetWithArgumentMatcher() {
        List mockList = mock(List.class);
        when(mockList.get(anyInt())).thenReturn("element");
        assertEquals("element", mockList.get(0));
        assertEquals("element", mockList.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void testListWithException() {
        List mockList = mock(List.class);
        when(mockList.get(anyInt())).thenThrow(new RuntimeException());
    }

    @Test
    public void testListGetWithArgumentMatcherAndMoreValues() {
        List mockList = mock(List.class);
        when(mockList.subList(anyInt(),5)).thenThrow(new RuntimeException());
    }
}