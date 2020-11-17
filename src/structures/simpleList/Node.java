package structures.simpleList;

public class Node<T> {

	private Node<T> next;
	private T data;
	
	public Node(T data) {
		next = null;
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getNext() {
		return next;
	}

	public T getData() {
		return data;
	}

	@Override
	public String toString() {
		return String.valueOf(data);
	}

}
