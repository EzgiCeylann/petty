package com.petty.app.patterns.strategy;

import com.petty.app.model.BehaviorLog;

public class CatRecommendationStrategy implements RecommendationStrategy {

    @Override
    public String getRecommendation(BehaviorLog log) {
        String behavior = log.getBehavior();
        String subReason = log.getSubReason();

        switch (behavior) {
            case "Yorgun":
                return "• Kedinizin sessiz ve rahat bir yerde dinlenmesine izin verin.\n" +
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
                    return "• Kedinizin genel durumunu yakından takip edin.\n" +
                            "• Temiz su ve rahat bir dinlenme alanı sağlayın.\n" +
                            "• Normal yiyip içip içmediğini kontrol edin.\n" +
                            "• 24 saat içinde durumu düzelmezse ya da kötüleşirse veterinere başvurun.\n" +
                            "⚠️ Nefes darlığı, bayılma veya nöbet gibi aşırı belirtiler gözlemlerseniz kedinizi derhal veterinere götürün.";
                switch (subReason) {
                    case "Sindirimsel":
                        return "• Bugün temiz suyu kedinize erişilebilir tutun.\n" +
                                "• Son 24 saat içerisinde ne yediğini düşünün, not alın.\n" +
                                "• Kumunu kontrol edin.\n" +
                                "⚠️ Bir anormallik fark ederseniz veterinerinizle iletişime geçmelisiniz.";
                    case "Stres":
                        return "• Sessiz, güvenli bir alan oluşturun.\n" +
                                "• Sevdiği bir oyuncak veya battaniyesini yanında tutun.\n" +
                                "• Sevilmek istemiyorsa biraz mesafe tanıyın. Sırnaşıyorsa yanında olun.\n" +
                                "⚠️ Bir anormallik fark ederseniz veterinerinizle iletişime geçmelisiniz.";
                    case "Yaralanma":
                        return "• Kanama varsa hafifçe bir bezle baskı yapın ve derhal veterinere götürün.\n" +
                                "• İnsanlara özgü ilaçları kedinize vermeye çalışmayın.\n" +
                                "• Zorlamadan gözlem yapın.\n" +
                                "⚠️ Ekstrem durumlarda kedinizi derhal veterinere götürün. Durumu iyileşmiyor ya da kötüleşiyorsa vakit kaybetmeden veterinerinize danışın.";
                    case "Enfeksiyon":
                        return "• Hapşırma, göz akıntısı, ateş hissi ve halsizlik enfeksiyon belirtisi olabilir.\n" +
                                "• Ortamı sıcak ve rahat tutun, su içmesini teşvik edin, iştahını gözlemleyin.\n" +
                                "• 1 gün boyunca ciddi şekilde iştahsızsa veterinerinizle iletişime geçin.\n" +
                                "⚠️ Ekstrem durumlarda kedinizi derhal veterinere götürün. Durumu iyileşmiyor ya da kötüleşiyorsa vakit kaybetmeden veterinerinize danışın.";
                    default:
                        return "Kedinizi gözlemlemeye devam edin.";
                }

            case "Oyuncu":
                return "• Evinizin içerisinde kovalamaca oynayabilir, yumuşak bir topla veya tüylü bir oyuncakla onu oylatabilirsiniz.\n" +
                        "• Lazer oyuncağınız varsa bunu takip etmesini sağlayabilir, bu şekilde enerjisini atmasını sağlayabilirsiniz.\n" +
                        "• Tırmanma ağacı kedilerin enerjisini atması ve tırnaklarını törpülemeleri için çok idealdir. Tırmanma ağacınız yoksa bu seçeneği kesinlikle değerlendirin. 🐾";

            case "Kızgın/Huysuz":
                return "• Kediler bazen stresli, enerjik ya da rahatsız hissettikleri günlerde huysuz davranabiliyor. Zorlamadan biraz alan vermek, kısa bir oyun oynatmak ve mama-su-kum düzenini kontrol etmek iyi gelebilir.\n" +
                        "• Normalde sakin bir kediyse ve aniden agresifleştiyse fiziksel bir rahatsızlığı da olabilir.\n" +
                        "• Fiziksel bir rahatsızlığı olduğunu düşünüyorsanız Hasta/Halsiz seçeneğini işaretleyip öneriler alabilir ya da doğrudan veterinerinizle iletişime geçebilirsiniz.";

            case "Sakin/Mutlu":
                return "• Harika! Kediniz bugün çok iyi hissediyor. 🐱\n" +
                        "• Bu güzel anın tadını çıkarın.";

            default:
                return "Kedinizi gözlemlemeye devam edin.";
        }
    }
}