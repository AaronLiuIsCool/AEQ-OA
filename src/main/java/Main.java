import part1.CastleBuilder;
import part2.Battle;
import part2.Transformer;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by sliu on 2017-06-10.
 */
public class Main {

    public static void main(String[] args) {
        // running part1 CastleBuilder
        System.out.println("Start running Part1 -- CastleBuilder");
        int[] input = {2,6,6,6,3,3};
        new CastleBuilder(input);
        System.out.println("Finish running Part1");
        System.out.println();
        //running part2
        //Create Transformers
        System.out.println("Start running Part2 -- Transformer Battles");
        try {
            Transformer Bumblebee = new Transformer("Bumblebee", 'A',9,
                    9,9,9,1,9,9, 9);
            Transformer Cliffjumper = new Transformer("Cliffjumper", 'A',6,
                    8,9,9,2,7,9, 4);
            Transformer Jazz = new Transformer("Jazz", 'A',6,
                    8,5,9,3,6,4, 7);
            Transformer SecretWeapon = new Transformer("Optimus Prime", 'A',10,
                    10,10,10,4,10,10, 10);

            Transformer Skywarp = new Transformer("Skywarp", 'D',9,
                    9,9,9,1,6,9, 9);
            Transformer Soundwave = new Transformer("Soundwave", 'D',6,
                    8,9,9,2,4,9, 4);
            Transformer Shockwave = new Transformer("Shockwave", 'D',6,
                    8,5,9,3,8,4, 7);
            Transformer AntiWarlock = new Transformer("Predaking", 'D',10,
                    10,10,10,4,10,10, 10);

            List<Transformer> transformerList = new ArrayList<Transformer>();
            transformerList.add(Bumblebee);
            transformerList.add(Cliffjumper);
            transformerList.add(Jazz);
            transformerList.add(SecretWeapon);

            transformerList.add(Skywarp);
            transformerList.add(Soundwave);
            transformerList.add(Shockwave);
            transformerList.add(AntiWarlock);

            Battle marsBattle = new Battle();

            marsBattle.battle(transformerList);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Finish running Part2.");
    }
}
