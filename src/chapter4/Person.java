package chapter4;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private boolean isSolved;
    private List<Problem> problemList = new ArrayList<>() ;
    public void add(Problem problem) {

        this.problemList.add(problem);
    }
    public String reCountProblems(){
        String output = "";
        for(Problem problem : problemList){
            output+= problem.getName() +" -> "+ problem.getType()+ "\n";
        }
       return output;
    }
    public boolean isSolved(Problem problem){
        boolean isSolved = false;
            for(Problem probs : problemList){
                isSolved = problem.equals(probs);
                if(isSolved) return false;
            }
        return true;
    }

}
