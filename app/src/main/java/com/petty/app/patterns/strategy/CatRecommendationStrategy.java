package com.petty.app.patterns.strategy;

import com.petty.app.model.BehaviorLog;

public class CatRecommendationStrategy implements RecommendationStrategy {

    @Override
    public String getRecommendation(BehaviorLog log) {
        String behavior = log.getBehavior();
        String subReason = log.getSubReason();

        switch (behavior) {
            case "Yorgun":
                return "• Allow your cat to rest in a quiet and comfortable place.\n" +
                        "• Ensure easy access to clean water.\n" +
                        "• Give your cat space to rest on its own without disturbing it.\n" +
                        "• Pause play and physical activities.\n" +
                        "• Provide a cool environment if it is too warm.\n" +
                        "• Keep its bed or favorite blanket nearby.\n" +
                        "• Observe whether its energy returns after resting. Monitor its appetite and water intake.\n" +
                        "⚠️ If your cat appears lethargic for a long time or refuses to get up, consult a veterinarian.\n" +
                        "⚠️ If lethargy is accompanied by vomiting, diarrhea, or changes in breathing, seek veterinary attention immediately.";

            case "Hasta/Halsiz":
                if (subReason == null) return "• Monitor your cat's general condition closely.\n" +
                        "• Ensure access to clean water and a comfortable resting place.\n" +
                        "• Check whether your cat is eating and drinking normally.\n" +
                        "• If your cat's condition does not improve within 24 hours or worsens, consult a veterinarian.\n" +
                        "⚠️ If you observe any extreme symptoms such as difficulty breathing, collapse, or seizures, take your cat to the veterinarian immediately.";                switch (subReason) {
                    case "Sindirimsel":
                        return "• Keep clean water accessible to your cat today.\n" +
                                "• Think about what your cat has eaten in the last 24 hours and take notes.\n" +
                                "• Check the litter box.\n" +
                                "⚠️ If you notice any abnormality, you should contact your veterinarian.";
                    case "Stres":
                        return "• Create a quiet and safe space for your cat.\n" +
                                "• Keep its favorite toy or blanket nearby.\n" +
                                "• If it does not want to be petted, give it some distance. If it is being clingy, stay by its side.\n" +
                                "⚠️ If you notice any abnormality, you should contact your veterinarian.";
                    case "Yaralanma":
                        return "• If there is bleeding, apply gentle pressure with a clean cloth and take your cat to the vet immediately.\n" +
                                "• Do not try to give your cat medications intended for humans.\n" +
                                "• Observe without forcing interaction.\n" +
                                "⚠️ In extreme cases, take your cat to the veterinarian immediately. If your cat's condition does not improve or worsens, do not waste time consulting your veterinarian.";
                    case "Enfeksiyon":
                        return "• Sneezing, eye discharge, sensation of fever, and lethargy may be signs of infection.\n" +
                                "• Keep the environment warm and comfortable, encourage water intake, and monitor appetite.\n" +
                                "• If your cat has not eaten for 1 full day, contact your veterinarian.\n" +
                                "⚠️ In extreme cases, take your cat to the veterinarian immediately. If your cat's condition does not improve or worsens, do not waste time consulting your veterinarian.";
                    default:
                        return "Continue observing your cat.";
                }

            case "Oyuncu":
                return "• You can play chase inside your home, or use a soft ball or feather toy to play with your cat.\n" +
                        "• If you have a laser toy, you can let your cat chase it to help release its energy.\n" +
                        "• A cat tree is ideal for cats to release energy and trim their claws at the same time. If you do not have one, definitely consider getting one. 🐾";

            case "Kizgin/Huysuz":
                return "• Cats can sometimes act irritable on days when they feel stressed, energetic, or uncomfortable. Giving them space without forcing interaction, playing a short game, and checking their food, water, and litter box routine can help.\n" +
                        "• If your cat is normally calm but has suddenly become aggressive, it may also have a physical discomfort.\n" +
                        "• If you think there is a physical issue, you can select the Sick/Lethargic option to receive recommendations, or contact your veterinarian directly.";

            case "Sakin/Mutlu":
                return "• Great! Your cat is feeling very well today. 🐱\n" +
                        "• Enjoy this wonderful moment together.";

            default:
                return "Continue observing your cat.";
        }
    }
}