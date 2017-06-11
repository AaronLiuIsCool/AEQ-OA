package part2;

/**
 * Created by sliu on 2017-06-10.
 */
public class Transformer implements Comparable<Transformer>{
    String name;
    char alignment; // 'A' 'D'
    int overall;
    int strength;
    int intelligence;
    int speed;
    int endurance;
    int firepower;
    int rank;
    int courage;
    int skill;

    public Transformer(String name, char alignment,
                       int strength, int intelligence, int speed, int endurance,
                       int rank, int courage, int firepower, int skill) throws Exception {
        this.name = name;
        this.alignment = alignment;
        this.strength = strength;
        this.intelligence = intelligence;
        this.speed = speed;
        this.endurance = endurance;
        this.rank = rank;
        this.courage = courage;
        this.firepower = firepower;
        this.skill = skill;
        this.overall = strength + intelligence + speed + endurance + firepower;
        validTransformerSetup();
    }

    public int compareTo(Transformer other){
        return this.rank - other.rank;
    }

    private void validTransformerSetup() throws Exception {
        if(strength < 1 || strength > 10) {
            throw new IllegalArgumentException("Transformer build process failed. Strength needs to be between 1 and 10");
        } else if(intelligence < 1 || intelligence > 10) {
            throw new IllegalArgumentException("Transformer build process failed. Intelligence needs to be between 1 and 10");
        } else if(speed < 1 || speed > 10) {
            throw new IllegalArgumentException("Transformer build process failed. Speed needs to be between 1 and 10");
        } else if(endurance < 1 || endurance > 10) {
            throw new IllegalArgumentException("Transformer build process failed. Endurance needs to be between 1 and 10");
        } else if(rank < 1 || rank > 10) {
            throw new IllegalArgumentException("Transformer build process failed. Rank needs to be between 1 and 10");
        } else if(courage < 1 || courage > 10) {
            throw new IllegalArgumentException("Transformer build process failed. Courage needs to be between 1 and 10");
        } else if(firepower < 1 || firepower > 10) {
            throw new IllegalArgumentException("Transformer build process failed. Firepower needs to be between 1 and 10");
        } else if(skill < 1 || skill > 10) {
            throw new IllegalArgumentException("Transformer build process failed. Skill needs to be between 1 and 10");
        }
        //initialized success
    }
}
