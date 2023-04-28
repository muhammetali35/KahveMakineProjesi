package frontend;

import backend.*;

public class KahveProvider {

    public static Kahve KahveOlustur(String selection) {
        Kahve kahve = null;
        switch (selection) {
            case "türk kahvesi":
                kahve = new TurkKahvesi();
                break;
            case "filtre kahve":
                kahve = new FiltreKahve();
                break;
            case "ekpresso":
                kahve = new Ekpresso();
                break;
            case "cappucino":
                kahve = new Cappucino();
                break;

        }
        return kahve;
    }
}
