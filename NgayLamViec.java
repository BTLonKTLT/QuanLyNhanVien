import java.sql.Time;
<<<<<<< HEAD
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NgayLamViec {
	private final Date ngay;
	private final Time thoiGianDen;
	private final Time thoiGianVe;
=======
import java.util.Date;

public class NgayLamViec {
	private Date ngay;
	private Time thoiGianDen;
	private Time thoiGianVe;
>>>>>>> 69d8fd5866bd3925c6f4b56f31cde3efb9f48124
	
	private static Time batDauGioLamViec;
	private static Time ketThucGioLamViec;
	
<<<<<<< HEAD
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
	public int soGioThieuHut(){
            
            int hours = (int) Math.round(thoiGianThieuHut/3600000);
            
            return hours;
	}
        
        public int soPhutThieuHut(){

            int hours = soGioThieuHut();
            int minutes = (int) Math.round((thoiGianThieuHut - hours * 3600000) / 60000);
            
            return minutes;
        }
}
=======
	public NgayLamViec(String s)
	{
		
	}
	
	//trả về khoảng thời gian giữa lúc về và đến
	public float thoiGian()
	{
		
	}
}
>>>>>>> 69d8fd5866bd3925c6f4b56f31cde3efb9f48124
