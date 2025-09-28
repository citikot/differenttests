package online.agatstudio.onesidelist;

public class OneSideListDemoApp {
    public static void main(String[] args) {

        int[] values = {1, 2, 3, 4};

        Node nodeList = initList(values);
        printList(nodeList);
        System.out.println("=========================");
        var midElement = findMidElement(nodeList);
        System.out.println("midElement: " + midElement.data);
        var reversedList = reverseList(nodeList);
        printList(reversedList);

    }

    private static Node reverseList(Node nodeList) {
        Node next = nodeList.next;
        Node prev = new Node();
        prev.data = nodeList.data;
        prev.next = null;
        while (next != null) {
            Node curr = new Node();
            curr.data = next.data;
            curr.next = prev;
            prev = curr;
            next = next.next;
        }
        return prev;
    }

    private static Node findMidElement(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    private static void printList(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    private static Node initList(int[] values) {

        Node head = new Node();
        Node currentNode = head;
        head.data = values[0];
        head.next = null;

        for (int i = 1; i < values.length; i++) {
            Node newNode = new Node();
            newNode.data = values[i];
            newNode.next = null;
            currentNode.next = newNode;
            currentNode = newNode;
        }

        return head;
    }

    private static class Node {
        int data;
        Node next;
    }
}
