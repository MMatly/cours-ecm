package fr.cmm.tags;

import static org.junit.Assert.*;
import org.junit.Test;

public class FunctionsTest {

    @Test
    public void showstring() {
    assertEquals("a", Functions.text("a"));}

    @Test
    public void espace() {
        assertEquals("a<br>", Functions.text("a\n"));}


    @Test
    public void symbols() {
        assertEquals("&amp;a", Functions.text("&a"));}







}