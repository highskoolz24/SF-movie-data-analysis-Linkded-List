package project3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Collection<E>, Iterable<E>{

	public LinkedList() {
		
	}
	
	private class Node<E>{
		private E element;
		private Node<E> next;
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		public E getElement() {return element;}
		public Node<E> getNext() { return next;}
		public void setNext(Node<E> n ) {next=n;}
	}
	
	private class linkIterator implements Iterator<E>{
		
		private Node<E> current = head;
		private int j =0;
		private boolean removable = false;
		
		@Override
		public boolean hasNext() {
			return j<size;
		}

		@Override
		public E next() throws NoSuchElementException{
			if (j==size) throw new NoSuchElementException();
			if (current==null)
				return null;
				
			removable=true;
			j++;
			Node<E> tmp=current;
			current=current.next;
			return tmp.element;
		}	
		
//		public void remove() throws IllegalStateException {
//			if(!removable) throw new IllegalStateException();
//			current.next=current.next.next;
//			size--;
//		}
	}
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	public int indexOf(Object o) {
		int counter= 0;
		Node<E> pointer = head;
		while (!head.getElement().equals(o)) {
			if(pointer.next==null) {
				return -1;
			}
			pointer=pointer.next;
			counter++;
		}
		return counter;	
	}
	
	public E get(int index) throws IndexOutOfBoundsException {
		if (index<0||index>=size()) {
			throw new IndexOutOfBoundsException();
		}
		
		Node<E> current =head;
		for(int i = 0; i<index; i++) {
			current = current.next;
		}
		return (E)current.element;
	}

	public String toString() {
		return null ;
	}
	
	public void sort ( ) { 
		Object [] array = toArray(); 
		Arrays.sort(array); 
		this.clear(); 
		for (Object o : array ) { 
			this.add( (E)o ); 
			} 
		}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		Node<E> current = head;
		while(current.next!=null) {
			current.element=null;
			current=current.next;
		}
	}

	@Override
	public boolean contains(Object o) {
		Node<E> current = head;
		while(current.next!=null) {
			if(current.element.equals(o)){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if (c.equals(this))
			return true;
		return false;
		
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) 
			return true;
		if(o==null)
			return false;
		if (getClass() != o.getClass()) 
			return false;
		LinkedList obj = (LinkedList)o;
		if (obj.size()!=this.size())
			return false;
		
		Iterator<E> itr1 = this.iterator();
		Iterator<E> itr2 = obj.iterator();
		
		while(itr1.hasNext()&&itr2.hasNext()) {
			if(!itr1.next().equals(itr2.next())) {
				return false;
			}
		}
		return true;
		
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public Iterator<E> iterator() {
		return new linkIterator();
	}

	@Override
	public boolean remove(Object o) {
//		if(head==null) 
//			return false;
//		Node<E> current = head;
//		if(head.element.equals(o)) {
//			head = head.next;
//			size--;
//			return true;
//		}
//		while(current.next!=null) {
//			if(current.element.equals(o)) {
//				current.next=current.next.next;
//				size--;
//				return true;
//				
//			}
//		}
		return false;
	}

//	public int findDuplicate() {
//		if(this.isEmpty()) {return -1;}
//		else {
//			Node<E> current = head;
//			while(current.next!=null) {
//				if (current.element.equals(current.next.element)) {
//					return this.indexOf(current);
//				}
//			}
//			return -1;
//		}
//	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E e) {
		if (e==null)
			return false;
		Node<E> newest = new Node<>(e,null);
		if (isEmpty())
			head=newest;
		else
			tail.setNext(newest);
		tail=newest;
		size++;
		return true;
	}

}
