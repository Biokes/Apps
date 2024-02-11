package assignmentsAndTasks;

public class MyStack {
    private String [] stack = new String [0];
    private  int size=0;
    public void createStack(int number) {
        if(number < 1)
            throw new IllegalArgumentException("Stack of a negative length is not valid");
        stack = new String[number];
    }

    public boolean isEmpty() {
        return true;
    }

    public void push(String name) {

    }

    public String peek() {
        String output = "";
        for(int counter = stack.length-1; counter >= 0; counter-- ){
            if(stack[counter] == null)
                continue;
                output = stack[counter];
                return output;
        }        return "Stack is empty";
    }
}
