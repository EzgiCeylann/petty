package com.petty.app.patterns.strategy;

import com.petty.app.model.BehaviorLog;

public class DogRecommendationStrategy implements RecommendationStrategy {

    @Override
    public String getRecommendation(BehaviorLog log) {
        String behavior = log.getBehavior();
        String subReason = log.getSubReason();

        switch (behavior) {
            case "Yorgun":
                return "• Sessiz ve rahat bir yerde dinlenmesine izin verin.\n" +
                        "• Temiz suya kolay ulaşmasını sağlayın.\n" +
                        "• Oyun ve fiziksel aktiviteye ara verin.\n" +
                        "• Çok sıcaksa serin bir ortam sağlayın.\n" +
                        "• Uzun süre halsiz görünüyorsa veterinere başvurun.";

            case "Hasta/Halsiz":
                if (subReason == null) return "";
                switch (subReason) {
                    case "Sindirimsel":
                        return "• Temiz suyu önünde tutun.\n" +
                                "• Son 24 saatte ne yediğini not alın.\n" +
                                "• Tuvaletini gözlemleyin.\n" +
                                "• Dinlenmesine izin verin.\n" +
                                "⚠️ Zehirli yiyecek yediyse acilen veterinere götürün.";
                    case "Stres":
                        return "• Sessiz, güvenli bir alan verin.\n" +
                                "• Günlük rutinini bozmamaya özen gösterin.\n" +
                                "• Sakin davranın, siz gerginseniz o da hisseder.\n" +
                                "• Kısa oyun veya basit eğitimler yapabilirsiniz.";
                    case "Yaralanma":
                        return "• Sakince yaklaşın, ani hareket olmasın.\n" +
                                "• Kan, şişlik veya yürüme sorunu var mı kontrol edin.\n" +
                                "• Kanıyorsa temiz bezle hafif baskı yapın.\n" +
                                "• Sessiz rahat bir yere alın.\n" +
                                "⚠️ Ekstrem durumlarda derhal veterinere götürün.";
                    case "Enfeksiyon":
                        return "• Temiz su erişimi sağlayın, dinlenmesine izin verin.\n" +
                                "• Göz veya burun akıntısını nemli bezle nazikçe temizleyin.\n" +
                                "• Ortamı rahat tutun.\n" +
                                "⚠️ Ekstrem durumlarda derhal veterinere götürün.";
                    default:
                        return "Köpeğinizi gözlemlemeye devam edin.";
                }

            case "Oyuncu":
                return "• Top oyunu oynatabilirsiniz.\n" +
                        "• Çekiştirme oyunu oynayabilirsiniz.\n" +
                        "• Koklamalı yürüyüşe çıkarabilirsiniz.\n" +
                        "• Diğer köpeklerle sosyalleşme aktiviteleri yapabilirsiniz. 🐾";

            case "Kızgın/Huysuz":
                if (subReason == null) return "";
                switch (subReason) {
                    case "Stres/Korku":
                        return "• Sessiz ve güvenli bir alan hazırlayın.\n" +
                                "• Yumuşak ve sakin bir ses tonuyla konuşun.\n" +
                                "• Ani hareketlerden ve yüksek sesten kaçının.\n" +
                                "• Stres kaynağı varsa o ortamdan uzaklaştırın.\n" +
                                "• Titreme veya panik uzun sürüyorsa veterinere başvurun.";
                    case "Aşırı Uyarılma":
                        return "• Daha sessiz ve sakin bir ortama alın.\n" +
                                "• Oyun veya yoğun aktiviteyi kısa süreli durdurun.\n" +
                                "• Ses tonunuzu sakin tutun, ani hareket yapmayın.\n" +
                                "• Basit komutlarla dikkatini yönlendirin (otur, bekle).\n" +
                                "• Sık tekrar ediyorsa oyun-dinlenme dengesini gözden geçirin.";
                    case "Ağrı/Hastalık":
                        return "• Hasta/Halsiz seçeneğini seçerek devam edin.";
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