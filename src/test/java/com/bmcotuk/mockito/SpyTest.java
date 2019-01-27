package com.bmcotuk.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Author: B. Mert Cotuk
 * Date:   27.01.2019
 * Time:   17:34
 * https://github.com/bmertcotuk
 */

@RunWith(MockitoJUnitRunner.class)
public class SpyTest {

    // we don't care about implementaion, interfaces are welcome
    @Mock
    List arrayListMock;

    // it should have an implementaiton, cannot use interface here
    @Spy
    ArrayList arrayListSpy;
    
    @Test
    public void testMock() {

        assertEquals(0, arrayListMock.size());

        // practically all of the three do the same thing
        // the last line wins
        when(arrayListMock.size()).thenReturn(6);
        given(arrayListMock.size()).willReturn(7);
        stub(arrayListMock.size()).toReturn(5);
        assertEquals(5, arrayListMock.size());

        arrayListMock.add("dummy");
        assertEquals(5, arrayListMock.size());

        // you can check behavior with verify method in mocks
        verify(arrayListMock).add("dummy");
    }

    // avoid spies as much as possible
    // they are useful only where you do not have access to the legacy code on an old project
    @Test
    public void testSpy() {

        assertEquals(0, arrayListSpy.size());
        arrayListSpy.add("dummy");
        assertEquals(1, arrayListSpy.size());

        given(arrayListSpy.size()).willReturn(7);
        assertEquals(7, arrayListSpy.size());

        // there is no return once overridden by stubbing
        arrayListSpy.add("dummy");
        assertEquals(7, arrayListSpy.size());

        // you can check behavior with verify method in spies
        verify(arrayListSpy).add("dummy");
    }
}
