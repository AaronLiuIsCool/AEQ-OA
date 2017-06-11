package part1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sliu on 2017-06-10.
 */
public class CastleBuilder {

    CastleBuilder() {} //for unit testing only;

    public CastleBuilder(int[] input) {
        System.out.println("Total Peak and Valley size is " +
                this.buildCastle(removeContinuesDuplicateNumber(input)));
    }

    List<Integer> removeContinuesDuplicateNumber(int[] input) {
        if(input == null || input.length == 0) {
            return null;
        }

        List<Integer> resultList = new ArrayList<Integer>();
        resultList.add(input[0]);
        for(int i = 1; i<input.length; i++) {
            if(input[i] != input[i-1]) {
                resultList.add(input[i]);
            }
        }

        return resultList;
    }

    public int buildCastle(List<Integer> input) {
        int result = 0;
        if (input == null || input.size() == 0) {
            return result;
        }

        result++; //for the start index Castle
        for(int i=1; i<input.size()-1; i++) {
            if(input.get(i) > input.get(i-1) && input.get(i) > input.get(i+1) //it's a peak
                    || (input.get(i) < input.get(i-1)) && input.get(i) < input.get(i+1)) { //it's a valley
                result++;
            }
        }

        return result;
    }
}

