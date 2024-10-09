package edu.uoc.ds.adt;

import edu.uoc.test.util.FunctionUtils;
import org.junit.After;
import org.junit.Before;

import org.junit.Assert;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PR0QueueTest {

    PR0Queue<Integer> pr1q;

    private void fillQueue() {
        FunctionUtils.generateValues(FunctionUtils.periodicFunction, 15).forEach(pr1q::add);
    }

    @Before
    public void setUp() {
        this.pr1q = new PR0Queue<>();

        assertNotNull(this.pr1q.getQueue());
        fillQueue();
    }

    @After
    public void release() {
        this.pr1q = null;
    }

    @org.junit.Test
    public void queueTest() {
        assertEquals(this.pr1q.CAPACITY, this.pr1q.getQueue().size());
        Assert.assertEquals(1, pr1q.getQueue().poll(), 0);
        Assert.assertEquals(4, pr1q.getQueue().poll(), 0);
        Assert.assertEquals(9, pr1q.getQueue().poll(), 0);
        Assert.assertEquals(0, pr1q.getQueue().poll(), 0);
        Assert.assertEquals(1, pr1q.getQueue().poll(), 0);
        Assert.assertEquals(4, pr1q.getQueue().poll(), 0);
        Assert.assertEquals(9, pr1q.getQueue().poll(), 0);
        Assert.assertEquals(0, pr1q.getQueue().poll(), 0);
        Assert.assertEquals(1, pr1q.getQueue().poll(), 0);
        Assert.assertEquals(4, pr1q.getQueue().poll(), 0);
        Assert.assertEquals(9, pr1q.getQueue().poll(), 0);
        Assert.assertEquals(0, pr1q.getQueue().poll(), 0);
        Assert.assertEquals(1, pr1q.getQueue().poll(), 0);
        Assert.assertEquals(4, pr1q.getQueue().poll(), 0);
        Assert.assertEquals(9, pr1q.getQueue().poll(), 0);
        assertEquals(0, this.pr1q.getQueue().size());
    }
}