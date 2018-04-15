import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NgayLamViec {
	private final Date ngay;
	private final Time thoiGianDen;
	private final Time thoiGianVe;
	
	private static Time batDauGioLamViec;
	private static Time ketThucGioLamViec;
	
        private int thoiGianThieuHut;
        
	public NgayLamViec(String s) throws ParseException
	{
            //VD: 02/03/2018, 07:52, 18:02. split lấy từng dữ liệu
            String[] data = s.split(", ",3);
            
            //Setup dữ liệu
            ngay = new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(data[0]).getTime());
            thoiGianDen = new java.sql.Time(new SimpleDateFormat("HH:mm").parse(data[1]).getTime());
            thoiGianVe = new java.sql.Time(new SimpleDateFormat("HH:mm").parse(data[2]).getTime());
            
            //Thiết lập thời gian theo quy định
            String batDau, ketThuc;
            batDau = "08:30";
            ketThuc = "17:30";
            batDauGioLamViec = new java.sql.Time(new SimpleDateFormat("HH:mm").parse(batDau).getTime());
            ketThucGioLamViec = new java.sql.Time(new SimpleDateFormat("HH:mm").parse(ketThuc).getTime());

            // Tính thời gian thiếu hụt trong ngày
            
            if (thoiGianDen.getTime()>batDauGioLamViec.getTime())
                thoiGianThieuHut += batDauGioLamViec.getTime() - thoiGianDen.getTime();
        
            if (thoiGianVe.getTime()<ketThucGioLamViec.getTime())
                thoiGianThieuHut += (ketThucGioLamViec.getTime() - thoiGianVe.getTime());
	}
	
        //Số giờ thiếu hụt + số phút thiếu hụt
	public float thoiGian(){
            
            float hours = thoiGianThieuHut/3600000;
                                    
            return hours;
	}
        
}