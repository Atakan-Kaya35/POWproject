# POW
◊ Cart'a ilaç ekleme, sipariş edince cart'ın sıfırlannması, gün bitse bile carttaki ilaçların silinmeyip kalmaya devam etmesi gayet iyi çalışıyor!

Order sınıfı için pill hazırlarken pill type ve pill instance tamamen farklı ama bu ayrım çoğu yerde yapılmıyor.
Pill instance kullanıcıya getirilen bir kutu ilaçken pill type tamamen farklı.  
Bu ayrım öncesinde yoktu fakat yeni düzenlemede medication artık kullanım döngü miktarını tutuyor.
Bu döngünün sonuna gelince yeni bir pill sipariş ederken ise pill type alınıp yeni bir pill miktarı getiriliyor olmalı. 

SORUNUMSU ŞEYLER
1. Map printlerken stationary'nın koordinatlarını değiştirsem de hep aynı yerde büyük bir boşluk bırakıyor.
Acaba constant olarak bi yerlere bişiler mi girdik?

2. showTraffic ve !showTraffic olarak bastırsam da aynı output çıkıyor.