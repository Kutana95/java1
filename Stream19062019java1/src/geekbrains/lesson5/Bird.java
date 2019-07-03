package geekbrains.lesson5;

public class Bird extends Animal {
    protected  float limitRun = 5f;
    protected  float limitSwim = 0.2f;
    protected  float limitJump = 0f ;

    public Bird(String color, String name) {
        super( color, name);
    }
    @Override
    public String run(float lenght) {
        if (lenght  > limitRun ) {return "Bird can't run so long distance! ";}
        else if (lenght == 0){return "Bird can't run!";}
        else {return "Bird runs! ";}
    }
    @Override
    public String swim(float lenght) {
        if (lenght  > limitSwim ) {return "Bird can't swim so long distance! ";}
        else if (lenght == 0){return "Bird can't swim!";}
        else {return "Bird swims! ";}
    }
    @Override
    public String jump(float height) {
        if (height  > limitJump ) {return "Bird can't jump on high height!  ";}
        else if (height == 0){return "Bird can't jump!";}
        else {return "Bird jumps! ";}
    }
}
