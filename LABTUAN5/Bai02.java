package labtuan5;
import java.util.Scanner;

interface Hinh{
    float pi = 3.14f;
    void nhap();
    void xuat();
    float dienTich();
}

class HinhVuong implements Hinh{
    private float canh;
    
    public HinhVuong(){
        this.canh = 0;
    }
    
    public HinhVuong(float canh){
        this.canh = canh;
    }
    
    public void setCanh(float canh1){
        this.canh = canh1;
    }
    
    public float getCanh(){
        return canh;
    }
    
    @Override
    public void nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap canh hinh vuong: ");
        this.canh = scanner.nextFloat();
    }
    
    @Override
    public void xuat(){
        System.out.println("Canh hinh vuong: " + this.canh);
        System.out.println("Dien tich hinh vuong: " + dienTich());
    }
    
    @Override
    public float dienTich(){
        return canh * canh;
    }
}

class HinhChuNhat implements Hinh{
    private float dai;
    private float rong;
    
    public HinhChuNhat(){
        this.dai = 0;
        this.rong = 0;
    }
    
    public HinhChuNhat(float dai, float rong){
        this.dai = dai;
        this.rong = rong;
    }
    
    public void setDai(float dai1){
        this.dai = dai1;
    }
    
    public float getDai(){
        return dai;
    }
    
    public void setRong(float rong1){
        this.rong = rong1;
    }
    
    public float getRong(){
        return rong;
    }
    
    @Override
    public void nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chieu dai: ");
        this.dai = scanner.nextFloat();
        System.out.print("Nhap chieu rong: ");
        this.rong = scanner.nextFloat();
    }
    
    @Override
    public void xuat(){
        System.out.println("Chieu dai hinh chu nhat: " + this.dai);
        System.out.println("Chieu rong hinh chu nhat: " + this.rong);
        System.out.println("Dien tich hinh chu nhat: " + dienTich());
    }
    
    @Override
    public float dienTich(){
        return dai * rong;
    }
}

class HinhTron implements Hinh{
    private float banKinh;
    
    public HinhTron(){
        this.banKinh = 0;
    }
    
    public HinhTron(float banKinh){
        this.banKinh = banKinh;
    }
    
    public void setBanKinh(float banKinh1){
        this.banKinh = banKinh1;
    }
    
    public float getBanKinh(){
        return banKinh;
    }
    
    @Override
    public void nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ban kinh: ");
        this.banKinh = scanner.nextFloat();
    }
    
    @Override
    public void xuat(){
        System.out.println("Ban kinh hinh tron: " + this.banKinh);
        System.out.println("Dien tich hinh tron: " + dienTich());
    }
    
    @Override
    public float dienTich(){
        return pi * banKinh * banKinh;
    }
}

public class Bai02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap so luong hinh: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        
        Hinh ds[] = new Hinh[n];
        
        for(int i = 0; i < n; i++){
            System.out.println("Chon loai hinh se nhap: ");
            System.out.println("1: hinh vuong");
            System.out.println("2: hinh chu nhat");
            System.out.println("3: hinh tron");
            int chon = 0;
            boolean hople = false;
            while(!hople){
                System.out.print("Nhap lua chon: ");
                chon = scanner.nextInt();
                scanner.nextLine();
                if(chon >= 1 && chon <= 3){
                    hople = true;
                }else{
                    System.out.println("Lua chon khong hop le!!!");
                }
            }
            
            switch(chon){
                case 1:
                    ds[i] = new HinhVuong();
                    break;
                case 2:
                    ds[i] = new HinhChuNhat();
                    break;
                case 3:
                    ds[i] = new HinhTron();
                    break;
                default:
                    System.out.println("Ban phai chon 1 trong 3 loai tren");
            }
            
            ds[i].nhap();
        }
        
        System.out.println("\nDanh sach cac hinh:");
        for (Hinh hinh : ds) {
            hinh.xuat();
            System.out.println("---------------");
        }

        Hinh hinhDienTichLonNhat = ds[0];
        for (Hinh hinh : ds) {
            if (hinh.dienTich() > hinhDienTichLonNhat.dienTich()) {
                hinhDienTichLonNhat = hinh;
            }
        }

        System.out.println("Hinh co dien tich lon nhat:");
        hinhDienTichLonNhat.xuat();
    }
}
