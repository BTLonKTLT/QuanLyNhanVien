import java.util.Date;
import java.util.LinkedList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pc
 */
public class DonVi {
    private final LinkedList<NhanVien> list;
    private int soNV;
    private String tenDonVi;
    
    
    public DonVi(String tenDonVi){
        this.soNV = 0;
        this.tenDonVi = tenDonVi;
        LinkedList<NhanVien> nv = new LinkedList();
        this.list = nv;                	
    }
    
    // Các phương thức getter và setter
    public int getSoNV(){
	return soNV;
    }

    public void setSoNV(int soNV){
	this.soNV = soNV;
    }

    public String getTenDonVi(){
	return tenDonVi;
    }

    public void setTenDonVi(String tenDonVi){
	this.tenDonVi = tenDonVi;
    }
    
    
    //Ngoài ra
    
    public String getTruongDonVi(){
    // Tìm kiếm trong list i = 1:soNV
    // Nếu list.get(i).chucVu = "Chu tich" or "Giam doc" or "Truong phong"
    // ==> Lấy
    String truongDonVi = null;
    int i;
    for (i=0;i<list.size();i++)
        switch (list.get(i).getChucVu()) {
            case "Chu tich":                
            case "Giam doc":               
            case "Truong phong":
                truongDonVi = list.get(i).getHo() + list.get(i).getTen();
            default:
                break;
        } 
    return truongDonVi;    
    }
    
    public String getPhoDonVi(){
    //Tìm kiếm trong list
    // Nếu list.get(i).ChucVu = "Pho chu tich" or "Pho giam doc" or "Pho phong"
    // ==> Lấy
    String phoDonVi = "";
    
    int i;
    for (i=0;i<list.size();i++)
        switch (list.get(i).getChucVu()) {
            case "Pho chu tich":              
            case "Pho giam doc":               
            case "Pho phong":
                phoDonVi = list.get(i).getHo() + list.get(i).getTen();
            default:
                break;
        }    
    return phoDonVi;  
    }
    
    void themNhanVien(NhanVien nv){        
    // list.add(nv);    
    // tăng số nhân viên lên 1
    
        list.add(nv);
        soNV++;      
    }
    
    void xoaNhanVien(NhanVien nv){
        
        //Xóa khỏi list
        //cập nhật lại số nhân viên
        
        list.remove(nv);
        soNV--;          	
    }
    
    public void toString(DonVi dv) {
    	//hiển thị thông tin đơn vị
        //Liệt kê tất cả các nhân viên trong đơn vị
        
        int i;
        for (i=0;i<dv.list.size();i++)
            dv.list.get(i).toString(dv.list.get(i));       
    }
    
    
    public LinkedList<NhanVien> timKiemTheoHoTen(String s){
        
        LinkedList<NhanVien> listnv = new LinkedList();
        int i;
        String s2;        
        for (i=0;i<list.size();i++){
            s2 = list.get(i).getHo() + list.get(i).getTen();
            if (s2.equals(s))
                listnv.add(list.get(i));
        }
        
        return listnv;
        
    } 
    
    public LinkedList<NhanVien> timKiemTheoChucVu(String s){
        
        LinkedList<NhanVien> listnv = new LinkedList();
        int i;
        for (i=0;i<list.size();i++)
            if (list.get(i).getChucVu().equals(s)){
                listnv.add(list.get(i));
            }
        
        return listnv;
    } 
    
    public LinkedList<NhanVien> timKiemTheoNgaySinh(Date d){
        
        LinkedList<NhanVien> listnv = new LinkedList();
        int i;
        for (i=0;i<list.size();i++)
            if (list.get(i).getNgaySinh().equals(d)){
                listnv.add(list.get(i));
            }
        
        return listnv;
        
    }
    
    public NhanVien timKiemTheoMSNV(String s){
        int i;
        for (i=0;i<list.size();i++){
            if (list.get(i).getMSNV().equals(s)){
                return list.get(i);
            }
        }
        
        return null;
    }
    
}