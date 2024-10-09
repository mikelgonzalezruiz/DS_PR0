package edu.uoc.ds.adt;

import edu.uoc.test.util.FunctionUtils;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR0StackTest {

    PR0Stack<Integer> pr1s;

    private void fillStack() {
        FunctionUtils.generateValues(FunctionUtils.periodicFunction, 15).forEach(pr1s::push);
    }

    @Before
    public void setUp() {
        this.pr1s = new PR0Stack<>();

        assertNotNull(this.pr1s.getStack());
        this.fillStack();
    }

    @After
    public void release() {
        this.pr1s = null;
    }

    @Test
    public void stackTest() {

        assertEquals(this.pr1s.CAPACITY, this.pr1s.getStack().size());
        assertEquals(9, this.pr1s.getStack().pop(), 0);
        assertEquals(4, this.pr1s.getStack().pop(), 0);
        assertEquals(1, this.pr1s.getStack().pop(), 0);
        assertEquals(0, this.pr1s.getStack().pop(), 0);
        assertEquals(9, this.pr1s.getStack().pop(), 0);
        assertEquals(4, this.pr1s.getStack().pop(), 0);
        assertEquals(1, this.pr1s.getStack().pop(), 0);
        assertEquals(0, this.pr1s.getStack().pop(), 0);
        assertEquals(9, this.pr1s.getStack().pop(), 0);
        assertEquals(4, this.pr1s.getStack().pop(), 0);
        assertEquals(1, this.pr1s.getStack().pop(), 0);
        assertEquals(0, this.pr1s.getStack().pop(), 0);
        assertEquals(9, this.pr1s.getStack().pop(), 0);
        assertEquals(4, this.pr1s.getStack().pop(), 0);
        assertEquals(1, this.pr1s.getStack().pop(), 0);
        assertEquals(0, this.pr1s.getStack().size());
    }
}