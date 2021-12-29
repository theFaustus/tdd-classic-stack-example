package com.evil.inc.tdd;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class IntStackTest {
    private IntStack stack;

    //todo('can create a stack');
    //todo('is empty when created');
    //todo('starts with stack size of 0');
    //todo('is not empty when pushed');
    //todo('stack size is 1 when pushed');
    //todo('stack is empty when pushed and popped');
    //todo('stack size is 0 when pushed and popped');
    //todo('throws overflow error when pushing to a stack at full capacity');
    //todo('throw underflow error when popping an empty stack');
    //todo('pops the same one item when pushed');
    //todo('pops two items with the most recent first');
    //todo('accepts only a positive capacity');

    @BeforeEach
    private void setUp() {
        this.stack = new IntStack();
    }

    @Test
    public void stackWhenCreatedShouldBeEmpty(){
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    public void stackWhenCreatedShouldHaveSizeZero(){
        assertThat(stack.size()).isZero();
    }

    @Test
    public void stackIsNotEmptyWhenPushed(){

        stack.push(1);

        assertThat(stack.isEmpty()).isFalse();
        assertThat(stack.size()).isEqualTo(1);
    }

    @Test
    public void stackSizeIsZeroAfterOnePushAndOnePop(){
        stack.push(1);
        stack.pop();

        assertThat(stack.isEmpty()).isTrue();
        assertThat(stack.size()).isZero();
    }

    @Test
    public void stackThrowsOverflowExceptionWhenAtFullCapacity(){
        stack = new IntStack(2);
        stack.push(1);
        stack.push(2);

        assertThatThrownBy(() -> stack.push(3))
                .hasMessage("Overflow");
    }

    @Test
    public void stackThrowsUnderflowExceptionWhenAtLowCapacity(){
        stack = new IntStack(2);
        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.pop();

        assertThatThrownBy(() -> stack.pop())
                .hasMessage("Underflow");
    }

    @Test
    public void shouldPopTheSameItemThatWasPushed(){
        stack = new IntStack(2);
        stack.push(1);

        assertThat(stack.pop()).isEqualTo(1);
    }

    @Test
    public void shouldPopTwoElementsInInversOrderOfHowTheyWerePushed(){
        stack = new IntStack(2);
        stack.push(1);
        stack.push(2);

        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
    }

}
