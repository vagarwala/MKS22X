import java.util.Scanner;
/* Class BSTreeTest */
public class BSTreeTest{
    public static void main(String[] args){            
        Scanner scan = new Scanner(System.in);
        /* Creating object of BSTree */
        BSTree sbbst = new BSTree(); 
        System.out.println("BSTree Test\n");          
        char ch;
        /*  Perform tree operations  */
        do{
            System.out.println("\nBSTree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            System.out.println("4. check empty");
            System.out.println("5. clear tree");

            int choice = scan.nextInt();            
            switch (choice){
            case 1 : 
                System.out.println("Enter integer element to insert");
                sbbst.insert( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to search");
                System.out.println("Search result : "+ sbbst.search( scan.nextInt() ));
                break;                                          
            case 3 : 
                System.out.println("Nodes = "+ sbbst.countNodes());
                break;     
            case 4 : 
                System.out.println("Empty status = "+ sbbst.isEmpty());
                break;     
            case 5 : 
                System.out.println("\nTree Cleared");
                sbbst.clear();
                break;         
            default : 
                System.out.println("Wrong Entry \n "); 
                break;   
            }
            /*  Display tree  */  
            System.out.print("\nPost order : ");
            sbbst.postorder();
            System.out.print("\nPre order : ");
            sbbst.preorder();
            System.out.print("\nIn order : ");
            sbbst.inorder();

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
}