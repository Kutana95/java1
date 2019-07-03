package geekbrains.lesson5;

public abstract class Animal {
    protected String name;
    protected String color;
    protected  float limitRun ;
    protected  float limitSwim ;
    protected  float limitJump ;

    public Animal(String color, String name) {
        this.name = name;
        this.color = color;

    }

    public float getLimitRun(){return this.limitRun;}
    public float getLimitSwim(){return this.limitSwim;}
    public float getLimitJump(){return this.limitJump;}

    public void setLimitRun(float limitRun){ this.limitRun = limitRun;}
    public void setLimitSwim(float limitSwim){this.limitSwim = limitSwim;}
    public void setLimitJump(float limitJump){this.limitJump = limitJump;}


    public abstract String run(float lenght);
    public abstract String swim(float lenght);
    public abstract String jump(float height);



}
