package geekbrains.lesson5;

public class Cat extends Animal {

    private  float limitRun = 200f;
    private  float limitSwim = 0f;
    private  float limitJump = 2f ;
    public Cat(String color, String name) {
        super( color, name);
    }

    @Override
    public String run(float lenght) {
        if (lenght  > limitRun ) {return "Cat can't run so long distance! ";}
        else if (lenght == 0){return "Cat can't run!";}
        else {return "Cat runs! ";}
    }
    @Override
    public String swim(float lenght) {
        if (lenght  > limitSwim ) {return "Cat can't swim so long distance! ";}
        else if (lenght == 0){return "Cat can't swim!";}
        else {return "Cat swims! ";}

    }
    @Override
    public String jump(float height) {
        if (height  > limitJump ) {return "Cat can't jump on high height!  ";}
        else if (height == 0){return "Cat can't jump!";}
        else {return "Cat jumps! ";}

    }

  

}
