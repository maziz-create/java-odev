package Core;
/*
Buraya, abstract sınıfımız olan EntityRepositoryBase için imza fonksiyonlar yazacağız.
Buraya yazacağımız fonksiyonlar, bütün managerlerin kullanabileceği şeyler olmalı.
Mesela, senaryo ne olursa olsun her zaman ekleme,silme,güncelleme ve listeleme işlemleri
vardır. Buraya onları yazabiliriz. Peki senaryoların ek fonksiyonlarının imzası nereye
yazılır?
*/

public interface IEntityRepository<T> {
    void kimlikGoster(T nesne);
}
