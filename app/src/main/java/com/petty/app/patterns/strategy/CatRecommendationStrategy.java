package com.petty.app.patterns.strategy;

import com.petty.app.model.BehaviorLog;

public class CatRecommendationStrategy implements RecommendationStrategy {

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
                        return "• Temiz suyu kedinize erişilebilir tutun.\n" +
                                "• Son 24 saat içerisinde ne yediğini not alın.\n" +
                                "• Kumunu kontrol edin.\n" +
                                "⚠️ Anormallik fark ederseniz veterinerinizle iletişime geçin.";
                    case "Stres":
                        return "• Sessiz, güvenli bir alan oluşturun.\n" +
                                "• Sevdiği bir oyuncak veya battaniyesini yanında tutun.\n" +
                                "• Sevilmek istemiyorsa mesafe tanıyın.\n" +
                                "⚠️ Anormallik fark ederseniz veterinerinizle iletişime geçin.";
                    case "Yaralanma":
                        return "• Kanama varsa hafifçe bir bezle baskı yapın.\n" +
                                "• İnsanlara özgü ilaçları vermeye çalışmayın.\n" +
                                "• Zorlamadan gözlem yapın.\n" +
                                "⚠️ Ekstrem durumlarda derhal veterinere götürün.";
                    case "Enfeksiyon":
                        return "• Hapşırma, göz akıntısı, ateş enfeksiyon belirtisi olabilir.\n" +
                                "• Ortamı sıcak ve rahat tutun, su içmesini teşvik edin.\n" +
                                "• 1 gün ciddi iştahsızlık varsa veterinere gidin.\n" +
                                "⚠️ Ekstrem durumlarda derhal veterinere götürün.";
                    default:
                        return "Kedinizi gözlemlemeye devam edin.";
                }

            case "Oyuncu":
                return "• Evinizde kovalamaca oynayabilirsiniz.\n" +
                        "• Yumuşak top veya tüylü oyuncak kullanın.\n" +
                        "• Lazer oyuncağıyla enerjisini atmasını sağlayın.\n" +
                        "• Tırmanma ağacı hem enerji atar hem tırnak törpüler. 🐾";

            case "Kızgın/Huysuz":
                return "• Zorlamadan biraz alan verin.\n" +
                        "• Kısa bir oyun oynatın.\n" +
                        "• Mama, su ve kum düzenini kontrol edin.\n" +
                        "• Aniden agresifleştiyse fiziksel rahatsızlık olabilir, hasta seçeneğini değerlendirin.";

            case "Sakin/Mutlu":
                return "• Harika! Kediniz bugün çok iyi hissediyor. 🐱\n" +
                        "• Bu güzel anın tadını çıkarın.";

            default:
                return "Kedinizi gözlemlemeye devam edin.";
        }
    }
}