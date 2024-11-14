package lists;

public class SortedLinkedListFromBase<T extends Comparable<? super T>> 
    extends BaseLinkedList<T> 
    implements SortedListInterface<T> {

        public SortedLinkedListFromBase() {
            super();
        }

        @Override
        public void add(T newEntry) {
            Node newNode = new Node(newEntry, null);
            Node nodeBefore = getNodeAndIndexBefore(newEntry).node;
            if(isEmpty() || nodeBefore == null) {
                newNode.next = firstNode;
                firstNode = newNode;
            } else {
                Node nodeAfter = nodeBefore.next;
                newNode.next = nodeAfter;
                nodeBefore.next = newNode;
            }
            numberOfElements++;
        }
    
        private class NodeIndexPair {
            int index;
            Node node;
            private NodeIndexPair(Node node, int index) {
                this.node = node;
                this.index = index;
            }
        }
    
        private NodeIndexPair getNodeAndIndexBefore(T anEntry) {
            Node nodeBefore = null;
            int indexOfNodeBefore = -1;
            Node current = firstNode;
            while(current != null && anEntry.compareTo(current.data) > 0) {
                nodeBefore = current;
                current = current.next;
                indexOfNodeBefore++;
            }
            return new NodeIndexPair(nodeBefore,indexOfNodeBefore);
        }
    
        @Override
        public boolean remove(T anEntry) {
            boolean result = false;
            int position = getPosition(anEntry);
            if (position != -1) {
                remove(position);
                result = true;
            }
            return result;
        }
    
        @Override
        public int getPosition(T anEntry) {
            NodeIndexPair nodeAndIndexBefore = getNodeAndIndexBefore(anEntry);
            Node possibleNode = null;
            if(nodeAndIndexBefore.index == -1) {
                possibleNode = firstNode;
            } else {
                possibleNode = nodeAndIndexBefore.node.next;
            }
    
            if(possibleNode != null && possibleNode.data.compareTo(anEntry) == 0) {
                return nodeAndIndexBefore.index + 1;
            } else {
                return -1;
            }
        }
}