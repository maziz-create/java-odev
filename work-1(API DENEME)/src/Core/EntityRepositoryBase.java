package Core;
/*
* IEntityRepository üzerinden fonksiyon imzası alsaydık burada da içlerini dolduracaktık.
* Apiden veri alma işlemi çok genel bir işlem olmadığı için burada yapmadım.
* Burada, bütün senaryolarda ortak olan işlemler kullanılır.
* Örneğin: ekleme, silme, güncelleme ya da listeleme.
* Seçtiğim senaryoda bunlara yer olmadığı için, kullanacağım fonksiyonların imzasını
* IHavaDurumuDal içinde tanımlayıp, HavaDurumuDal içerisinde de içlerini doldurdum.
*
* T neyi ifade ediyor? Bizimle çalışacak her classın kendi Entity'i bulunur.
* Hangi Entity ile işlem yapacaksa o Entity için ekleme silme güncelleme listeleme
*  işlemleri yapılır. Bizim senaryomuzda tek bir Entity var, o da HavaDurumu.
* */
public class EntityRepositoryBase<T> implements IEntityRepository<T> {
}
