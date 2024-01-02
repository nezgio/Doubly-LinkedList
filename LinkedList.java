public class LinkedList implements HW2Interface {

    private DLNode head;
    private DLNode tail;

    @Override
    public void Insert(int newElement, int pos) throws Exception {
        if(pos < 0 || pos > getSize()) {
            throw LinkedListException();
        }

        DLNode newDlNode = new DLNode(newElement);

        if (head == null && tail == null) {
            head = newDlNode;
            tail = newDlNode;
        }

        else if (pos == 0) {
            newDlNode.right = head;
            head.left = newDlNode;
            head = newDlNode;
        }
        else if (pos == getSize()){
            newDlNode.left = tail;
            tail.right = newDlNode;
            tail = newDlNode;
        }
        else {
            DLNode temp = head;
            for (int i = 0; i < pos -1 ; i++) {
                temp = temp.right;
            }
            newDlNode.right = temp.right;
            newDlNode.left = temp;
            temp.right.left = newDlNode;
            temp.right = newDlNode;
        }
    }

    @Override
    public int Delete(int pos) throws Exception {
        if(pos<0 || pos > getSize() ){
            throw LinkedListException();
        }
        DLNode newDLNode = head;

        if (head == tail){
            head = tail = null;
        }
        else if(pos == 0){
            head.right.left = null;
            head = head.right;
        }
        else if(pos == getSize()-1){
            tail.left.right = null;
            tail = tail.left;
        }
        else {
            DLNode temp = head;
            for (int i = 0; i < pos -1 ; i++) {
                temp = temp.right;
            }
            newDLNode = temp.right;
            temp.right = newDLNode.right;
            temp.right.left = temp;
        }
        return newDLNode.Element;
    }

    @Override
    public void ReverseLink() {
        DLNode temp = null;
        DLNode curr = head;

        while (curr != null) {
            temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            curr = curr.left;
        }

        tail = head;
        tail.right = null;
        head = temp;

        if (temp != null) {
            head = temp.left;
        }
    }

    @Override
    public void SquashL() {
        DLNode curr = head;

        while (curr != null) {
            int elementsCounter = 1;
            DLNode temp = curr.right;
            while(temp != null && temp.Element == curr.Element) {
                elementsCounter++;
                temp = temp.right;
            }
            DLNode newNode = new DLNode(elementsCounter);
            curr.right = newNode;
            if (temp != null) {
                temp.left = curr.right;
            }
            newNode.right = temp;
            newNode.left = curr;
            curr = temp;

        }

    }

    @Override
    public void OplashL() {
        DLNode curr = head;

        while (curr != null) {
            int elementsCount = curr.right.Element;
            DLNode temp = curr.right.right;

            if (elementsCount == 1) {
                curr.right = temp;
                if (temp != null) {
                    temp.left = curr;
                }
            } else {
                DLNode previousReference = null;
                for (int i = 0; i < elementsCount - 1; i++) {
                    DLNode newNode = new DLNode(curr.Element);
                    if (temp != null) {
                        temp.left = newNode;
                    }
                    newNode.right = temp;

                    if (i == 0) {
                        curr.right = newNode;
                        newNode.left = curr;
                    } else {
                        newNode.left = previousReference;
                        previousReference.right = newNode;
                    }
                    previousReference = newNode;
                }
            }
            curr = temp;
        }

    }

    @Override
    public void Output() {
        DLNode curr = head;
        System.out.print("The Elements in the list are : ");
        while (curr != null) {
            System.out.print(curr.Element + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    @Override
    public void ROutput() {
        DLNode curr = tail;
        System.out.print("The Reverse Elements in the list are : ");
        while (curr != null) {
            System.out.print(curr.Element + " ");
            curr = curr.left;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        String strDLL = "";
        DLNode curr = head;

        while (curr != null) {
            strDLL += curr.Element + " ";
            curr = curr.right;
        }
        return strDLL;
    }

    @Override
    public Exception LinkedListException() throws HW2Exception {
        throw new HW2Exception();
    }

    public int getSize() {
        int size = 0;
        DLNode curr = head;

        while (curr != null) {
            size++;
            curr = curr.right;
        }

        return size;
    }
}

