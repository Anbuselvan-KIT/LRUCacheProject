import java.util.*;
public class LRUCache{
    private int capacity;
    private HashMap<Integer,Node>map;
    private Node head;
    private Node tail;
    public LRUCache(int capacity){
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head=null;
        this.tail=null;
    }
    private void addtofront(Node node){
        node.prev=null;
        node.next=head;
        if(head!=null){
            head.prev=node;
        }
        head=node;
        if(tail==null){
            tail=node;
        }
    }
    private void removeNode(Node node){
        if(node.prev!=null){
            node.prev.next=node.next;
        }
        else{
            tail=node.next;
        }
        node.prev=null;
        node.next=null;
    }
    private void movetofront(Node node){
        removeNode(node);
        addtofront(node);
    }
    private Node removeTail(){
        Node removed=tail;
        if(removed!=null){
            removeNode(removed);
        }
        return removed;
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        movetofront(node);
        return node.value;
    }
    public void put(int key,int value){
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            movetofront(node);
        }
        else{
            Node newNode=new Node(key,value);
            if(map.size()==capacity){
                Node removed=removeTail();
                if(removed!=null){
                    map.remove(removed.key);
                }
            }
            addtofront(newNode);
            map.put(key,newNode);
        }
       
    }
    public void Display(){
        if(head==null){
            System.out.println("Cache is Empty......");
            return;
        }
        Node current=head;
        System.out.println("Cache(Most Recent --> Least Recent)");
        while(current!=null){
            System.out.print("["+current.key+":"+current.value +"]");
            if(current.next!=null){
                System.out.print("-->");
            }
            current=current.next;
        }
        System.out.println();
    }
}