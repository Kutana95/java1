package geekbrains.lesson5;

public class Horse extends Animal {

    protected  float limitRun = 1500f;
    protected  float limitSwim = 3f;
    protected  float limitJump = 100f ;

    public Horse( String color, String name) {
        super( color, name);
    }
    @Override
    public String run(float lenght) {
        if (lenght  > limitRun ) {return "Horse can't run so long distance! ";}
        else if (lenght == 0){return "Horse can't run!";}
        else {return "Horse runs! ";}
    }
    @Override
    public String swim(float lenght) {
        if (lenght  > limitSwim ) {return "Horse can't swim so long distance! ";}
        else if (lenght == 0){return "Horse can't swim!";}
        else {return "Horse swims! ";}
    }
    @Override
    public String jump(float height) {if (height  > limitJump ) {return "Horse can't jump on high height!  ";}
        else if (height == 0){return "Horse can't jump!";}
        else {return "Horse jumps! ";}
    }
}
