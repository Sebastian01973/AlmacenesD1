package structures.doublyList;

import java.util.Comparator;

public class DoublyList<T> {

    private Node<T> head;
    private Comparator<T> comparator;

    public DoublyList(Comparator<T> comparator) {
        this.comparator = comparator;
        head = null;
    }

    public boolean isEmpty(){ return head == null; }

    public void insert(T data){
        if (isEmpty()){
            head = new Node<>(data);
        }else{
            Node<T> aux = head;
            while (aux.getNext() != null){
                aux = aux.getNext();
            }
            Node<T> next = new Node<>(data);
            next.setPrevious(aux);
            aux.setNext(next);
        }
    }

    public String showBackword() {
        String string = "";
        if (isEmpty()) {
            string = "Empty List";
        }else {
            Node<T> aux = head;
            while(aux.getNext()!=null) {
                aux = aux.getNext();
            }
            while (aux != null){
                string+=aux.getData()+"<--";
                aux = aux.getPrevious();
            }

        }
        return string;
    }

    public String show() {
        String string = "";
        if (isEmpty()) {
            string = "Empty List";
        }else {
            Node<T> aux = head;
            while(aux!=null) {
                string+=aux.getData().toString()+"-->";
                aux = aux.getNext();
            }
        }
        return string;
    }

    public Node<T> getNode(int index){
        if (isEmpty() || index < 0 || index >= size()){
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
        if (isEmpty() || index < 0 || index >= size()){
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

    public boolean exist(T data){
        Node<T> aux = head;
        while (aux != null){
            if ((comparator.compare(aux.getData(),data)) == 0){
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public void remove(T data) {
        if (!isEmpty()) {
            Node<T> current = head;
            Node<T> previous = null;
            if ((comparator.compare(current.getData(),data)) == 0) {
                head = current.getNext();
                head.setPrevious(null);
                current = null;
            }
            while(current != null) {
                if((comparator.compare(current.getData(),data)) == 0){
                    previous.setNext(current.getNext());
                   if ( current.getNext() != null) {
                       current.getNext().setPrevious(previous);
                   }
                }else {
                    previous = current;
                }
                current = (current.getData() == data) ? null:current.getNext();
            }
        }
    }

}
