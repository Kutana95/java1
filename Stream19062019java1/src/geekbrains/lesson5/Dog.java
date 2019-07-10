package geekbrains.lesson5;

public class Dog extends Animal {

    protected  float limitRun = 500f;
    protected  float limitSwim = 0.5f;
    protected  float limitJump = 10f ;

    public Dog(String color, String name) {
        super( color, name);
    }
    @Override
    public String run(float lenght) {
        if (lenght  > limitRun ) {return "Dog can't run so long distance! ";}
        else if (lenght == 0){return "Dog can't run!";}
        else {return "Dog runs! ";}
    }
    @Override
    public String swim(float lenght) {
        if (lenght  > limitSwim ) {return "Dog can't swim so long distance! ";}
        else if (lenght == 0){return "Dog can't swim!";}
        else {return "Dog swims! ";}
    }
    @Override
    public String jump(float height) {
        if (height  > limitJump ) {return "Dog can't jump on high height!  ";}
        else if (height == 0){return "Dog can't jump!";}
        else {return "Dog jumps! ";}
    }
}
