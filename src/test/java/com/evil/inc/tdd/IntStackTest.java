package com.evil.inc.tdd;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class IntStackTest {

    private IntStack stack;

    @BeforeEach
    public void beforeEach(){
        stack = new IntStack(2);
    }

    @Test
    public void size_withNewStack_returnsZero(){
        assertThat(stack.size()).isZero();
    }

    @Test
    public void size_afterOnePush_returnsOne(){
        stack.push(1);
        assertThat(stack.size()).isEqualTo(1);
    }

    @Test
    public void size_afterOnePushAndOnePop_returnsZero(){
        stack.push(1);
        stack.pop();
        assertThat(stack.size()).isZero();
    }

    @Test
    public void pop_afterPushWithTen_returnsTen(){
        stack.push(10);
        assertThat(stack.pop()).isEqualTo(10);
    }

    @Test
    public void pop_whenStackIsEmpty_throwsStackUnderflowException(){
        assertThatExceptionOfType(IntStack.StackUnderflowException.class).isThrownBy(() -> stack.pop());
    }

    @Test
    public void pop_invokedTwoTimesAfterTwoPush_returnsElementsInReverseOrder(){
        stack.push(1);
        stack.push(2);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    public void push_whenStackExceedsCapacity_throwsStackOverflowException(){
        stack.push(1);
        stack.push(2);
        assertThatExceptionOfType(IntStack.StackOverflowException.class).isThrownBy(() -> stack.push(3));
    }

    @Test
    public void newStack_withInvalidCapacity_throwsIllegalStackCapacityException(){
        assertThatExceptionOfType(IntStack.IllegalStackCapacityException.class).isThrownBy(() -> new IntStack(-1));
    }


    @Test
    public void isEmpty_withNotEmptyStack_returnsFalse(){
        stack.push(1);
        assertThat(stack.isEmpty()).isFalse();
    }

    @Test
    public void isEmpty_withEmptyStack_returnsTrue(){
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    public void top_afterOnePush_returnsFirstElement(){
        stack.push(3);
        assertThat(stack.top()).isEqualTo(3);
    }

    @Test
    public void top_afterTwoPushAndOnePop_returnsFirstElement(){
        stack.push(3);
        stack.push(4);
        stack.pop();
        assertThat(stack.top()).isEqualTo(3);
    }

    @Test
    public void top_whenStackIsEmpty_throwsStackUnderflowException(){
        assertThatExceptionOfType(IntStack.StackUnderflowException.class).isThrownBy(() -> stack.top());

    }
}
