package labtuan5;
import java.util.Scanner;

interface Movable{
    void moveUp();
    void moveDown();
    void moveLeft();
    void moveRight();
}

class MovablePoint implements Movable{
    private int x;
    private int y;
    private int xSpeed;
    private int ySpeed;
    
    public MovablePoint(int x, int y, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public int getX(){
        return x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getY(){
        return y;
    }
    
    public void setXSpeed(int xSpeed){
        this.xSpeed = xSpeed;
    }
    
    public int getXSpeed(){
        return xSpeed;
    }
    
    public void setYSpeed(int ySpeed){
        this.ySpeed = ySpeed;
    }
    
    public int getYSpeed(){
        return ySpeed;
    }
    
    public void nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap x: ");
        this.x = scanner.nextInt();
        System.out.print("Nhap y: ");
        this.y = scanner.nextInt();
        System.out.print("Nhap x speed: ");
        this.xSpeed = scanner.nextInt();
        System.out.print("Nhap y speed: ");
        this.ySpeed = scanner.nextInt();
    }
    
    @Override
    public String toString(){
        return "(x,y),speed=(" + xSpeed + "," + ySpeed + ")";
    }
    
    @Override
    public void moveUp(){
        y -= ySpeed;
    }
    
    @Override
    public void moveDown(){
        y += ySpeed;
    }
    
    @Override
    public void moveLeft(){
        x -= xSpeed;
    }
    
    @Override
    public void moveRight(){
        x += xSpeed;
    }
}

class MovableCircle implements Movable{
    private int radius;
    private MovablePoint center;
    
    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }
    
    public int getRadius() {
        return radius;
    }

    
    public void setRadius(int radius) {
        this.radius = radius;
    }

    
    public MovablePoint getCenter() {
        return center;
    }

    
    public void setCenter(MovablePoint center) {
        this.center = center;
    }
    
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        center = new MovablePoint(0, 0, 0, 0);
        System.out.println("Nhap thong tin tam hinh tron:");
        center.nhap();
        System.out.print("Nhap ban kinh: ");
        this.radius = scanner.nextInt();
    }
    
     @Override
    public String toString() {
        return "Hinh tron tai (" + center.getX() + ", " + center.getY() + "), speed=(" +
                center.getXSpeed() + ", " + center.getYSpeed() + "), ban kinh=" + radius;
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }
    
    @Override
    public void moveRight() {
        center.moveRight();
    }
}

public class Bai04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap thong tin hinh tron:");
        MovableCircle circle = new MovableCircle(0, 0, 0, 0, 0);
        circle.nhap(); 

        System.out.println("Vi tri ban dau: " + circle.toString());

        circle.moveUp();
        System.out.println("Sau khi di chuyen len: " + circle.toString());

        circle.moveDown();
        System.out.println("Sau khi di chuyen xuong: " + circle.toString());

        circle.moveLeft();
        System.out.println("Sau khi di chuyen sang trai: " + circle.toString());

        circle.moveRight();
        System.out.println("Sau khi di chuyen sang phai: " + circle.toString());

        scanner.close(); 
    }
}
