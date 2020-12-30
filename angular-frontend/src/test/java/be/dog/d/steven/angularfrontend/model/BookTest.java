package be.dog.d.steven.angularfrontend.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    @Test
    public void testCanEqual() {
        assertFalse((new Book()).canEqual("other"));
    }

    @Test
    public void testCanEqual2() {
        Book book = new Book();
        assertTrue(book.canEqual(new Book()));
    }

    @Test
    public void testEquals() {
        assertFalse((new Book()).equals("o"));
    }

    @Test
    public void testEquals2() {
        Book book = new Book();
        assertTrue(book.equals(new Book()));
    }

    @Test
    public void testEquals3() {
        Book o = new Book(1, "Name", "JaneDoe");
        assertFalse((new Book()).equals(o));
    }

    @Test
    public void testEquals4() {
        Book book = new Book(1, "Name", "JaneDoe");
        assertTrue(book.equals(new Book(1, "Name", "JaneDoe")));
    }

    @Test
    public void testEquals5() {
        Book o = new Book(0, "Name", "JaneDoe");
        assertFalse((new Book()).equals(o));
    }

    @Test
    public void testEquals6() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        assertFalse(book.equals(new Book()));
    }

    @Test
    public void testEquals7() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        assertFalse((new Book()).equals(book));
    }

    @Test
    public void testEquals8() {
        Book book = new Book(1, "JaneDoe", "JaneDoe");
        assertFalse(book.equals(new Book(1, "Name", "JaneDoe")));
    }

    @Test
    public void testHashCode() {
        assertEquals(207959, (new Book()).hashCode());
        assertEquals(-19499439, (new Book(1, "Name", "JaneDoe")).hashCode());
    }

    @Test
    public void testSetAuthor() {
        Book book = new Book();
        book.setAuthor("JaneDoe");
        assertEquals("JaneDoe", book.getAuthor());
    }

    @Test
    public void testSetId() {
        Book book = new Book();
        book.setId(1);
        assertEquals(1, book.getId());
    }

    @Test
    public void testSetName() {
        Book book = new Book();
        book.setName("Name");
        assertEquals("Name", book.getName());
    }

    @Test
    public void testToString() {
        assertEquals("Book(id=0, name=null, author=null)", (new Book()).toString());
    }
}

