# Yazılım Mimarisi ve Tasarımı Dersi Proje

# Konu:Müşteri Kullanıcı Ürün Seçim Arayüzü Tasarım Deseni ve Strateji Tasarım Deseni Örneği
  
# Müşteri Kullanıcı Ürün Seçim Arayüzü Tasarım Deseni:
  Müşteri Kullanıcı Ürün Seçim Arayüzü tasarım deseni, Ürün sipariş yükünün yapıcıdan alıcıya verilmesidir. Sipariş edilen nesne, bir katagori ayrımının hiyerarşiye ayrılmış halidir. Hangi katagorinin yapılacağı işi satıcıdan alıcıya yüklenir. Bu yordam ile belirli bir katgori hiyerarşisindeki alt ürünlerden birinin sipariş sorumluluğu belirli bir arayüze verilerek sistemden soyutlanmış olur. Böylece siparişi hazırlama kodlarında, kod tekrarları önlenmiş olur. Sistem içinde katagorilerin yaratılacağı yer tek olduğu için, ilgili oluşumlar bir arada alınabilir.
 ![Image of Class](https://github.com/hakanulass/ProjeDeseniTasarimi/blob/master/classdiagram.png)
 
 
 somut sınıf
 ```java
public class Siparisurunu implements urun {

	@Override
	public void istek(int sayi) {

		System.out.println(URUN BEKLENEN SAYİDAN AZ UYGUN URUNE EKLENDI !!! );
		System.out.println(URUN SIPARIS URUNLER ARASINA EKLENDI);
	}

}
```
somut sınıf
 ```java
public class Uygunurun implements urun {
	@Override
	public void istek(int sayi) {

		System.out.println("URUN ISTENEN DEGERE UUYGUN DEGIL ");
		System.out.println("URUN ISTEKLER ARASINA EKLENDİ");
	}

}
 ```
 Girilen değere göre hangi katagorinin elemanı olduguna karar verir 
  ```java
public class sayimIslemi {

	public urun sayimaralýgý(int sayi) {
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
 ```
 Main:
 Burda sayım işlemi ile katagori ayrımı yapılır.katagorinin sınıfı aktive edilie.Aralığa göre katagori ayrımı yapılarak satıcı işlemi bitirilir.
  ```java
  public class calıstır {

	 public static void main( final String[] args ) {

	      	  int sayi=10;
	    	  sayimIslemi say = new sayimIslemi();
		      urun sayi = say.sayimaralıgı(sayi);
		      sayi.islem(sayi);
	   }
}
  interface
   ```java
 public interface urun {

	void olcum(int kg);
}
 
 ```
# Strateji (DAVRANIŞSAL) Tasarım Deseni:
 Strateji(Strategy) tasarım deseni, behavioral tasarım desenlerinden biridir. Bir dizi algoritma tanımlar, bu algoritmaların erişimi için arayüz sağlar ve algoritmaları tanımlarken birbirlerinin yerine kullanılabilir özellikte tasarlar. Ayrıca client runtime zamanında dilediği algoritmayı seçebilir. 
  
  
  ![Image of Class](https://github.com/hakanulass/ProjeDeseniTasarimi/blob/master/StrategyDesing.png)
  


# Ne zaman Kullanılır?

Belirli bir iş için birden çok algoritmaya(yönteme) sahip olduğumuzda kullanılır.

# Nasıl Kullanılır?

Öncelikle bir algoritma interface'i oluşturulur .Daha sonra oluşturulan interface'i implement edecek algoritma sınıfları yaratılır. Context sınıfı yaratılır. Bu sınıf içerisinde algoritma interface türünden algoritmaların set edilmesi için bir metod bulunur. Bu metod sayesinde Context sınıfı algoritma nesnesini tutmuş olur. Son olarak bir Client sınıfı oluşturulur. Bu sınıf Context sınıfından ve algoritma sınıflardan nesneler üreterek işlemlerin yapılmasını sağlar 

Interface
  ```java
public interface Communicate {
    public void submission();
}
 
 ```
Context Sınıfı
  ```java
  public class Context {
    private Communicate communicate;

    public void setCommunicate(Communicate communicate) {
        this.communicate = communicate;
    }
    public void sendInformation(){
        communicate.submission();
    }
}

 ```
 Somut Sınıf
 ```java
 public class Read implements Communicate {
    @Override
    public void submission() {
        System.out.println("Read the environment");
    }
}

 ```
 Somut Sınıf
 ```java
 public class Build implements Communicate {
    @Override
    public void submission() {
        System.out.println("Build the screen");
    }
}

 ```
Test Sınıf
 ```java
public class Approve {
    public static void main(String[] args) {
        Context context=new Context();
        context.setCommunicate(new Read());
        context.sendInformation();
        context.setCommunicate(new Sms());
        context.sendInformation();
    }
}

  ```



















