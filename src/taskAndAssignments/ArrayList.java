package taskAndAssignments;


public class ArrayList {
    private boolean isEmpty = true;
    private int size = 0;
    private String[] element = new String [0];
    public boolean isEmpty() {

        return size == 0;
    }

    public void add(String name) {
        String[] elements = createNewArray();
        for(int counter = 0; counter < element.length; counter++){
                elements [counter]= element[counter];
        }
        elements[size-1] = name;
        this.element = elements;
    }

    public String getElement(int index) {
        if (index < 0 || index > element.length -1){
            throw new IllegalArgumentException("ArrayList index of bound.");
            }
        return element[index];
    }
    private String[] reduceArray(){

        return new String[size-1];
    }

    private String[] createNewArray(){

        return new String [++size];
    }

    public int getIndex(String name) {
        for(int count = 0; count < element.length; count++){
            if(name.equals(element[count]))
                return count;
        }
        throw new IllegalArgumentException("Illegal Argument Exception");
    }

    public void insert(int index, String name1) {
        boolean condition = index < 0 || index > size ;
        if(condition)
            throw new ArrayIndexOutOfBoundsException("Index Out Of Bound.");
        String [] elements = createNewArray();
        int count =0;
        for(int counter = 0;counter < elements.length; counter++){
            if(counter== index){
                elements[counter++] = name1;
                continue;
            }
            elements[counter] = elements[count++];
        }
        this.element = elements;
    }

    public void removeElement(String name) {
        String [] temp = reduceArray();
        for(int counter = 0, count = 0; counter < size; counter++){
              if(element[counter] != "name")
                  temp[count++] = element[counter] ;
        }
        element = temp;
        size--;
    }

    public void clear() {
        String [] element = new String [0];
        this.element = element;
        size = element.length;
    }

    public int size() {
        return size;
    }
}
