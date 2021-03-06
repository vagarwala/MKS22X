import java.util.Scanner;

/* Class TreeNode<T> */
@SuppressWarnings("unchecked")
class TreeNode<T extends Comparable<T>>{    
    TreeNode<T> left, right;
    T data;
    int height;
    /* Constructor */
    public TreeNode(){
        left = null;
        right = null;
        data = null;
        height = 0;
    }
    /* Constructor */
    public TreeNode(T n){
        left = null;
        right = null;
        data = n;
        height = 0;
    }
    public boolean hasLeft(){
        return left!=null;
    }
    public boolean hasRight(){
        return right!=null;
    }
    public boolean hasData(){
        return data!=null;
    }
    public boolean hasChildren(){
        return hasRight() && hasLeft();
    }
    public T getData(){
        return data;
    }
    public void setLeft(TreeNode<T> n){
        left = n;
    }
    public void setRight(TreeNode<T> n ){
        right = n;
    }
    
    public TreeNode<T> toPromote() {
        TreeNode<T> start = left;
        while (start.right != null)
            start = start.right;
        return start;
    }
    
    private void shift(TreeNode<T> n, TreeNode<T> o) {
        n = o;
    }
    
    public T remove(T value) {
        if (value.compareTo(data) == 0) {
            if (left != null && right != null)
                data = remove(toPromote().getData());
            else if (left != null)
                shift(this,this.left);
            else if (right != null)
                shift(this,this.right);
            else
                data = null;
            return value;
        }
        else if (value.compareTo(data) < 0) {
            T dat = left.remove(value);
            if (left.getData() == null)
                left = null;
            return dat;
        }
        else {
            T dat = right.remove(value);
            if (right.getData() == null)
                right = null;
            return dat;
        }
    }
}

/* Class BSTree */
@SuppressWarnings("unchecked")
class BSTree<T extends Comparable<T>>{
    private TreeNode<T> root;    

    /* Constructor */
    public BSTree(){
        root = null;
    }

    /* Function to check if tree is empty */
    public boolean isEmpty(){
        return root == null;
    }

    /* Make the tree logically empty */
    public void clear(){
        root = null;
    }
    /* Function to insert data */
    public void insert(T data){
        root = insert(data, root);
    }
    /* Function to get height of node */
    
    private int height(TreeNode<T> t ){
        return t == null ? -1 : t.height;
    }
    /* Function to max of left/right node */
    
    private int max(int lhs, int rhs){
        return lhs > rhs ? lhs : rhs;
    }
    /* Function to insert data recursively */
    
    private TreeNode<T> insert(T x, TreeNode<T> t){
        if (t == null)
            t = new TreeNode<T>(x);
        else if (x.compareTo(t.data) < 0){
            t.left = insert( x, t.left );
            if (height( t.left ) - height( t.right ) == 2)
                if (x.compareTo(t.left.data) < 0)
                    t = rotateWithLeftChild( t );
                else
                    t = doubleWithLeftChild( t );
        }
        else if (x.compareTo(t.data) > 0){
            t.right = insert( x, t.right );
            if (height( t.right ) - height( t.left ) == 2)
                if (x.compareTo(t.right.data) > 0)
                    t = rotateWithRightChild( t );
                else
                    t = doubleWithRightChild( t );
        }
        t.height = max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }
    
    public T remove(T value) {
    if (root.getData() == null) {
        return null;
    }   
    return root.remove(value);
    }

    /* Rotate binary tree node with left child */
      
    private TreeNode<T> rotateWithLeftChild(TreeNode<T> k2){
        TreeNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = max( height( k1.left ), k2.height ) + 1;
        return k1;
    }

    /* Rotate binary tree node with right child */
    
    private TreeNode<T> rotateWithRightChild(TreeNode<T> k1){
        TreeNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
        k2.height = max( height( k2.right ), k1.height ) + 1;
        return k2;
    }
    /**
    * Double rotate binary tree node: first left child
    * with its right child; then node k3 with new left child */
    
    private TreeNode<T> doubleWithLeftChild(TreeNode<T> k3){
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }
    /**
    * Double rotate binary tree node: first right child
    * with its left child; then node k1 with new right child */
       
    private TreeNode<T> doubleWithRightChild(TreeNode<T> k1){
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }    
    /* Functions to count number of nodes */
    public int countNodes(){
        return countNodes(root);
    }
    private int countNodes(TreeNode<T> r){
        if (r == null)
            return 0;
        else{
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
    /* Functions to search for an element */
    public boolean search(T val){
        return search(root, val);
    }
    
    private boolean search(TreeNode<T> r, T val){
        boolean found = false;
        while ((r != null) && !found){
            T rval = r.data;
            if (val.compareTo(rval) < 0)
                r = r.left;
            else if (val.compareTo(rval) > 0)
                r = r.right;
            else{
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }
    /* Function for inorder traversal */
    public void inorder(){
        inorder(root);
    }
    private void inorder(TreeNode<T> r){
        if (r != null){
            inorder(r.left);
            System.out.print(r.data +" ");
            inorder(r.right);
        }
    }
    /* Function for preorder traversal */
    public void preorder(){
        preorder(root);
    }
    private void preorder(TreeNode<T> r){
        if (r != null){
            System.out.print(r.data +" ");
            preorder(r.left);             
            preorder(r.right);
        }
    }
    /* Function for postorder traversal */
    public void postorder(){
        postorder(root);
    }
    private void postorder(TreeNode<T> r){
        if (r != null){
            postorder(r.left);             
            postorder(r.right);
            System.out.print(r.data +" ");
        }
    }     
}