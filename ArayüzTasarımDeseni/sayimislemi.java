
public class sayimIslemi {

	public urun sayimaraligi(int sayi) {
		if(sayi<=10) {
			System.out.println("uygun �r�n hemen yap");
			return new Uygunurun();
		}
		else {
			System.out.println("Sayim sonucu siparisler aras�na al�nd�");
			return new Siparisurunu();
		}
	}

}
