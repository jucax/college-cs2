package lists;

public class LinkedListFromBase<T> 
    extends BaseLinkedList<T> 
    implements ListInterface<T> {

        public LinkedListFromBase() {
            super();
        }

        @Override
        public void add(T newEntry) { // Adding at the end
            add(getLength(), newEntry);
        }
    
        @Override
        public void add(int newPosition, T newEntry) {
            if(0 > newPosition || newPosition > numberOfElements)
                throw new IndexOutOfBoundsException(newPosition + " out of bounds");
            Node newNode = new Node(newEntry, null);
            // Case: add at beginning
            if(newPosition == 0) {
                newNode.next = firstNode;
                firstNode = newNode;
            } else {
                Node nodeBefore = getNodeAt(newPosition-1);
                Node nodeAfter = nodeBefore.next;
                newNode.next = nodeAfter;
                nodeBefore.next = newNode;
            }
            numberOfElements++;
        }

        @Override
        public T replace(int givenPosition, T newEntry) {
            if(0 > givenPosition || givenPosition >= numberOfElements)
			throw new IndexOutOfBoundsException(givenPosition + " out of bounds");
            Node desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.data;
            desiredNode.data = newEntry;
            return originalEntry;
        }

        @Override
        public T[] toArray() {
            @SuppressWarnings("unchecked")
            T[] result = (T[]) new Object[numberOfElements];
            Node current = firstNode;
            for(int i = 0; i < numberOfElements; i++) {
                result[i] = current.data;
                current = current.next;
            }
            return result;
        }
}