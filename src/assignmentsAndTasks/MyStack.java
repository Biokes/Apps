package assignmentsAndTasks;

public class MyStack {
    private final String [] stack ;
    private int nextVacant =0;
    public MyStack(int number) {
        if(number < 1)
            throw new IllegalArgumentException(String.format("%s length is not valid for creating a stack.",number));
        stack = new String[number];
    }

    public boolean isEmpty() {
        if(nextVacant == 0)
            return true;
        return false;
    }

    public void push(String name) {
        if(nextVacant+1 >stack.length )
            throw new StackOverflowError("Elements cannot be pushed beyond Stack size");
        stack[nextVacant++] = name;
    }

    public String peek() {
        String output;
        for(int counter = stack.length-1; counter >= 0; counter-- ){
            if(stack[counter] == null)
                continue;
            output = stack[counter];
            return output;
        }
        return "Stack is empty";
    }

    public void pop(String name) {
        if(nextVacant ==0 )
            throw new RuntimeException("Stack UnderFlow.");
    }
}
