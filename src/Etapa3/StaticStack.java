package Etapa3;

public class StaticStack<E> implements Stack<E> {
    private Object[] elements;
    private int top;

    public StaticStack() {
        this(10);
    }

    public StaticStack(int capacidade) {
        elements = new Object[capacidade];
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top == elements.length - 1;
    }

    @Override
    public int numElements() {
        return top + 1;
    }

    @Override
    public void push(E element) throws OverflowException {
        if (isFull()) {
            throw new OverflowException();
        }
        elements[++top] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        E element = (E) elements[top];
        elements[top--] = null;
        return element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return (E) elements[top];
    }
}
