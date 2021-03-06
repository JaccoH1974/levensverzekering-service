package nl.bank.levensverzekeringservice;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
@Service
@NoArgsConstructor
public class LevensverzekeringService {

    public Double calculatePremie(Double verzekerdkapitaal, Date geboortedatum, Integer looptijd) {
        if (verzekerdkapitaal == null || geboortedatum == null || looptijd == null) {
            return null;
        } else {
            Integer leeftijd = new Date().getYear() - geboortedatum.getYear();
            Double factor = new Double(leeftijd) / new Double(100);
            Double premie = (verzekerdkapitaal * factor) / looptijd;
            return premie;
        }
    }
    public String getRisicoProfiel(Date geboortedatum) {
        Integer leeftijd = new Date().getYear() - geboortedatum.getYear();
        if (leeftijd >= 60d ) {
            return "risico hoog";
        } else if ((leeftijd >= 30) && (leeftijd < 60)) {
            return "risico matig";
        } else {
            return "risico laag";
        }
    }
    public Double calculateKorting(Double premie, @NonNull Double kortingspercentage) {
        return premie * ((100 - kortingspercentage)/100);
    }
}
