#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int ngay, thang, nam;

char* createEmail(char* HD, char* T)
{
	char* email = new char[30];
	int index;
	for(int i = 0; i < strlen(HD); i++)
	{
		if (HD[i] != ' ') 
		{
			email[index] = tolower(HD[i]);
			index++;
		}
	}
	
	for(int i = 0; i < strlen(T); i++)
	{
		email[index] = tolower(T[i]);
		index++;
	}
	
	email[index] = '\0';
	return email;
}

bool check()
{
	if (nam < 2017) return 1;
	else if ((nam == 2018) && (thang < 4)) return 1;
	else if ((nam == 2018) && (thang == 4) && (ngay < 10)) return 1;
	else return 0;
}

int maxDate()
{
	switch (thang)
	{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 2:
			{
				if (((nam%4 == 0)&&(nam%100)) || ((nam%100 == 0)&&(nam%400 == 0))) return 29;
				else return 28;
			}
		default:
			return 30;
	}
}
int  dayofweek(int y, int m, int d)  /* 1 <= m <= 12,  y > 1752 (in the U.K.) */
{
    static int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
    y -= m < 3;
    return (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7; /* returns 0 = Sunday, 1 = Monday*/
}
void plusDate()
{
	ngay ++;
	if (ngay  > maxDate())
	{
		ngay = 1;
		thang++;
		if (thang > 12)
		{
			thang = 1;
			nam ++;
		}
	}
	
	
	int weekday = dayofweek(nam, thang, ngay);
	if (weekday == 6 || weekday == 0)
		plusDate();
}

main()
{
	char* hoDem[] = {"Nguyen Van", "Do", "Vuong Chi", "Tran Van", "Pham Dang", "Vu Dinh", "Nguyen Son", "Le Hoang", "Nguyen Xuan", "Kieu", "Do Thi", "Nguyen Thi", "Vu Hong", "Pham Khanh", "Dinh Thi"};
	char* ten[] = {"Hung", "Son", "Lan", "Tai", "Doan", "Hieu", "Thao", "Tien", "Tiep", "Ly", "Mai", "Dung", "Toan", "Dung", "Viet", "Trinh", "Duong", "Hanh", "Hien", "Van", "Nam"};
	char* phong[] = {"Phong nhan su", "Phong tai chinh", "Phong ke toan", "Phong sang tao", "Phong tap vu" };
	char* congTy[] = {"BK Entertainment", "BK Food", "BK Tech"};
	char* tinhThanh[] = {"Ha Noi", "Hai Phong", "Thai Binh", "Nam Dinh", "Ninh Binh", "Quang Ninh", "Hai Duong", "Hung Yen", "Ha Nam", "Nghe An"};
	char* pho[] = {"Ta Quang Buu", "Tran Dai Nghia", "Le Thanh Nghi", "Tran Hung Dao", "Tay Son", "Thai Ha", "Thanh Xuan", "Quang Trung", "Nguyen Trai", "Hai Ba Trung"};
	char* dauSDT[] = {"098", "016", "097", "012", "088"};
	
	char* hour[] = {"06", "07", "08", "17", "18"};
	char* minute[] = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
	char* day[] = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	char* month[] = {"00", "01", "02", "03", "04", "05","06","07","08","09","10","11","12"};
	
	FILE* f = fopen("ThongTinNhanVien.txt", "w");
	for(int i = 1; i <= 100; i++)
	{
		fprintf(f, "NV%d\n", i);
		char* HD = hoDem[rand() % 15];
		fprintf(f, "%s\n", HD);
		char* T = ten[rand() % 21];
		fprintf(f, "%s\n", T);
		fprintf(f, "%s - %s\n", phong[rand() % 5], congTy[rand() % 3]);
		fprintf(f, "%d/%d/%d\n", rand() % 28 + 1, rand() % 12 +1, rand() % 40 + 1955);
		fprintf(f, "%s\n", tinhThanh[rand() % 10]);
		fprintf(f, "So %d, %s\n", rand() % 100 + 1, pho[rand() % 10]);
		fprintf(f, "%s@gmail.com\n", createEmail(HD, T));
		fprintf(f,"%s%d%d%d%d%d%d%d\n", dauSDT[rand() % 5], rand()%10, rand()%10, rand()%10, rand()%10, rand()%10, rand()%10, rand()%10);
		ngay = rand() % 28 + 1;
		thang = rand() % 12 + 1;
		nam = rand() % 7 + 2010;
		fprintf(f,"%d/%d/%d\n", ngay, thang, nam);
		
		ngay = 1; thang = 3; nam = 2018;
		while(check())
		{
			plusDate();
			if (rand() % 20 == 0) continue;
			fprintf(f, "%s/%s/%d, %s:%s, %s:%s\n", day[ngay],month[thang], nam, hour[rand() % 3], minute[rand() % 60], hour[rand() % 2 + 3], minute[rand() % 60] );
												/*	day[ngay],month[thang], nam*/
		}
	}
	fclose(f);
}
