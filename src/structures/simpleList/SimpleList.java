package structures.simpleList;

import java.util.Comparator;

public class SimpleList<T> {

    private Node<T> head;
    private Comparator<T> comparator;

    public SimpleList(Comparator<T> comparator){
        this.comparator = comparator;
        head = null;
    }

    public void remove(T data) {
        if (!isempty()) {
            Node<T> current = head;
            Node<T> previous = null;
            if ((comparator.compare(current.getData(),data)) == 0) {
                head = current.getNext();
                current = null;
            }
            while(current != null) {
                if((comparator.compare(current.getData(),data)) == 0){
                    previous.setNext(current.getNext());
                }else {
                    previous = current;
                }
                current = (current.getData() == data) ? null:current.getNext();
            }
        }
    }

    public Node<T> getNode(int index){
        if (isempty() || index < 0 || index >= size()){
            return null;
        }else if(index == 0){
            return head;
        }else{
            Node<T> aux = head;
            int count = 0;
            while (count < index){
                count++;
                aux = aux.getNext();
            }
            return aux;
        }
    }

    public T getData(int index){
        if (isempty() || index < 0 || index >= size()){
            return null;
        }else if(index == 0){
            return head.getData();
        }else{
            Node<T> aux = getNode(index);
            return aux.getData();
        }
    }


    public int size(){
        Node<T> aux = head;
        int count = 0;
        while (aux!=null){
            aux = aux.getNext();
            count++;
        }
        return count;
    }

    public void insert(T data) {
        if (isempty()) {
            head = new Node<>(data);
        }else {
            Node<T> aux = head;
            while(aux.getNext()!=null) {
                aux = aux.getNext();
            }
            Node<T> next = new Node(data);
            aux.setNext(next);
        }
    }

    public boolean isempty() {
        return head==null;
    }

    public boolean exist(T data){
        Node<T> aux = head;
        while (aux != null){
            if ((comparator.compare(aux.getData(),data)) == 0){
                return true;
            }else{
                aux = aux.getNext();
            }
        }
        return false;
    }

    public String show() {
        String string = "";
        if (isempty()) {
            string = "Empty List";
        }else {
            Node aux = head;
            while(aux!=null) {
                string+=aux.toString()+"\n";
                aux = aux.getNext();
            }
        }
        return string;
    }

}
