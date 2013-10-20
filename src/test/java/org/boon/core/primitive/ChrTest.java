package org.boon.core.primitive;


import org.junit.Test;

import static org.boon.core.primitive.Chr.*;
import static org.junit.Assert.*;

public class ChrTest {


    @Test
    public void allocate() {

        char[] letters =
                arrayOfChar(500);

        assertEquals(
                500,
                len(letters)
        );

    }


    @Test
    public void create() {

        char[] letters =
                array('a', 'b', 'c', 'd');

        assertEquals(
                4,
                len(letters)
        );

    }


    @Test
    public void index() {

        char[] letters =
                array('a', 'b', 'c', 'd');

        assertEquals(
                'a',
                idx(letters, 0)
        );


        assertEquals(
                'd',
                idx(letters, -1)
        );


        assertEquals(
                'd',
                idx(letters, letters.length - 1)
        );


        idx(letters, 1, 'z');

        assertEquals(
                'z',
                idx(letters, 1)
        );
    }

    @Test
    public void isIn() {

        char[] letters =
                array('a', 'b', 'c', 'd');


        assertTrue(
                in('a', letters)
        );

        assertFalse(
                in('z', letters)
        );

    }

    @Test
    public void slice() {

        char[] letters =
                array('a', 'b', 'c', 'd');


        assertArrayEquals(
                array('a', 'b'),
                slc(letters, 0, 2)
        );

        assertArrayEquals(
                array('b', 'c'),
                slc(letters, 1, -1)
        );

        //>>> letters[2:]
        //['c', 'd']
        //>>> letters[-2:]
        //['c', 'd']

        assertArrayEquals(
                array('c', 'd'),
                slc(letters, -2)
        );


        assertArrayEquals(
                array('c', 'd'),
                slc(letters, 2)
        );


        //>>> letters[:-2]
        //     ['a', 'b']
        assertArrayEquals(
                array('a', 'b'),
                slcEnd(letters, -2)
        );


        //>>> letters[:-2]
        //     ['a', 'b']
        assertArrayEquals(
                array('a', 'b'),
                slcEnd(letters, 2)
        );

    }




    @Test
    public void outOfBounds() {

        char[] fruit =
                array('a', 'b', 'c', 'd', 'e');

        slcEnd(fruit, 100);
        slcEnd(fruit, -100);

        slc(fruit, 100);
        slc(fruit, -100);
        idx(fruit, 100);
        idx(fruit, -100);


        idx(fruit, 100, 'x');


        idx(fruit, -100, 'z');


        assertEquals(
                'x',
                idx(fruit, -1)
        );


        assertEquals(
                'z',
                idx(fruit, 0)
        );

    }



    @Test
    public void growTest() {
        char[] letters =
                array('a', 'b', 'c', 'd', 'e');

        letters = grow( letters,  21);


        assertEquals(
                'e',
                idx(letters, 4)
        );


        assertEquals(
                'a',
                idx(letters, 0)
        );




        assertEquals(
                len(letters),
                26
        );


        assertEquals(
                '\0',
                idx(letters, 20)
        );


        letters =  shrink ( letters, 23 );

        assertArrayEquals(
                array('a', 'b', 'c'),
                letters

        );

    }



    @Test
    public void growFast() {
        char[] letters =
                array('a', 'b', 'c', 'd', 'e');

        letters = grow( letters );


        assertEquals(
                'e',
                idx(letters, 4)
        );


        assertEquals(
                'a',
                idx(letters, 0)
        );




        assertEquals(
                len(letters),
                10
        );


        assertEquals(
                '\0',
                idx(letters, 9)
        );


    }



    @Test
    public void compactTest() {
        char[] letters =
                array('a', 'b', '\0', '\0', '\0', '\0', '\0', 'c', '\0', 'd', 'e');

        letters = compact(letters);

        assertArrayEquals(
                array('a', 'b', 'c', 'd', 'e'),
                letters

        );



    }


    @Test
    public void copyTest() {

        assertArrayEquals(
                array('a', 'b', 'c', 'd', 'e'),
                copy(array('a', 'b', 'c', 'd', 'e'))

        );



    }


    @Test
    public void addTest() {

        assertArrayEquals(
                array('a', 'b', 'c', 'd', 'e', 'f'),
                add(array('a', 'b', 'c', 'd', 'e'), 'f')

        );



    }

    @Test
    public void addTestArray() {

        assertArrayEquals(
                array('a', 'b', 'c', 'd', 'e', 'f', 'e'),
                add( array('a', 'b', 'c', 'd', 'e'), array('f', 'e') )

        );



    }

}
