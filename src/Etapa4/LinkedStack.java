package Etapa4;

public class LinkedStack<E> implements Stack<E> {
    private Node<E> top;
    private int numElements;

    @Override
    public void push(E element) throws OverflowException {
        Node<E> novo = new Node<>(element);
        novo.setNext(top);
        top = novo;
        numElements++;
    }

    @Override
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        E element = top.getElement();
        top = top.getNext();
        numElements--;
        return element;
    }

    @Override
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return top.getElement();
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int numElements() {
        return numElements;
    }
}
