
public class sayimIslemi {

	public urun sayimaraligi(int sayi) {
		if(sayi<=10) {
			System.out.println("uygun ürün hemen yap");
			return new Uygunurun();
		}
		else {
			System.out.println("Sayim sonucu siparisler arasýna alýndý");
			return new Siparisurunu();
		}
	}

}
