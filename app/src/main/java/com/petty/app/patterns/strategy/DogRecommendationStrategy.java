package com.petty.app.patterns.strategy;

import com.petty.app.model.BehaviorLog;

public class DogRecommendationStrategy implements RecommendationStrategy {

    @Override
    public String getRecommendation(BehaviorLog log) {
        String behavior = log.getBehavior();
        String subReason = log.getSubReason();

        switch (behavior) {
            case "Yorgun":
                return "• Allow your dog to rest in a quiet and comfortable place.\n" +
                        "• Ensure easy access to clean water.\n" +
                        "• Give your dog space to rest on its own without disturbing it.\n" +
                        "• Pause play and physical activities.\n" +
                        "• Provide a cool environment if it is too warm.\n" +
                        "• Keep its bed or favorite blanket nearby.\n" +
                        "• Observe whether its energy returns after resting. Monitor its appetite and water intake.\n" +
                        "⚠️ If your dog appears lethargic for a long time or refuses to get up, consult a veterinarian.\n" +
                        "⚠️ If lethargy is accompanied by vomiting, diarrhea, or changes in breathing, seek veterinary attention immediately.";

            case "Hasta/Halsiz":
                if (subReason == null) return "• Monitor your dog's general condition closely.\n" +
                        "• Ensure access to clean water and a comfortable resting place.\n" +
                        "• Check whether your dog is eating and drinking normally.\n" +
                        "• If your dog's condition does not improve within 24 hours or worsens, consult a veterinarian.\n" +
                        "⚠️ If you observe any extreme symptoms such as difficulty breathing, collapse, or seizures, take your dog to the veterinarian immediately.";                switch (subReason) {
                    case "Sindirimsel":
                        return "• Keep clean water in front of your dog.\n" +
                                "• Take notes on what your dog has eaten in the last 24 hours.\n" +
                                "• Monitor your dog's toilet habits.\n" +
                                "• Allow your dog to rest, do not engage it in extra activities.\n" +
                                "⚠️ If your dog has eaten foods that may be toxic to dogs such as chocolate, onion, or avocado, or if your dog is showing extreme abnormalities, take it to the vet immediately.";
                    case "Stres":
                        return "• Give your dog a quiet and safe space — its bed, favorite corner, or carrier. Let it go there on its own.\n" +
                                "• Try not to disrupt its daily routine. Dogs love predictable order.\n" +
                                "• Stay calm yourself. If you are tense, your dog will feel it too.\n" +
                                "• Allow your dog to sniff during walks — sniffing without rushing is calming for dogs.\n" +
                                "• You can do short play sessions or simple training exercises. Familiar activities will give your dog confidence.";
                    case "Yaralanma":
                        return "• Approach calmly — no sudden movements.\n" +
                                "• Limit movement — do not let your dog run or jump.\n" +
                                "• Check for signs: is there bleeding, swelling, or something stuck in the paw? Can it put weight on its leg?\n" +
                                "• If bleeding: apply gentle pressure with a clean cloth.\n" +
                                "• Move your dog to a quiet and comfortable place.\n" +
                                "• Rest is important.\n" +
                                "⚠️ In extreme cases, take your dog to the veterinarian immediately. If your dog's condition does not improve or worsens, do not waste time consulting your veterinarian.";
                    case "Enfeksiyon":
                        return "• Ensure access to clean water and allow your dog to rest.\n" +
                                "• Gently clean any eye or nasal discharge with a clean damp cloth.\n" +
                                "• Keep the environment comfortable.\n" +
                                "⚠️ In extreme cases, take your dog to the veterinarian immediately. If your dog's condition does not improve or worsens, do not waste time consulting your veterinarian.";
                    default:
                        return "Continue observing your dog.";
                }

            case "Oyuncu":
                return "• You can play fetch with a ball.\n" +
                        "• You can play tug of war.\n" +
                        "• You can take your dog on a sniffing walk and socialize with other dogs to help release its energy. 🐾";

            case "Kizgin/Huysuz":
                if (subReason == null) return "Please select a sub-reason to receive specific recommendations.";
                switch (subReason) {
                    case "Stres/Korku":
                        return "• Prepare a quiet and safe space for your dog.\n" +
                                "• Speak in a soft and calm tone of voice.\n" +
                                "• Avoid sudden movements and loud sounds.\n" +
                                "• If there is a source of stress such as a crowd, noise, or another animal, remove your dog from that environment.\n" +
                                "• In mild stress situations, use a treat or simple commands to redirect its attention.\n" +
                                "• Allow sniffing during walks — do not rush your dog.\n" +
                                "• Give your dog time to calm down, do not expect immediate improvement.\n" +
                                "⚠️ If trembling, panic, refusal to eat, or hiding persists for a long time, consult a veterinarian.";
                    case "Asiri Uyarilma":
                        return "• Move your dog to a quieter and calmer environment.\n" +
                                "• Briefly stop play or intense activity.\n" +
                                "• Keep your voice tone calm and soft, avoid sudden movements.\n" +
                                "• Do not increase excitement — keep the environment less stimulating.\n" +
                                "• Use simple commands to calmly redirect attention (sit, wait, etc.).\n" +
                                "• If crowds or excessive stimuli are present, reduce them.\n" +
                                "• Give your dog time until its breathing and body language calm down.\n" +
                                "• If this happens frequently, review the balance between daily play and rest.";
                    case "Agri/Hastalik":
                        return "• Please select the Sick/Lethargic option and follow the recommendations provided there.";
                    default:
                        return "Continue observing your dog.";
                }

            case "Sakin/Mutlu":
                return "• Great! Your dog is feeling very well today. 🐶\n" +
                        "• Enjoy this wonderful moment together.";

            default:
                return "Continue observing your dog.";
        }
    }
}