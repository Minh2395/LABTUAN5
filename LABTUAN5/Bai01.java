package labtuan5;
import java.util.Scanner;
import java.util.ArrayList;

abstract class NhanVien{
    protected String maNhanVien;
    protected String tenNhanVien;
    protected String trinhDo;
    protected double luongCoBan;
    
    public NhanVien(){
        this.maNhanVien = "";
        this.tenNhanVien = "";
        this.trinhDo = "";
        this.luongCoBan = 0.0;
    }
    
    public NhanVien(String maNhanVien, String tenNhanVien, String trinhDo){
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.trinhDo = trinhDo;
        this.luongCoBan = 0.0;
    }
    
    public void setMaNhanVien(String maNhanVien1){
        this.maNhanVien = maNhanVien1;
    }
    
    public String getMaNhanVien(){
        return maNhanVien;
    }
    
    public void setTenNhanVien(String tenNhanVien1){
        this.tenNhanVien = tenNhanVien1;
    }
    
    public String getTenNhanVien(){
        return tenNhanVien;
    }
    
    public void setTrinhDo(String trinhDo1){
        this.trinhDo = trinhDo1;
    }
    
    public String getTrinhDo(){
        return trinhDo;
    }
    
    public void setLuongCoBan(double luongCoBan1){
        this.luongCoBan = luongCoBan1;
    }
    
    public double getLuongCoBan(){
        return luongCoBan;
    }
    
    public void nhap(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        this.maNhanVien = scanner.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        this.tenNhanVien = scanner.nextLine();
        System.out.print("Nhap trinh do: ");
        this.trinhDo = scanner.nextLine();
        System.out.print("Nhap luong co ban: ");
        this.luongCoBan = scanner.nextDouble();
        scanner.nextLine();
    }
    
    public void xuat(){
        System.out.print("Ma nhan vien: " + maNhanVien + ", Ten nhan vien: " + tenNhanVien + ", Trinh do: " + trinhDo + ", Luong co ban: " + luongCoBan);
    }
    
    public abstract double tinhLuong();
}

class QuanLy extends NhanVien{
    private String chuyenMon;
    private double phuCapChucVu;
    
    public QuanLy(){
        super();
        this.chuyenMon = "";
        this.phuCapChucVu = 0.0;
    }
    
    public QuanLy(String maNhanVien,String tenNhanVien, String trinhDo, String chuyenMon, double phuCapChucVu){
        super(maNhanVien, tenNhanVien, trinhDo);
        this.chuyenMon = chuyenMon;
        this.phuCapChucVu = phuCapChucVu;
    }
    
    public void setChuyenMon(String chuyenMon1){
        this.chuyenMon = chuyenMon1;
    }
    
    public String getChuyenMon(){
        return chuyenMon;
    }
    
    public void setPhuCapChucVu(double phuCapChucVu1){
        this.phuCapChucVu = phuCapChucVu1;
    }
    
    public double getPhuCapChucVu(){
        return phuCapChucVu;
    }
    
    @Override
    public void nhap(){
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuyen mon: ");
        this.chuyenMon = scanner.nextLine();
        System.out.print("Nhap phu cap chuc vu: ");
        this.phuCapChucVu = scanner.nextDouble();
    }
    
    @Override
    public void xuat(){
        super.xuat();
        System.out.println(", Chuyen mon: " + chuyenMon + ", Phu cap chuc vu: " + phuCapChucVu + ", Tong luong: " + tinhLuong());
    }
    
    @Override
    public double tinhLuong(){
        return luongCoBan + phuCapChucVu;
    }
}

class NghienCuu extends NhanVien{
    private String chuyenMon;
    private double phuCapDocHai;
    
    public NghienCuu(){
        super();
        this.chuyenMon = "";
        this.phuCapDocHai = 0.0;
    }
    
    public NghienCuu(String maNhanVien, String tenNhanVien, String trinhDo, String chuyenMon, double phuCapDocHai){
        super(maNhanVien, tenNhanVien, trinhDo);
        this.chuyenMon = chuyenMon;
        this.phuCapDocHai = phuCapDocHai;
    }
    
    public void setChuyenMon(String chuyenMon1){
        this.chuyenMon = chuyenMon1;
    }
    
    public String getChuyenMon(){
        return chuyenMon;
    }
    
    public void setPhuCapDocHai(double phuCapDocHai1){
        this.phuCapDocHai = phuCapDocHai1;
    }
    
    public double getPhuCapDocHai(){
        return phuCapDocHai;
    }
    
    @Override
    public void nhap(){
        super.nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuyen mon: ");
        this.chuyenMon = scanner.nextLine();
        System.out.print("Nhap phu cap doc hai: ");
        this.phuCapDocHai = scanner.nextDouble();
    }
    
    @Override
    public void xuat(){
        super.xuat();
        System.out.println(", Chuyen mon: " + chuyenMon + ", Phu cap doc hai: " + phuCapDocHai + ", Tong luong: " + tinhLuong());
    }
    
    @Override
    public double tinhLuong(){
        return luongCoBan + phuCapDocHai;
    }
}

class PhucVu extends NhanVien{
    public PhucVu(){
        super();
    }
    
    public PhucVu(String maNhanVien, String tenNhanVien, String trinhDo){
        super(maNhanVien, tenNhanVien, trinhDo);
    }
    
    @Override
    public double tinhLuong(){
        return luongCoBan;
    }
}

public class Bai01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();
        
        QuanLy quanly = new QuanLy("QL001", "Nguyen Van A", "Dai hoc", "Quan tri", 2000000);
        quanly.nhap();
        danhSachNhanVien.add(quanly);
        
        NghienCuu nghiencuu = new NghienCuu("NC001", "Tran Thi B", "Thac si", "Hoa hoc", 1500000);
        nghiencuu.nhap();
        danhSachNhanVien.add(nghiencuu);
        
        PhucVu phucvu = new PhucVu("PV001", "Le Van C", "Trung cap");
        phucvu.nhap();
        danhSachNhanVien.add(phucvu);
        
        System.out.println("\nDanh sach nhan vien:");
        
        for (NhanVien nv : danhSachNhanVien) {
            nv.xuat();
            System.out.println("Luong: " + nv.tinhLuong());
        }
        
        scanner.close();
    }
}
