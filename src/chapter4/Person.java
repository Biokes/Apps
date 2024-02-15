package chapter4;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private boolean isSolved;
    private List<Problem> problemList = new ArrayList<>() ;
    public void add(Problem problem){

       problemList.add(problem);
    }
    public String reCountProblems(){
        String output = "";
        for(Problem problem : problemList){
            output+= problem.getName() +" -> "+ problem.getType()+ "\n";
        }
       return output;
    }
    public boolean isSolved(Problem problem){
            for(Problem probs : problemList){
                isSolved = problem.equals(probs);
                if(isSolved) return false;
            }
        return true;
    }
    public void solveProblem(Problem problem){
        if(problemList.contains(problem))problemList.remove(problem);
        else throw new IllegalArgumentException("Problem does not Exist in problem List.");
    }

}
