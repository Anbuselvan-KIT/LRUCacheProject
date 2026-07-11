import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Cache Capacity: ");
        int capacity=sc.nextInt();
        LRUCache Cache=new LRUCache(capacity);
        while(true){
            System.out.println("\n =========LRU Cache Menu=========");
            System.out.println("1.Put");
            System.out.println("2.Get");
            System.out.println("3.Display");
            System.out.println("4.Exit");
            System.out.println("Enter Your Choice");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter the Key: ");
                    int key=sc.nextInt();
                    System.out.print("Enter Value: ");
                    int value=sc.nextInt();
                    Cache.put(key,value);
                    System.out.print("Data inserted successfully");
                    break;
                case 2:
                    System.out.print("Enter Key:");
                    key=sc.nextInt();
                    int result=Cache.get(key);
                    if(result==-1){
                        System.out.println("Key not Found ");
                    }
                    else{
                        System.out.println("Value = " +result);
                    }
                    break;
                case 3:
                    Cache.Display();
                    break;
                case 4:
                    System.out.println("Exiting.........");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}