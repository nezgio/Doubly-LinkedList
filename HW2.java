public class HW2 {

    public static void main(String[] args) throws Exception {
    LinkedList myList = new LinkedList();
    try {
        myList.Insert(1, 0);
        myList.Delete(0);
        myList.Insert(1, 0);
        myList.Insert(2, 0);
        myList.Insert(3, 0);
        myList.Insert(3, 0);
        myList.Insert(3, 0);
        myList.Insert(3, 0);
        myList.Insert(2, 0);
        myList.Insert(2, 0);
        myList.Delete(7);
        myList.Insert(5, 7);
        myList.Delete(5);
        myList.Insert(8, 5);
        myList.Insert(2, 0);
        myList.Insert(2, 0);
        myList.Insert(9, 5);
        myList.Insert(9, 6);
        myList.Insert(1, 0);
        myList.Insert(2, 0);
        myList.Insert(2, 0);
        myList.Insert(3, 0);
        myList.Insert(2, 0);
        myList.Insert(5, 54);
    } catch (Exception ex) {
         System.out.println(ex.toString());
    }
    myList.Output();
    myList.ReverseLink();
    myList.Output();
    myList.SquashL();
    myList.Output();
    myList.OplashL();
    myList.Output();
    myList.ROutput();
    System.out.println(myList);

}

}
