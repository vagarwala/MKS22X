import java.util.Scanner;
/* Class HeapTest */
public class BinaryHeapTest{
    public static void main(String[] args){            
        Scanner scan = new Scanner(System.in);
        /* Creating object of Heap */
        Integer[] l = {1, 2, 3};
        BinaryHeap<Integer> myHeap = new BinaryHeap<Integer>(l); 
        System.out.println("Heap Test\n");
        System.out.println("Heap:");
        System.out.println(myHeap.toString());
        char ch;
        /*  Perform tree operations  */
        do{
            System.out.println("\nHeap Operations\n");
            System.out.println("1. add ");
            System.out.println("6. remove");

            int choice = scan.nextInt();            
            switch (choice){
            case 1 : 
                System.out.println("Enter integer element to add");
                myHeap.add( scan.nextInt() );                     
                break;
            case 6 :
                System.out.println("will remove max element");
                myHeap.remove();
                break;
            default : 
                System.out.println("Wrong Entry \n "); 
                break;   
            }
            /*  Display tree  */  
            System.out.println("Heap:");
            System.out.println(myHeap.toString());

            System.out.println("\n \n Do you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
}