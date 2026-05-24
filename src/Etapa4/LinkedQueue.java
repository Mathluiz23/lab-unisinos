package Etapa4;

public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> back;
    private int numElements;

    @Override
    public void enqueue(E element) throws OverflowException {
        Node<E> novo = new Node<>(element);
        if (isEmpty()) {
            front = novo;
        } else {
            back.setNext(novo);
        }
        back = novo;
        numElements++;
    }

    @Override
    public E dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        E element = front.getElement();
        front = front.getNext();
        numElements--;
        if (isEmpty()) {
            back = null;
        }
        return element;
    }

    public E first() throws UnderflowException {
        return front();
    }

    @Override
    public E front() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return front.getElement();
    }

    @Override
    public E back() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return back.getElement();
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
