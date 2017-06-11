package part1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sliu on 2017-06-10.
 */
public class CastleBuilderUnitTest {

    @Test
    public void testRemoveContinuesDuplicateNumber() {
        CastleBuilder cb = new CastleBuilder();

        int[] expectResult3 = {1};
        int[] expectResult4 = {1,2,1};
        int[] expectResult5 = {6,1,4,2,3};
        int[] expectResult6 = {2,6,3};

        List<Integer> actualResult1 = cb.removeContinuesDuplicateNumber(null);
        List<Integer> actualResult2 = cb.removeContinuesDuplicateNumber(new int[]{});
        List<Integer> actualResult3 = cb.removeContinuesDuplicateNumber(new int[]{1,1,1,1});
        List<Integer> actualResult4 = cb.removeContinuesDuplicateNumber(new int[]{1,1,2,2,1,1});
        List<Integer> actualResult5 = cb.removeContinuesDuplicateNumber(new int[]{6,1,4,2,3});
        List<Integer> actualResult6 = cb.removeContinuesDuplicateNumber(new int[]{2,2,6,3,3});

        assertEquals(null, actualResult1);
        assertEquals(null, actualResult2);
        assertEquals(Arrays.asList(expectResult3), actualResult3);
        assertEquals(Arrays.asList(expectResult4), actualResult4);
        assertEquals(Arrays.asList(expectResult5), actualResult5);
        assertEquals(Arrays.asList(expectResult6), actualResult6);
    }

    @Test
    public void testBuildCastle() {
        CastleBuilder cb = new CastleBuilder();

        ArrayList<Integer> input3 = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,2,1,1,1,2}));
        ArrayList<Integer> input4 = new ArrayList<Integer>(Arrays.asList(new Integer[]{0}));
        ArrayList<Integer> input5 = new ArrayList<Integer>(Arrays.asList(new Integer[]{2,6,6,6,3,3}));
        ArrayList<Integer> input6 = new ArrayList<Integer>(Arrays.asList(new Integer[]{6,1,4,2,3}));

        int actualResult1 = cb.buildCastle(null);
        int actualResult2 = cb.buildCastle(new ArrayList<Integer>());
        int actualResult3 = cb.buildCastle(input3);
        int actualResult4 = cb.buildCastle(input4);
        int actualResult5 = cb.buildCastle(input5);
        int actualResult6 = cb.buildCastle(input6);

        assertEquals(0, actualResult1);
        assertEquals(0, actualResult2);
        assertEquals(3, actualResult3);
        assertEquals(1, actualResult4);
        assertEquals(2, actualResult5);
        assertEquals(4, actualResult6);
    }
}
