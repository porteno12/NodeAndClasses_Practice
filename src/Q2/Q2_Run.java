package Q2;

public class Q2_Run {
    public static void main(String[] args) {
        Node<Integer> lst1 = new Node<>(7,
                new Node<>(6,
                        new Node<>(7,
                                new Node<>(55,
                                        new Node<>(7,
                                                new Node<>(5,
                                                        new Node<>(8,
                                                                new Node<>(5))))))));
        printList(lst1);
        updateListQ2(lst1);
        printList(lst1);
    }

    private static void printList(Node<Integer> lst1) {
        while(lst1!=null){
            System.out.print(lst1.getValue()+"->");
            lst1 = lst1.getNext();
        }
        System.out.println();
    }

    public static void updateListQ2(Node<Integer> list){
        Node<Integer> tmpL = list;
        while(tmpL!=null){
            int timesVal = valueInList(tmpL.getNext(), tmpL.getValue());
            if(timesVal>0){
                Node<Integer> partialList =  deleteALLValue(tmpL.getNext(), tmpL.getValue());
                tmpL.setNext(new Node<>(timesVal+1,partialList));
                tmpL = tmpL.getNext();
            }
            tmpL = tmpL.getNext();
        }
    }

    /**
     * helper method
     * @param lst
     * @param val - to delete all appearance from the list
     * @return - updated list without any occurrence of val
     */
    public static Node<Integer> deleteALLValue(Node<Integer>lst, int val){
        Node<Integer> firstNd = lst;
        if(lst==null)
            return lst;

        while(lst!=null && lst.getValue()==val){
            lst = lst.getNext();
        }

        Node<Integer> currNd = lst;
        while(currNd!=null && currNd.getNext()!=null){
            if(currNd.getNext().getValue()==val){
                currNd.setNext(currNd.getNext().getNext());
            }else{
                currNd = currNd.getNext();
            }
        }
        return firstNd;
    }

    /**
     * helper method
     * @param lst - list of integers
     * @param num - to search
     * @return - times of appearance of num in the list
     */
    public static int valueInList(Node<Integer>lst, int num){
        int times =0;
        Node<Integer> tmpLst = lst;
        while(tmpLst!=null){
            if(tmpLst.getValue()==num) {
                times++;
            }
            tmpLst = tmpLst.getNext();
        }
        return times;
    }
}
