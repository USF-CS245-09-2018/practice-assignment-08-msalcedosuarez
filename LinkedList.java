public class LinkedList implements List {

	public class Node {
	
		public Object data;
		public Node next;

		public Node() {
			this.data = 0;
			this.next = null;
		}

		public Node(Object data) {
			this.data = data;
			next = null;
		}

		public Object getData() {
			return this.data;		
		}

		public Node getNext() {
			return this.next;
		}

		public void setData(Object data) {
			this.data = data;
		} 

		public void setNext(Node next) {
			this.next = next;
		}
	}
	
	private int size;
	private Node head;

	public LinkedList() {
		size = 0;
		head = null;
	}

	private Node getNode (int pos) {
		Node node = head;
		for (int i = 0; i < pos; i++){
			node = node.getNext();
		}
		return node;
	}

	public void add(Object obj) throws Exception {
		Node node = new Node (obj);
		node.setNext(head);
		head = node;
		size++;
	}

	public void add(int pos, Object obj) throws Exception {
		if (pos == 0){
			Node node = new Node();
			node.data = obj;
			node.next = head;
			head = node;
			++size;
		}
		else {
			Node previous = getNode(pos - 1);
			Node node = new Node();
			node.data = obj;
			node.next = previous.next;
			previous.next = node;
			++size;
		}

	}

	public Object get(int pos) throws Exception {
		if (pos < 0 || pos >= size){
			throw new Exception();
		}
		Node current = getNode(pos);
		return current.data;
	}

	public Object remove(int pos) throws Exception {
		if (pos < 0 || pos >= size){
			throw new Exception();
		}
		if (pos == 0){
			Node current = head;
			head = head.getNext();
			--size;
			return current.getData();
		}
		else {
			Node previous  = getNode(pos - 1);
			Node current = previous.next;
			previous.next = current.next;
			--size;
			return current.data;
		}
	}

	public int size() {
		return size;
	}
}