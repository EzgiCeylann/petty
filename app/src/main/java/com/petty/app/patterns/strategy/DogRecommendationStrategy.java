package com.petty.app.patterns.strategy;

import com.petty.app.model.BehaviorLog;

public class DogRecommendationStrategy implements RecommendationStrategy {

    @Override
    public String getRecommendation(BehaviorLog log) {
        String behavior = log.getBehavior();
        String subReason = log.getSubReason();

        switch (behavior) {
            case "Yorgun":
                return "• Köpeğinizin sessiz ve rahat bir yerde dinlenmesine izin verin.\n" +
                        "• Temiz suya kolay ulaşmasını sağlayın.\n" +
                        "• Üzerine gitmeden kendi kendine dinlenmesine fırsat verin.\n" +
                        "• Oyun ve fiziksel aktiviteye ara verin.\n" +
                        "• Çok sıcaksa serin bir ortam sağlayın.\n" +
                        "• Yatağını ya da sevdiği battaniyesini yakınında tutun.\n" +
                        "• Dinlendikten sonra enerjisinin geri gelip gelmediğini gözlemleyin. İştahını ve su içmesini takip edin.\n" +
                        "⚠️ Uzun süre halsiz görünüyorsa ya da ayağa kalkmak istemiyorsa veterinere başvurun.\n" +
                        "⚠️ Halsizliğe kusma, ishal veya nefes değişikliği eşlik ediyorsa vakit kaybetmeden veterinere gidin.";

            case "Hasta/Halsiz":
                if (subReason == null)
                    return "• Köpeğinizin genel durumunu yakından takip edin.\n" +
                            "• Temiz su ve rahat bir dinlenme alanı sağlayın.\n" +
                            "• Normal yiyip içip içmediğini kontrol edin.\n" +
                            "• 24 saat içinde durumu düzelmezse ya da kötüleşirse veterinere başvurun.\n" +
                            "⚠️ Nefes darlığı, bayılma veya nöbet gibi aşırı belirtiler gözlemlerseniz köpeğinizi derhal veterinere götürün.";
                switch (subReason) {
                    case "Sindirimsel":
                        return "• Temiz suyu önünde tutun.\n" +
                                "• Son 24 saatte ne yediğini not alın.\n" +
                                "• Tuvaletini gözlemleyin.\n" +
                                "• Dinlenmesine izin verin, ekstra aktiviteye sokmayın.\n" +
                                "⚠️ Çikolata, soğan, avokado gibi köpeklere zehirli olabilecek yiyecekler yediyse ya da aşırı anormallik sergiliyorsa acilen veterinere götürün.";
                    case "Stres":
                        return "• Sessiz, güvenli bir alan verin — yatağı, sevdiği köşe veya taşıma alanı. Oraya kendi gitsin.\n" +
                                "• Günlük rutinini bozmamaya özen gösterin. Köpekler tahmin edilebilir düzeni severler.\n" +
                                "• Sakin davranın. Siz gerginseniz o da hisseder.\n" +
                                "• Yürüyüşte acele ettirmeden koklamasına izin verin, bu köpekleri rahatlatır.\n" +
                                "• Kısa oyun veya basit eğitimler yapabilirsiniz. Tanıdık aktiviteler ona güven verir.";
                    case "Yaralanma":
                        return "• Sakince yaklaşın, ani hareket olmasın.\n" +
                                "• Hareketi azaltın — koşmasın, zıplamasın.\n" +
                                "• Kontrol edin: kan var mı, şişlik var mı, patiye bir şey battı mı, ayağını yere koyabiliyor mu?\n" +
                                "• Kanıyorsa temiz bezle hafif baskı yapın.\n" +
                                "• Sessiz, rahat bir yere alın. Dinlenmesi önemli.\n" +
                                "⚠️ Ekstrem durumlarda köpeğinizi derhal veterinere götürün. Durumu iyileşmiyor ya da kötüleşiyorsa vakit kaybetmeden veterinerinize danışın.";
                    case "Enfeksiyon":
                        return "• Temiz su erişimi sağlayın, dinlenmesine izin verin.\n" +
                                "• Göz veya burun akıntısını temiz nemli bezle nazikçe temizleyin.\n" +
                                "• Ortamı rahat tutun.\n" +
                                "⚠️ Ekstrem durumlarda köpeğinizi derhal veterinere götürün. Durumu iyileşmiyor ya da kötüleşiyorsa vakit kaybetmeden veterinerinize danışın.";
                    default:
                        return "Köpeğinizi gözlemlemeye devam edin.";
                }

            case "Oyuncu":
                return "• Top oyunu oynatabilirsiniz.\n" +
                        "• Çekiştirme oyunu oynayabilirsiniz.\n" +
                        "• Koklamalı yürüyüşe çıkarabilir, diğer köpeklerle sosyalleşme aktivitelerine götürebilirsiniz. 🐾";

            case "Kızgın/Huysuz":
                if (subReason == null)
                    return "Köpeğinizi gözlemlemeye devam edin.";
                switch (subReason) {
                    case "Stres/Korku":
                        return "• Köpeğiniz için sessiz ve güvenli bir alan hazırlayın.\n" +
                                "• Yumuşak ve sakin bir ses tonuyla konuşun.\n" +
                                "• Ani hareketlerden ve yüksek sesten kaçının.\n" +
                                "• Stres kaynağı varsa (kalabalık, gürültü, başka hayvan) o ortamdan uzaklaştırın.\n" +
                                "• Hafif stres durumunda ödül maması veya basit komutlarla dikkatini başka yöne çekin.\n" +
                                "• Yürüyüşe çıkıyorsa acele ettirmeden etrafı koklamasına izin verin.\n" +
                                "• Rahatlaması için zaman tanıyın, hemen düzelmesini beklemeyin.\n" +
                                "⚠️ Titreme, panik, yememe veya saklanma uzun sürüyorsa veterinere başvurun.";
                    case "Aşırı Uyarılma":
                        return "• Köpeği daha sessiz ve sakin bir ortama alın.\n" +
                                "• Oyun veya yoğun aktiviteyi kısa süreli durdurun.\n" +
                                "• Ses tonunuzu sakin ve yumuşak tutun, ani hareket yapmayın.\n" +
                                "• Basit komutlarla dikkatini sakin şekilde yönlendirin (otur, bekle gibi).\n" +
                                "• Kalabalık veya fazla uyarıcı varsa ortamı azaltın.\n" +
                                "• Nefesi ve beden dili sakinleşene kadar zaman tanıyın.\n" +
                                "• Sık tekrar ediyorsa günlük oyun ve dinlenme dengesini gözden geçirin.";
                    case "Ağrı/Hastalık":
                        return "• Lütfen Hasta/Halsiz seçeneğini seçerek devam edin.";
                    default:
                        return "Köpeğinizi gözlemlemeye devam edin.";
                }

            case "Sakin/Mutlu":
                return "• Harika! Köpeğiniz bugün çok iyi hissediyor. 🐶\n" +
                        "• Bu güzel anın tadını çıkarın.";

            default:
                return "Köpeğinizi gözlemlemeye devam edin.";
        }
    }
}