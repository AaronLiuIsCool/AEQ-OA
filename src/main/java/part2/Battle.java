package part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sliu on 2017-06-10.
 */
public class Battle {
    static final char AUTOBOT = 'A';
    static final char DECEPTION = 'D';

    static final String OPTIMUS_PRIME = "Optimus Prime";
    static final String PREDAKING = "Predaking";

    public static void battle(List<Transformer> transformers) throws Exception {
        if (transformers == null || transformers.size() == 0) {
            return;
        }

        Collections.sort(transformers);
        List<Transformer> autobots = new ArrayList<Transformer>();
        List<Transformer> deceptions = new ArrayList<Transformer>();
        for (Transformer transformer : transformers) {
            if (transformer.alignment == AUTOBOT) {
                autobots.add(transformer);
            } else if (transformer.alignment == DECEPTION) {
                deceptions.add(transformer);
            } else {
                throw new Exception("Third alignment showed up, battle ended");
            }
        }

        startBattle(autobots, deceptions);
    }

    private static void startBattle(List<Transformer> autobots, List<Transformer> deceptions) {
        if (autobots.size() == 0) {
            System.out.println("Winner team (Deceptions): No one got destroied");
            System.out.println("No Autobots in this battle");
            return;
        }

        if (deceptions.size() == 0) {
            System.out.println("Winner team (Autobots): No one got destroied");
            System.out.println("No Deceptions in this battle");
            return;
        }

        int size = autobots.size() > deceptions.size() ? deceptions.size() : autobots.size();
        List<Transformer> autobotSurviors = new ArrayList<Transformer>();
        List<Transformer> deceptionsSurviors = new ArrayList<Transformer>();
        Transformer autobot, deception;
        int autobotWin = 0, deceptionsWin = 0, numOfBattles = 0;
        int courageDiff, strengthDiff, skillDiff;

        for (int i = 0; i < size; i++) {
            autobot = autobots.get(i);
            deception = deceptions.get(i);

            if (OPTIMUS_PRIME.equals(autobot.name) && PREDAKING.equals(deception.name) ||
                    OPTIMUS_PRIME.equals(autobot.name) && OPTIMUS_PRIME.equals(deception.name) ||
                    PREDAKING.equals(autobot.name) && PREDAKING.equals(deception.name) ||
                    PREDAKING.equals(autobot.name) && OPTIMUS_PRIME.equals(deception.name)) {
                numOfBattles++;
                break; //This is a speical case /*
                //In the event either of the above face each other (or a duplicate of each other), the game immediately
                // ends with all competitors destroyed
                // */
            } else if (OPTIMUS_PRIME.equals(autobot.name)) {
                autobotSurviors.add(autobot);
                autobotWin++;
                numOfBattles++;
                continue;
            } else if (PREDAKING.equals(deception.name)) {
                deceptionsSurviors.add(deception);
                deceptionsWin++;
                numOfBattles++;
                continue;
            }

            courageDiff = autobot.courage - deception.courage;
            strengthDiff = autobot.strength - deception.courage;
            if (courageDiff >= 4 && strengthDiff >= 3) {
                autobotSurviors.add(autobot);
                deceptionsSurviors.add(deception);
                autobotWin++;
                numOfBattles++;
                continue;
            } else if (courageDiff <= -4 && strengthDiff <= -3) {
                autobotSurviors.add(autobot);
                deceptionsSurviors.add(deception);
                deceptionsWin++;
                continue;
            }

            skillDiff = autobot.skill - deception.skill;
            if (skillDiff >= 3) {
                autobotSurviors.add(autobot);
                autobotWin++;
                numOfBattles++;
                continue;
            } else if (skillDiff <= -3) {
                deceptionsSurviors.add(deception);
                deceptionsWin++;
                numOfBattles++;
                continue;
            }

            if (autobot.overall > deception.overall) {
                autobotSurviors.add(autobot);
                autobotWin++;
                numOfBattles++;
                continue;
            } else if (autobot.overall < deception.overall) {
                deceptionsSurviors.add(deception);
                deceptionsWin++;
                numOfBattles++;
                continue;
            } else {
                numOfBattles++;
            }
        }

        System.out.println(numOfBattles + " battle(s)");
        if (autobotWin > deceptionsWin) {
            System.out.println("Winning team(Autobots):");
            for (Transformer transfomer : autobotSurviors) {
                System.out.print(transfomer.name + " ");
            }
            System.out.println("Survivors from losing team(Deceptions):");
            for (Transformer transfomer : deceptionsSurviors) {
                System.out.print(transfomer.name + " ");
            }
        } else if (autobotWin < deceptionsWin){
            System.out.println("Winning team(Deceptions):");
            for (Transformer transfomer : deceptionsSurviors) {
                System.out.print(transfomer.name + " ");
            }
            System.out.println("Survivors from losing team(Autobots):");
            for (Transformer transfomer : autobotSurviors) {
                System.out.print(transfomer.name + " ");
            }
        } else {
            System.out.println("It's a tie, no survivors. The world is peace again! ");
        }
    }
}
