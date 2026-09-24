package tp2efficace;

public class SinglyListClass {

	private Node header;
	private int size;
	
	public SinglyListClass(Node header) {
		this.header = header;
//		header = null;
		size = 0;
	}

	public Integer getHeader( ) {
		return header.element;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		int listSize = size();
		if (listSize == 0 ) {
			return false;
		} else return true;
	}

	public Integer first() {
		if(header == null) { //header.getElement() == null?
			return null;
		}
		return header.getElement();
	}

	public Integer last() {
		Node tmpHeader = header;
		if (header == null) {
		return null;
	}
		while (tmpHeader.getNext() != null) { //on s'arrete sur l'avant dernier pas le dernier (null)
			tmpHeader = tmpHeader.getNext();
		}
		return tmpHeader.element; //tmpHeader.getElement();
	}


	public void addFirst(Integer element) {

		Node newNode = new Node(element);

		if (header == null) {
			header = newNode;
			size++;
			return;
		}

		Node tmpHeader = header;
		header = newNode;
		header.setNext(tmpHeader);
		size++;

	}

	public void addLast(Integer element) {
		Node newNode = new Node(element);
		Node tmpHeader = header;
		if (header == null) {
			header = newNode;
			size++;
			return;
		}

		while (tmpHeader.getNext() != null) { //on s'arrete sur l'avant dernier pas le dernier (null)
			tmpHeader = tmpHeader.getNext();
		}
		// on sait que on point vers le dernier de la liste et que le next et null toujours...
//		if (tmpHeader.getNext() == null ) { // si tmpHeader is null alors on est sur le dernier element...
//			// on positionne tmpHeader dans le t

		tmpHeader.setNext(newNode);
		size++;
	}

	public void removeFirst() {
		//TODO
		header = header.getNext();
		size--;
	}


	private static class Node {

		private Integer element;
		private Node next;

		public Node(Integer element) {
			this.element = element;
			next = null; //normalement java le mets automatique a null mais on assure...
		}

//		public Node(Integer element, Node n) {
//			this.element = element;
//			next = null;
//		}

		public Integer getElement() {
			return element;
		}

		public Node getNext( ) {
			return next;
		}

		public void setElement(Integer newElement) {
			element = newElement;
		}

		public void setNext(Node newNext) {
			next = newNext;
		}

		public String toString() {
			return element.toString();
		}

	}


	public static void main(String[] args) {
		SinglyListClass myList = new SinglyListClass(null);
		myList.addLast(8);
		myList.addFirst(6);


//		System.out.println(myList); //returns address memoire...
		System.out.println(myList.getHeader());
		System.out.println(myList.last());
		System.out.println(myList.first());

	}

}
