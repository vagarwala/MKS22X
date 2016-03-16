public class LinkedList{

  private class LNode{
      LNode next; // can be null
      Object val;

      public LNode(Object _val){
         next = null;
         val = _val;
      }
      
      public LNode(Object _val, LNode _next){
         next = _next;
         val = _val;
      }
      
      public Object getData(){
         return val;
      }
      
      public void setData(Object _val){
         val = _val;
      }
      
      public LNode getNext(){
         return next;
      }
      
      public void setNext(LNode _next){
         next = _next;
      }
   }

   private LNode start;
   private int size; // length

   public LinkedList(){ //empty list
      start = new LNode(null);
      size = 0;
   }

   public LinkedList(Object _val){
      start = new LNode(_val);
      size = 1;
   }
   
   public int size(){
      return size;
   }

   public Object get(int index){
      if(index < 0)
         return null;
      LNode current = start.getNext();
      for(int i = 0; i < index; i++){
         if(current.getNext() == null)
            return null; 
         current = current.getNext();
      }
      return current.getData();
   }

   public void set(Object val, int index){
      LNode current = start.getNext();
      for(int i = 0; i < index; i++){
         if(current.getNext() == null)
            return; 
         current = current.getNext();
      }
      current.setData(val);
   }
   
   public boolean add(Object val){ // adds to the end
      LNode temp = new LNode(val);
      LNode current = start;
      while(current.getNext() != null){
         current = current.getNext();
      }
      current.setNext(temp);
      size++;
      return true;
   }
   
   public boolean add(Object val, int index){ // adds val at index
      if(index < 0 || index > size())
         return false;
      LNode temp = new LNode(val);
      LNode current = start;
      for(int i = 1; i < index && current.getNext() != null; i++){
         current = current.getNext();
      }
      temp.setNext(current.getNext());
      current.setNext(temp);
      size++;
      return true;
   }
   
   public Object remove(int index){
      if(index < 0 || index > size())
         return null;
      LNode current = start;
      for(int i = 0; i < index && current.getNext() != null; i++){
         current = current.getNext();
      }
      Object temp = current.getNext();
      current.setNext(current.getNext().getNext());
      size--;
      return temp;
   }

   public int indexOf(Object value) {
      int index = 0;
      LNode current = start.getNext();
      while (current != null) {
          if (current.getData().equals(value)) {
              return index;
          }
          index++;
          current = current.getNext();
      }
      return -1;
  }

  public boolean contains(Object value) {
      int index = 0;
      LNode current = start.getNext();
      while (current != null) {
          if (current.getData().equals(value)) {
              return true;
          }
          index++;
          current = current.getNext();
      }
      return false;
  }

  public void clear(){
    int index = 0;
    LNode current = start.getNext();
    while (current != null) {
          current.setData(null);
          index++;
          current = current.getNext();
      }
    size = 0;
  }
  public boolean isEmpty(){
    return start.getNext() == null || size == 0;
  }
   
   public String toString(){
      if (isEmpty()){
        return "[ ]";
      }
      LNode current = start.getNext();
      String output = "[ ";
      while(current != null){
         output += current.getData().toString() + " ";
         current = current.getNext();
      }
      return output + "]";
   }
   
   /*
   public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        myList.add(7);
        myList.add(16);
        myList.add(9, 1);
        myList.add(4, 9);
        myList.add(6, 2);
        System.out.println(myList.toString() + myList.size());
        System.out.println(myList.get(2));
        myList.set(17, 3);
        System.out.println(myList.toString() + myList.size());
        
        myList.remove(2);
        System.out.println(myList.toString() + myList.size());
        System.out.println(myList.indexOf(17));
        myList.clear();
        System.out.println(myList.toString() + myList.size());
        
    }
    */
    
}