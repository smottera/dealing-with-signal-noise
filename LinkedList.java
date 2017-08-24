import java.util.Random;
import java.util.Arrays;

public class LinkedList {
    static Node head;
 
    static class Node {
 
        int data;
        Node next;
 
        Node(int d) {
            data = d;
            next = null;
        }
    }
 
    /* Function to reverse the linked list */
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    
    void reverse_recursion(Node node){
    
        if(node.next == null)
        {
                LinkedList.head = node;
                return;
        }
        reverse_recursion(node.next);
        Node temp = node.next;
        temp.next = node;
        node.next = null;
    
    }
    
    void reverse_list_print(Node node1)
    {
        if(node1.next != null)
            reverse_list_print(node1.next);
        System.out.print(" "+node1.data + " ");
        //return;
    }
 
    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
 
    public static void main(String[] args) {
        /*LinkedList list = new LinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);
         
        System.out.println("Given Linked list");
        list.printList(head);
        list.reverse_recursion(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
        System.out.println("\nOkay, now let's use recursive reverse print\n");
        list.reverse_list_print(head);
        System.out.println("\n \n" + 3.5/2); */
        
        sorting_and_searching LOL = new sorting_and_searching();
        int arr[] = LOL.random_array(1000000);
        LOL.print_array(arr);
        Arrays.sort(arr);
        LOL.print_array(arr);
        
        
        
    }
}

class sorting_and_searching
{
    void sorting_and_searching()
    {
            System.out.println("You are now using the sorting and searching Class");
    }

    int bubblesort(int arr[])
    {
        int arr1[] = {1,2,3,4};    
        return arr1[2];
    }
    
    int merge_sort(int arr[])
    {
            return 0;
    }

    int[] random_array(int s){    
        //sorting and searching 
        // randomly generate array
        Random rand = new Random();
        int size = s;
        int shit_array[] = new int[size]; 
        int rand_number = 0;
        
        while(size > 0)
        {
            rand_number = rand.nextInt(size+3) - 47;
            //System.out.print(" . " + rand_number);
            shit_array[size-1] = rand_number;
            --size; 
        }
        return shit_array;
    }
    
    void print_array(int[] arr)
    {
            System.out.print("{ ");
           
            int index = 0;
            while(index < (arr.length -1))
            {
                System.out.print(arr[index] + " ,");
                ++index;
                
            }
            
            System.out.print(arr[arr.length-1] + " }");
            System.out.print("\n");
            
    }
    
    int binary_Search(int arr[], int key)
    {
            return arr[key];
    }
    
    int binary_Search_iterative(int arr[], int key)
    {
            return 0;
    }
}

