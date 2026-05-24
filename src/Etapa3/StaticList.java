package Etapa3;

public class StaticList<E> implements List<E> {
    private Object[] elements;
    private int numElements;

    public StaticList() {
        this(10);
    }

    public StaticList(int capacidade) {
        elements = new Object[capacidade];
        numElements = 0;
    }

    public int contaElementos(E element) {
        return contaElementosRecursivo(element, 0);
    }

    private int contaElementosRecursivo(E element, int pos) {
        if (pos >= numElements) {
            return 0;
        }

        int atual = elements[pos] == null ? (element == null ? 1 : 0) : (elements[pos].equals(element) ? 1 : 0);
        return atual + contaElementosRecursivo(element, pos + 1);
    }

    @Override
    public int numElements() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public boolean isFull() {
        return numElements == elements.length;
    }

    @Override
    public void insert(E element, int pos) {
        if (isFull()) {
            throw new OverflowException();
        }
        if (pos < 0 || pos > numElements) {
            throw new IndexOutOfBoundsException("Posicao invalida.");
        }

        for (int i = numElements; i > pos; i--) {
            elements[i] = elements[i - 1];
        }
        elements[pos] = element;
        numElements++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int pos) {
        if (pos < 0 || pos >= numElements) {
            throw new IndexOutOfBoundsException("Posicao invalida.");
        }

        E removido = (E) elements[pos];
        for (int i = pos; i < numElements - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[numElements - 1] = null;
        numElements--;
        return removido;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int pos) {
        if (pos < 0 || pos >= numElements) {
            throw new IndexOutOfBoundsException("Posicao invalida.");
        }
        return (E) elements[pos];
    }

    @Override
    public int search(E element) {
        for (int i = 0; i < numElements; i++) {
            if (elements[i] == null ? element == null : elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
}
